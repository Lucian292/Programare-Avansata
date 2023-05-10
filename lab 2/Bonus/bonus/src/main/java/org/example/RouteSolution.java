package org.example;

import java.util.*;

import static java.lang.Math.sqrt;

/**
 Clasa folosita pentru a rezolva problema rutei celei mai scurte - are o implementare a algoritmului lui Dijkstra
 pentru a gasi cea mai scurta cale intre doua locatii folosind drumurile disponibile.
 Locatiile si drumurile sunt generate aleatoriu.
 */

public class RouteSolution {
    private static ArrayList<Road> roads = new ArrayList<>();
    private static ArrayList<Location> locations = new ArrayList<>();

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long initialTime = System.currentTimeMillis();
        RouteSolution sol = new RouteSolution();
        int locationsNumber = 50;
        int roadsNumber = locationsNumber*(locationsNumber+1)/2;
        sol.generateLocations(locationsNumber);
        sol.generateRoads(locationsNumber, roadsNumber);

        List<Location> ans;
        for (int i = 0; i < locationsNumber; i++)
            for (int j = i + 1; j < locationsNumber; j++) {
                ans = sol.findShortestPath(locations.get(i), locations.get(j));
                System.out.println("Shortest path between " + locations.get(i) + " and " + locations.get(j) + " is " + ans);
            }

        long runningTime = System.currentTimeMillis() - initialTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryIncrease = usedMemoryAfter - usedMemoryBefore;
        System.out.println("Running time: " + runningTime + ", memory increase: " + memoryIncrease);
    }

    public ArrayList<Location> findShortestPath(Location start, Location end) {

        // initializam harta distantelelor cu infinit
        // pentru fiecare locatie pastram cea mai scurta distanta gasita
        // pentru inceput - este infinit pentru fiecare locatie
        HashMap<Location, Float> distances = new HashMap<>();
        for (Location location : locations) {
            distances.put(location, Float.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0F);

        // initializam setul de locatii vizitate si harta precedenta
        // in setul de vizitate pastram locatiile vizitate
        // harta precedenta este folosita pentru a printa calea minima reconstruita
        Set<Location> visited = new HashSet<>();
        Map<Location, Location> previous = new HashMap<>();
        RouteProblem problem = new RouteProblem(locations, roads);

        if (!problem.canReach(start, end)) {
            return null; // returnam null daca end nu poate fi atins din start
        }

        // parcurgem toate locatiile
        while (visited.size() < locations.size()) {
            Location current = null;
            Float minDistance = Float.POSITIVE_INFINITY; // distanța minimă este infinit inițial
            // găsim locația nevizitată cu cea mai mică distanță
            // deci - verificăm dacă nu a fost vizitată și dacă distanța curentă este mai mică
            // decât cea pe care am găsit-o deja
            for (Location location : locations) {
                if (!visited.contains(location) && distances.get(location) < minDistance) {
                    current = location;
                    minDistance = distances.get(location);
                }
            }

            if (current == null) { // nu s-a găsit niciun drum către destinație
                return null;
            }

            // marcăm locația curentă ca vizitată
            visited.add(current);

            // actualizăm distanțele locațiilor vecine
            for (Road road : getRoadsFromLocation(current)) { // pentru fiecare drum care pornește de la locația curentă
                Location neighbor = road.getEnd(); // o locație vecină va fi cea care se află la capătul drumului curent
                Float distanceThroughCurrent = distances.get(current) + road.getLength(); // adăugăm la distanța curentă distanța drumului curent
                if (distanceThroughCurrent < distances.get(neighbor)) { // dacă această distanță este mai mică
                    distances.put(neighbor, distanceThroughCurrent); // o adăugăm în mapa de distanțe
                    previous.put(neighbor, current); // și marcam locația anterioară vizitată
                }
            }
        }

        // construim cel mai scurt drum urmând mapa anterioară
        // shortestPath va salva cel mai scurt drum dintre două locații
        ArrayList<Location> shortestPath = new ArrayList<>();
        Location location = end;
        while (previous.containsKey(location)) { // adăugăm la array-ul shortestPath
            // începând de la final
            // până când nu mai putem găsi vecini. ceea ce înseamnă că am ajuns la început
            shortestPath.add(location);
            location = previous.get(location);
        }
        shortestPath.add(start); // adăugăm locația de început
        Collections.reverse(shortestPath);// și inversăm array-ul deoarece am început cu finalul

        return shortestPath;
    }

    private ArrayList<Road> getRoadsFromLocation(Location l) { // returnează drumurile care pornesc de la locația l
        ArrayList<Road> roads = new ArrayList<>();
        for (Road road : RouteSolution.roads) {
            if (road.getStart().equals(l))
                roads.add(road);
        }
        return roads;
    }

    public void generateRoads(int nrLocations, int nrRoads) {
        Random random = new Random();
        //generăm autostrăzi aleatorii
        for (int i = 0; i < nrRoads; i++) {
            Location start = locations.get(random.nextInt(nrLocations)); //alegem o locație aleatorie
            Location end = locations.get(random.nextInt(nrLocations));
            //pentru a genera o stradă validă, adăugăm o constantă float la distanța euclidiană
            //dintre locația de start și cea de final
            float length = random.nextFloat() * 100 + getDistance(start.getX(), start.getY(), end.getX(), end.getY());
            int speedLimit = random.nextInt(100) + 10;
            int lanes = random.nextInt(6);
            if (!start.equals(end)) {
                roads.add(new Highway(length, speedLimit, start, end, lanes));
                roads.add(new Highway(length, speedLimit, end, start, lanes)); // dacă există o stradă de la A la B - strada există și de la B la A
            } else i--; //rămânem la aceeași etapă și generăm din nou start și end;
        }
    }

    public void generateLocations(int nrLocations) {
        Random random = new Random();
        //generăm orașe aleatorii
        for (int i = 0; i < nrLocations; i++) {
            String name = "Orașul " + i;
            int x = random.nextInt(1000); //generează un x aleatoriu mai mic de 1000
            int y = random.nextInt(1000);
            int population = random.nextInt(300_000);
            locations.add(new City(name, x, y, population));
        }
    }


    private float getDistance(float startX, float startY, float endX, float endY) { // metoda folosită pentru a obține distanța euclidiană dintre două locații
        float dist1 = startX - endX;
        float dist2 = startY - endY;
        return (float) sqrt(dist1 * dist1 + (double) (dist2 * dist2));
    }


}
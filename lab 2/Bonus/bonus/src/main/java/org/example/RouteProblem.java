package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Class to represent the best route problem - has an array of roads an array of locations
 * The methods implemented check if a location already exists in the array
 * or if the road already exists in the array and if it is valid or not.
 * The class also has a method called canReach - it checks in a recursive manner if we
 * can reach a location starting from another using the given roads.
 */

public class RouteProblem {
    private ArrayList<Road> roads = new ArrayList<>();
    private ArrayList<Location> locations = new ArrayList<>();

    RouteProblem() {

    }

    RouteProblem(ArrayList<Location> locations, ArrayList<Road> roads) {
        this.locations = locations;
        this.roads = roads;
    }

    public static void main(String[] args) {
        RouteProblem pb = new RouteProblem();
        City one = new City("One", 0, 0, 10_000);
        City two = new City("Two", 3, 4, 20_200);
        GasStation gas1 = new GasStation("GasStation1", 6, 8, 12);
        pb.addLocations(one);
        pb.addLocations(two);
        pb.addLocations(gas1);
        Road road1 = new CountryRoad(10, 40, one, two, "village");
        Road road2 = new Highway(7, 130, two, gas1, 4);
        pb.addRoad(road1);
        pb.addRoad(road2);
        boolean valid = pb.isValid();
        boolean reachable = false;
        if (valid)
            reachable = pb.canReach(one, gas1);
        System.out.println("Is the problem valid? " + valid + " Can you reach location " + gas1 + " from location " + one + "? " + reachable);
    }

    public void setRoads(ArrayList<Road> roads) {
        this.roads = roads;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    private void addLocations(Location l) {
        boolean exists = false;
        for (Location location : locations)
            if (location.equals(l)) // if the location already exists, we don't add it again
            {
                exists = true;
                System.out.println("This location " + l + " already exists");
                break;
            }
        if (!exists)
            locations.add(l);
    }

    private void addRoad(Road r) {
        boolean exists = false;
        for (Road road : roads)
            if (road.equals(r)) {
                exists = true;
                System.out.println("This road " + r + " already exists");
                break;
            }
        if (!exists) // if the road doesn't exist, and it's valid, we add it
            roads.add(r);

    }

    private boolean isValid() {
        // an instance of the problem is valid if there aren't duplicates of the roads and locations
        // which is being checked by the methods addRoad and addLocation
        // and if the roads are valid, so the only thing we check here is if all the roads are valid.
        for (int i = 0; i < roads.size(); i++) {
            for (int j = i + 1; j < roads.size(); j++) {
                if (roads.get(i).equals(roads.get(j)))
                    return false;
            }
        }
        return true;
    }

    public boolean canReach(Location start, Location end) {
        Set<Location> visited = new HashSet<>(); // using a hash set to avoid visiting the same location twice
        return canReachHelper(start, end, visited);
    }

    private boolean canReachHelper(Location current, Location end, Set<Location> visited) {
        if (current.equals(end)) {
            return true;
        }
        visited.add(current);
        for (Road road : roads) // for each existent road
            if (road.getStart() == current && !visited.contains(road.getEnd()) && (canReachHelper(road.getEnd(), end, visited)))
                //if the start is the current value, we haven't reached the end and the method can find a path recursively
                return true;
        visited.remove(current);
        return false;
    }

    @Override
    public String toString() {
        return "RouteProblem{" +
                "roads=" + roads +
                ", locations=" + locations +
                "}\n";
    }
}
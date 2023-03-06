import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BestRouteProblem {
    private List<Location> locations;
    private List<Road> roads;

    public BestRouteProblem() {
        locations = new ArrayList<>();
        roads = new ArrayList<>();
    }

    public boolean addLocation(Location location) {
        if (locations.contains(location)) {
            return false;
        }
        locations.add(location);
        return true;
    }

    public boolean addRoad(Road road) {
        if (roads.contains(road)) {
            return false;
        }
        roads.add(road);
        return true;
    }

    public boolean isValid() {
        // A problem is valid if it has at least two locations and one road.
        return locations.size() >= 2 && roads.size() >= 1;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public boolean isPossibleRoute(Location start, Location end) {
        // Use depth-first search to check if there is a path between start and end.
        // Create a set to keep track of visited locations.
        Set<Location> visited = new HashSet<>();
        return dfs(start, end, visited);
    }

    private boolean dfs(Location current, Location end, Set<Location> visited) {
        // Mark current location as visited.
        visited.add(current);

        // If the end location is reached, return true.
        if (current.equals(end)) {
            return true;
        }

        // Iterate over all roads from the current location.
        for (Road road : getRoadsFrom(current)) {
            // If the destination of the road has not been visited yet, recursively visit it.
            Location destination = getDestination(current, road);
            if (!visited.contains(destination)) {
                if (dfs(destination, end, visited)) {
                    return true;
                }
            }
        }

        // If no path was found, return false.
        return false;
    }

    private List<Road> getRoadsFrom(Location location) {
        List<Road> result = new ArrayList<>();
        for (Road road : getRoads()) {
            if (road.getStart().equals(location)) {
                result.add(road);
            }
        }
        return result;
    }

    private Location getDestination(Location start, Road road) {
        if (road.getStart().equals(start)) {
            return road.getEnd();
        } else {
            return road.getStart();
        }
    }
}

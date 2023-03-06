public class BestRouteProblemMain {
    public static void main(String[] args) {
        BestRouteProblem problem = new BestRouteProblem();

        // Create locations
        CityLocation bucharest = new CityLocation("Bucharest", 2.1);
        AirportLocation henriCoandaAirport = new AirportLocation("Henri Coanda Airport", 1, 3);
        GasStationLocation petromStation = new GasStationLocation("Petrom Station", 2.5, 5);

        // Add locations to the problem instance
        problem.addLocation(bucharest);
        problem.addLocation(henriCoandaAirport);
        problem.addLocation(petromStation);

        // Create roads
        HighwayRoad highway = new HighwayRoad(100, 120);
        ExpresswayRoad expressway = new ExpresswayRoad(50, 90);
        CountryRoad countryRoad = new CountryRoad(10, 70);

        // Add roads to the problem instance
        problem.addRoad(bucharest, henriCoandaAirport, highway);
        problem.addRoad(bucharest, petromStation, countryRoad);
        problem.addRoad(henriCoandaAirport, petromStation, expressway);

        // Check if the problem instance is valid
        if (problem.isValid()) {
            System.out.println("Problem instance is valid.");
        } else {
            System.out.println("Problem instance is invalid.");
            return;
        }

        // Find a route between Bucharest and Petrom Station
        List<Road> route = problem.findRoute(bucharest, petromStation);
        if (route == null) {
            System.out.println("There is no route between Bucharest and Petrom Station.");
        } else {
            System.out.println("Route between Bucharest and Petrom Station:");
            for (Road road : route) {
                System.out.println(road);
            }
        }
    }
}

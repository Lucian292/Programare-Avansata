public class BestRouteProblem {
    public static void main(String[] args) {
        Location location1 = new Location("BUCURESTI", LocationType.CITY, 40.7128, -74.0060);
        Location location2 = new Location("CLUJ-NAPOCA", LocationType.CITY, 34.0522, -118.2437);
        Location location3 = new Location("HENRI COANDA", LocationType.AIRPORT, 34.3522, -119.4437);
        Location location4 = new Location("PETROM", LocationType.GAS_STATION, 155, 22);
        System.out.println(location1);
        System.out.println(location2);
        System.out.println(location3);
        System.out.println(location4);

        Road road1 = new Road(RoadType.HIGHWAY, 3864.03, 120);
        Road road2 = new Road(RoadType.EXPRESSWAY, 2787.54, 90);
        Road road3 = new Road(RoadType.COUNTRY_ROAD, 155.1, 50);

        System.out.println(road1);
        System.out.println(road2);
        System.out.println(road3);
    }
}

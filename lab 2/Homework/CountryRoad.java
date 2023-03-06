public class CountryRoad extends Road {
    private int numCurves;

    public CountryRoad(double length, double speedLimit, int numCurves) {
        super(RoadType.COUNTRY_ROAD, length, speedLimit);
        this.numCurves = numCurves;
    }

    public int getNumCurves() {
        return numCurves;
    }

    public void setNumCurves(int numCurves) {
        this.numCurves = numCurves;
    }
}
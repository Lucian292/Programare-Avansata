public class Highway extends Road {
    private int numLanes;

    public Highway(double length, double speedLimit, int numLanes) {
        super(RoadType.HIGHWAY, length, speedLimit);
        this.numLanes = numLanes;
    }

    public int getNumLanes() {
        return numLanes;
    }

    public void setNumLanes(int numLanes) {
        this.numLanes = numLanes;
    }
}
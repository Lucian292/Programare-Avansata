public class Expressway extends Road {
    private boolean toll;

    public Expressway(double length, double speedLimit, boolean toll) {
        super(RoadType.EXPRESSWAY, length, speedLimit);
        this.toll = toll;
    }

    public boolean isToll() {
        return toll;
    }

    public void setToll(boolean toll) {
        this.toll = toll;
    }
}
import java.util.Objects;

public abstract class Road {
    private Location start;
    private Location end;
    private RoadType type;
    private double length;
    private double speedLimit;

    public Road(Location start, Location end, RoadType type, double length, double speedLimit) {
        this.start = start;
        this.end = end;
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public Location getEnd() {
        return end;
    }

    public void setEnd(Location end) {
        this.end = end;
    }

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Road)) {
            return false;
        }

        Road road = (Road) obj;

        return road.getStart().equals(start) && road.getEnd().equals(end) && road.getType() == type && road.getLength() == length && road.getSpeedLimit() == speedLimit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, type, length, speedLimit);
    }
}

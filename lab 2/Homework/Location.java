import java.util.Objects;


public class Location {
    private String name;
    private LocationType type;
    private double x;
    private double y;

    public Location(String name, LocationType type, double x, double y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.x, x) == 0 &&
                Double.compare(location.y, y) == 0 &&
                Objects.equals(name, location.name) &&
                type == location.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, x, y);
    }

    @Override
    public String toString() {
        return name + " (" + type + "): (" + x + ", " + y + ")";
    }
}

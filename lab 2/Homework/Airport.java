import java.util.Objects;


public class Airport extends Location {
    private int numberOfTerminals;

    public Airport(String name, double latitude, double longitude, int numberOfTerminals) {
        super(name, LocationType.AIRPORT, latitude, longitude);
        this.numberOfTerminals = numberOfTerminals;
    }

    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }

    public void setNumberOfTerminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }

    @Override
    public String toString() {
        return super.toString() + ", number of terminals: " + numberOfTerminals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        if (!super.equals(o)) return false;
        Airport airport = (Airport) o;
        return numberOfTerminals == airport.numberOfTerminals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfTerminals);
    }
}

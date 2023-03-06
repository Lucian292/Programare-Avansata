public class GasStation extends Location {
    private double gasPrice;

    public GasStation(String name, double latitude, double longitude, double gasPrice) {
        super(name, LocationType.GAS_STATION, latitude, longitude);
        this.gasPrice = gasPrice;
    }

    public double getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }

    @Override
    public String toString() {
        return super.toString() + ", gas price: " + gasPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GasStation)) return false;
        if (!super.equals(o)) return false;
        GasStation that = (GasStation) o;
        return Double.compare(that.gasPrice, gasPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gasPrice);
    }
}

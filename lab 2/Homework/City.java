public class City extends Location {
    private int population;

    public City(String name, double latitude, double longitude, int population) {
        super(name, LocationType.CITY, latitude, longitude);
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return super.toString() + ", population: " + population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        if (!super.equals(o)) return false;
        City city = (City) o;
        return population == city.population;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), population);
    }
}

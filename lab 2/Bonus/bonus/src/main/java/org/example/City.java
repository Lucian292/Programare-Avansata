package org.example;

import java.util.Objects;
/**
 * class City - inherits from class Location
 */
public class City extends Location {
    private int population;

    public City(int population) { // constructor for cities with only the population specified
        this.population = population;
    }

    public City(String name, float x, float y, int population) { // constructor for all the attributes
        super(name, x, y);
        this.population = population;
    }
    // setters and getters
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        City city = (City) o;
        return population == city.population;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), population);
    }
}
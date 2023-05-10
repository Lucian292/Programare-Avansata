package org.example;

import java.util.Objects;
/**
 * class CountryRoad - inherits from class Location
 */
public class CountryRoad extends Road {
    private String place;

    public CountryRoad(String place) { // constructor for country roads with only the place specified
        this.place = place;
    }

    public CountryRoad(float length, float speedLimit, Location startLocation, Location endLocation, String place) { // constructor for all the attributes
        super(length, speedLimit, startLocation, endLocation);
        this.place = place;
    }
    // setters and getters
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CountryRoad that = (CountryRoad) o;
        return Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), place);
    }
}
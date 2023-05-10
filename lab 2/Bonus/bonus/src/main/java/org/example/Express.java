package org.example;

import java.util.Objects;
/**
 * class Express - inherits from class Location
 */
public class Express extends Road {
    private int carsPassing;

    public Express(int carsPassing) {  // constructor for express roads with only carsPassing specified
        this.carsPassing = carsPassing;
    }

    public Express(float length, float speedLimit, Location startLocation, Location endLocation, int carsPassing) { // constructor for all the attributes
        super(length, speedLimit, startLocation, endLocation);
        this.carsPassing = carsPassing;
    }
    // setters and getters

    public int getCarsPassing() {
        return carsPassing;
    }

    public void setCarsPassing(int carsPassing) {
        this.carsPassing = carsPassing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Express express = (Express) o;
        return carsPassing == express.carsPassing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carsPassing);
    }
}

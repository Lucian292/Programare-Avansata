package org.example;

import java.util.Objects;
/**
 * class Highway - inherits from class Location
 */
public class Highway extends Road {
    private int lanes;

    public Highway(int lanes) { // constructor for highways with only the number of lanes specified
        this.lanes = lanes;
    }

    public Highway(float length, float speedLimit, Location startLocation, Location endLocation, int lanes) { // constructor for all the attributes
        super(length, speedLimit, startLocation, endLocation);
        this.lanes = lanes;
    }
    // setters and getters
    public int getLanes() {
        return lanes;
    }

    public void setLanes(int lanes) {
        this.lanes = lanes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Highway highway = (Highway) o;
        return lanes == highway.lanes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lanes);
    }
}
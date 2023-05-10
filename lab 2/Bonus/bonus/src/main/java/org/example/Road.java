package org.example;

import java.util.Objects;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * class Road - has a length, speed limit, a start and end of type location and
 * a type of RoadType
 */
public abstract class Road {
    protected Location start;
    protected Location end;
    protected float length;
    protected float speedLimit;

    protected Road() {

    }

    protected Road(float length, float speedLimit, Location startLocation, Location endLocation) {
        this.length = length;
        this.speedLimit = speedLimit;
        this.start = startLocation;
        this.end = endLocation;
    }

    public boolean isValid() { // checks if the road length given is valid - the road length has to be bigger
        // than the euclidean distance between the start and end locations
        float startX = this.start.getX();
        float startY = this.start.getY();
        float endX = this.end.getX();
        float endY = this.end.getY();
        double euclideanDistance = sqrt(pow(endX - startX, 2) + pow(endY - startY, 2));
        return (this.length > euclideanDistance);
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(float speedLimit) {
        this.speedLimit = speedLimit;
    }

    public Location getEnd() {
        return end;
    }

    public void setEnd(Location end) {
        this.end = end;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }


    @Override
    public String toString() {
        return "Road{" +
                "start=" + start +
                ", end=" + end +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return Float.compare(road.length, length) == 0 && Float.compare(road.speedLimit, speedLimit) == 0 && Objects.equals(start, road.start) && Objects.equals(end, road.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, length, speedLimit);
    }
}

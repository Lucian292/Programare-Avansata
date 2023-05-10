package org.example;

import java.util.Objects;

/**
 * class GasStation - inherits from class Location
 */
public class GasStation extends Location {
    private int gasPrice;

    public GasStation(int gasPrice) { // constructor for GasStations with only the gasPrice specified
        this.gasPrice = gasPrice;
    }

    public GasStation(String name, float x, float y, int gasPrice) { // constructor for GasStations with all the attributes specified
        super(name, x, y);
        this.gasPrice = gasPrice;
    }

    // setters and getters

    public int getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(int gasPrice) {
        this.gasPrice = gasPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GasStation that = (GasStation) o;
        return gasPrice == that.gasPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gasPrice);
    }
}
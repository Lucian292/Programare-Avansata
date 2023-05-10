package org.example;

import java.util.Objects;

/**
 * class Airport - inherits from class Location
 */
public class Airport extends Location {
    private int terminals;

    public Airport(int terminals) { // constructor for airports with only the number of terminals specified
        this.terminals = terminals;
    }

    public Airport(String name, float x, float y, int terminals) { // constructor for all the attributes
        super(name, x, y);
        this.terminals = terminals;
    }
    // setters and getters

    public int getTerminals() {
        return terminals;
    }

    public void setTerminals(int terminals) {
        this.terminals = terminals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Airport airport = (Airport) o;
        return terminals == airport.terminals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), terminals);
    }
}

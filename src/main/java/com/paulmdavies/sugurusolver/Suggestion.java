package com.paulmdavies.sugurusolver;

public class Suggestion {
    private final int xCoordinate;
    private final int yCoordinate;
    private final int value;

    public Suggestion(int xCoordinate, int yCoordinate, int value) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Suggestion that = (Suggestion) o;

        if (xCoordinate != that.xCoordinate) return false;
        if (yCoordinate != that.yCoordinate) return false;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        int result = xCoordinate;
        result = 31 * result + yCoordinate;
        result = 31 * result + value;
        return result;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public int getValue() {
        return value;
    }
}

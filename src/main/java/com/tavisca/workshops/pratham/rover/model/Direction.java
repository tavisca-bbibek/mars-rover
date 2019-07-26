package com.tavisca.workshops.pratham.rover.model;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    private static Direction directionArray[] = values();

    public Direction right() {
        return directionArray[mod(this.ordinal() + 1, directionArray.length)];
    }

    public Direction left() {
        return directionArray[mod(this.ordinal() - 1, directionArray.length)];
    }

    private int mod(int a, int b) {
        return ((a % b) + b) % b;
    }
}

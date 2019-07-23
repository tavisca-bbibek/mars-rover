package com.tavisca.workshops.pratham.rover.model;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    private static Direction directionArray[] = values();

    public Direction turnRight(){
        return directionArray[(this.ordinal() + 1) % directionArray.length];
    }

    public Direction turnLeft(){
        return directionArray[(this.ordinal() - 1) % directionArray.length];
    }
}

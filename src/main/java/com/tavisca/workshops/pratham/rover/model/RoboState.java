package com.tavisca.workshops.pratham.rover.model;

public class RoboState {
    private Position position;
    private Direction direction;

    public RoboState(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public RoboState() {
        this(new Position(), Direction.EAST);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}

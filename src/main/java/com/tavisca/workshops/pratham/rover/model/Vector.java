package com.tavisca.workshops.pratham.rover.model;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class Vector {
    public final int y;
    public final int x;
    public final Direction direction;

    public Vector(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Vector left() {
        return new Vector(x, y, direction.left());
    }

    public Vector right() {
        return new Vector(x, y, direction.right());
    }

    public Vector next() {
        switch (direction) {
            case NORTH:
                return new Vector(x, y + 1, direction);
            case EAST:
                return new Vector(x + 1, y, direction);
            case WEST:
                return new Vector(x - 1, y, direction);
            case SOUTH:
                return new Vector(x, y - 1, direction);
            default:
                throw new InvalidParameterException("Invalid direction: " + direction);
        }
    }
}

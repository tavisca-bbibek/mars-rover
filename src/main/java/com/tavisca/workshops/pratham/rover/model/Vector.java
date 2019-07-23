package com.tavisca.workshops.pratham.rover.model;

public class Vector {
    public final int x;
    public final int y;
    public final Direction direction;
    public Vector(int x, int y, Direction direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }


    public Vector turnLeft() {
        return new Vector(x, y, direction.turnLeft());
    }

    public Vector turnRight() {
        return new Vector(x, y, direction.turnRight());
    }
}

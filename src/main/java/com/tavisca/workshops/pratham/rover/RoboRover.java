package com.tavisca.workshops.pratham.rover;

import com.tavisca.workshops.pratham.rover.model.Command;
import com.tavisca.workshops.pratham.rover.model.Vector;

public class RoboRover {
    private Vector vector;

    public RoboRover(Vector initialState) {
        this.vector = initialState;
    }

    public Vector rove(Command command){
        switch(command){
            case TURN_LEFT:
                vector = vector.turnLeft();
                break;
            case TURN_RIGHT:
                vector = vector.turnRight();
                break;
            case MOVE_FORWARD:
                moveForward();
                break;
        }

        return vector;
    }

    public Vector rove(Command[] commands){
        for(Command command : commands) {
            rove(command);
        }
        return vector;
    }

    public void moveForward(){
        switch (vector.direction){
            case NORTH:
                vector = new Vector(vector.x, vector.y + 1, vector.direction);
                break;
            case EAST:
                vector = new Vector(vector.x + 1, vector.y, vector.direction);
                break;
            case SOUTH:
                vector = new Vector(vector.x, vector.y - 1, vector.direction);
                break;
            case WEST:
                vector = new Vector(vector.x - 1, vector.y, vector.direction);
                break;
        }
    }

    public Vector getState() {
        return vector;
    }
}

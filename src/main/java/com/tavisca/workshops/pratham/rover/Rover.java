package com.tavisca.workshops.pratham.rover;

import com.tavisca.workshops.pratham.rover.model.Command;

public class Rover {
    private  Vector vector;

    public Rover(Vector initialVector) {
        vector = initialVector;
    }

    public Vector rove(Command command) {
        switch (command){
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

    private Vector moveForward() {
        return null;
    }

    public Vector vector(){
        return vector;
    }
}

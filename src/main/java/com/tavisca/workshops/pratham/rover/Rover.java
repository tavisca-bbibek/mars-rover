package com.tavisca.workshops.pratham.rover;

import com.tavisca.workshops.pratham.rover.model.Command;
import com.tavisca.workshops.pratham.rover.model.Vector;

public class Rover {
    private Vector vector;

    public Rover(Vector initialVector) {
        vector = initialVector;
    }

    public Vector rove(Command command) {
        switch (command){
            case TURN_LEFT:
                vector = vector.left();
                break;
            case TURN_RIGHT:
                vector = vector.right();
                break;
            case MOVE_FORWARD:
                vector = vector.next();
                break;
        }
        return vector;
    }

    public Vector vector(){
        return vector;
    }
}

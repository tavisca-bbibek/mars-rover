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
        switch (vector.direction){
            case 'N':
                vector = new Vector(vector.x, vector.y + 1, vector.direction);
                break;
            case 'E':
                vector = new Vector(vector.x + 1, vector.y , vector.direction);
                break;
            case 'W':
                vector = new Vector(vector.x - 1, vector.y, vector.direction);
                break;
            case 'S':
                vector = new Vector(vector.x, vector.y - 1, vector.direction);
                break;

        }

        return vector;
    }

    public Vector vector(){
        return vector;
    }
}

package com.tavisca.workshops.pratham.rover;

import com.tavisca.workshops.pratham.rover.model.Command;
import com.tavisca.workshops.pratham.rover.model.Direction;
import com.tavisca.workshops.pratham.rover.model.Position;
import com.tavisca.workshops.pratham.rover.model.RoboState;

public class RoboRober {
    private RoboState state;

    public RoboRober(RoboState initialState) {
        this.state = initialState;
    }

    public RoboRober() {
        this(new RoboState());
    }

    public RoboState rove(Command command){
        switch(command){
            case TURN_LEFT:
                state.setDirection(state.getDirection().turnLeft());
                break;
            case TURN_RIGHT:
                state.setDirection(state.getDirection().turnRight());
                break;
            case MOVE_FORWARD:
                moveForward();
                break;
        }
        return state;
    }

    public RoboState rove(Command[] commands){
        for(Command command : commands) {
            rove(command);
        }
        return state;
    }

    public void moveForward(){
        Position position = state.getPosition();
        switch (state.getDirection()){
            case NORTH:
                position.setY(position.getY() + 1);
                break;
            case EAST:
                position.setX(position.getX() + 1);
                break;
            case SOUTH:
                position.setY(position.getY() - 1);
                break;
            case WEST:
                position.setX(position.getX() - 1);
                break;
        }
    }

    public RoboState getState() {
        return state;
    }
}

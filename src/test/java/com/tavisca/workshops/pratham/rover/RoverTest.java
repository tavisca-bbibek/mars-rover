package com.tavisca.workshops.pratham.rover;

import com.tavisca.workshops.pratham.rover.model.Command;
import com.tavisca.workshops.pratham.rover.model.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

    @Test
    void canCreateRoverWithInitialVector(){
        Vector initialVector = new Vector(0, 0, 'N');

        Rover rover = new Rover(initialVector);

        assertEquals(initialVector, rover.vector());
    }

    @Test
    void roverCanTurnLeft(){
        Vector initialVector = new Vector(0, 0, 'N');
        Rover rover = new Rover(initialVector);

        Vector newVector = rover.rove(Command.TURN_LEFT);

        assertEquals(0, newVector.x);
        assertEquals(0, newVector.y);
        assertEquals('W', newVector.direction);
    }

    @Test
    void roverCanTurnRight(){
        Vector initialVector = new Vector(0, 0, 'N');
        Rover rover = new Rover(initialVector);

        Vector newVector = rover.rove(Command.TURN_RIGHT);

        assertEquals(0, newVector.x);
        assertEquals(0, newVector.y);
        assertEquals('E', newVector.direction);
    }

    @Test
    void roverCanMoveNorth(){
        Vector initialVector = new Vector(0, 0, 'N');
        Rover rover = new Rover(initialVector);

        Vector newVector = rover.rove(Command.MOVE_FORWARD);

        assertEquals(0, newVector.x);
        assertEquals(1, newVector.y);
        assertEquals('N', newVector.direction);
    }
}

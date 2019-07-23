package com.tavisca.workshops.pratham.rover;

import com.tavisca.workshops.pratham.rover.model.Command;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

    @Test
    void canCreateRoverWithInitialVector() {
        Vector initialVector = new Vector(0, 0, 'N');

        Rover rover = new Rover(initialVector);

        assertEquals(initialVector, rover.vector());
    }

    @Test
    void roverCanTurnLeft() {
        Vector initialVector = new Vector(0, 0, 'N');
        Rover rover = new Rover(initialVector);

        Vector newVector = rover.rove(Command.TURN_LEFT);

        assertEquals(0, newVector.x);
        assertEquals(0, newVector.y);
        assertEquals('W', newVector.direction);
    }

    @Test
    void roverCanTurnRight() {
        Vector initialVector = new Vector(0, 0, 'N');
        Rover rover = new Rover(initialVector);

        Vector newVector = rover.rove(Command.TURN_RIGHT);

        assertEquals(0, newVector.x);
        assertEquals(0, newVector.y);
        assertEquals('E', newVector.direction);
    }

    @Test
    void roverCanMoveNorth() {
        Vector initialVector = new Vector(0, 0, 'N');
        Rover rover = new Rover(initialVector);

        Vector newVector = rover.rove(Command.MOVE_FORWARD);

        assertEquals(0, newVector.x);
        assertEquals(1, newVector.y);
        assertEquals('N', newVector.direction);
    }

    @Test
    void roverCanMoveEast() {
        Vector initialVector = new Vector(0, 0, 'E');
        Rover rover = new Rover(initialVector);

        Vector newVector = rover.rove(Command.MOVE_FORWARD);

        assertEquals(1, newVector.x);
        assertEquals(0, newVector.y);
        assertEquals('E', newVector.direction);
    }

    @Test
    void roverCanMoveSouth() {
        Vector initialVector = new Vector(0, 0, 'S');
        Rover rover = new Rover(initialVector);

        Vector newVector = rover.rove(Command.MOVE_FORWARD);

        assertEquals(0, newVector.x);
        assertEquals(-1, newVector.y);
        assertEquals('S', newVector.direction);
    }

    @Test
    void roverCanMoveWest() {
        Vector initialVector = new Vector(0, 0, 'W');
        Rover rover = new Rover(initialVector);

        Vector newVector = rover.rove(Command.MOVE_FORWARD);

        assertEquals(-1, newVector.x);
        assertEquals(0, newVector.y);
        assertEquals('W', newVector.direction);
    }

    @Test
    void roverCanHandleSequenceOfCommands() {
        Vector initialVector = new Vector(3, 3, 'E');
        Rover rover = new Rover(initialVector);

        Command[] commands = {Command.MOVE_FORWARD, Command.MOVE_FORWARD, Command.TURN_RIGHT,
                Command.MOVE_FORWARD, Command.MOVE_FORWARD, Command.TURN_RIGHT, Command.MOVE_FORWARD,
                Command.TURN_RIGHT, Command.TURN_RIGHT};

        for(Command command : commands)
            rover.rove(command);

        Vector newVector = rover.rove(Command.MOVE_FORWARD);

        assertEquals(5, newVector.x);
        assertEquals(1, newVector.y);
        assertEquals('E', newVector.direction);
    }
}

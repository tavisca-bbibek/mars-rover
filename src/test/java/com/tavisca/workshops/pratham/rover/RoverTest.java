package com.tavisca.workshops.pratham.rover;

import com.tavisca.workshops.pratham.rover.model.Command;
import com.tavisca.workshops.pratham.rover.model.Direction;
import com.tavisca.workshops.pratham.rover.model.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

    @Test
    void canCreateRoverWithInitialVector() {
        Vector initialVector = new Vector(0, 0, Direction.NORTH);

        Rover rover = new Rover(initialVector);

        assertEquals(initialVector, rover.vector());
    }

    @Test
    void roverCanTurnLeft() {
        Vector initialVector = new Vector(0, 0, Direction.NORTH);
        Rover rover = new Rover(initialVector);

        Vector newVector = rover.rove(Command.TURN_LEFT);

        assertEquals(0, newVector.x);
        assertEquals(0, newVector.y);
        assertEquals(Direction.WEST, newVector.direction);
    }

    @Test
    void roverCanTurnRight() {
        Vector initialVector = new Vector(0, 0, Direction.NORTH);
        Rover rover = new Rover(initialVector);

        Vector newVector = rover.rove(Command.TURN_RIGHT);

        assertEquals(0, newVector.x);
        assertEquals(0, newVector.y);
        assertEquals(Direction.EAST, newVector.direction);
    }

    @Test
    void roverCanMoveNorth() {
        Vector initialVector = new Vector(0, 0, Direction.NORTH);
        Rover rover = new Rover(initialVector);

        Vector newVector = rover.rove(Command.MOVE_FORWARD);

        assertEquals(0, newVector.x);
        assertEquals(1, newVector.y);
        assertEquals(Direction.NORTH, newVector.direction);
    }

    @Test
    void roverCanMoveEast() {
        Vector initialVector = new Vector(0, 0, Direction.EAST);
        Rover rover = new Rover(initialVector);

        Vector newVector = rover.rove(Command.MOVE_FORWARD);

        assertEquals(1, newVector.x);
        assertEquals(0, newVector.y);
        assertEquals(Direction.EAST, newVector.direction);
    }

    @Test
    void roverCanMoveSouth() {
        Vector initialVector = new Vector(0, 0, Direction.SOUTH);
        Rover rover = new Rover(initialVector);

        Vector newVector = rover.rove(Command.MOVE_FORWARD);

        assertEquals(0, newVector.x);
        assertEquals(-1, newVector.y);
        assertEquals(Direction.SOUTH, newVector.direction);
    }

    @Test
    void roverCanMoveWest() {
        Vector initialVector = new Vector(0, 0, Direction.WEST);
        Rover rover = new Rover(initialVector);

        Vector newVector = rover.rove(Command.MOVE_FORWARD);

        assertEquals(-1, newVector.x);
        assertEquals(0, newVector.y);
        assertEquals(Direction.WEST, newVector.direction);
    }

    @Test
    void roverCanHandleSequenceOfCommands() {
        Vector initialVector = new Vector(3, 3, Direction.EAST);
        Rover rover = new Rover(initialVector);

        Command[] commands = {Command.MOVE_FORWARD, Command.MOVE_FORWARD, Command.TURN_RIGHT,
                Command.MOVE_FORWARD, Command.MOVE_FORWARD, Command.TURN_RIGHT, Command.MOVE_FORWARD,
                Command.TURN_RIGHT, Command.TURN_RIGHT};

        for(Command command : commands)
            rover.rove(command);

        Vector newVector = rover.rove(Command.MOVE_FORWARD);

        assertEquals(5, newVector.x);
        assertEquals(1, newVector.y);
        assertEquals(Direction.EAST, newVector.direction);
    }
}

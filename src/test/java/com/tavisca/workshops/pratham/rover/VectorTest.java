package com.tavisca.workshops.pratham.rover;

import com.tavisca.workshops.pratham.rover.model.Direction;
import com.tavisca.workshops.pratham.rover.model.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VectorTest {


    @Test
    void vectorInitializesWithStartingPosition(){
        Vector r = new Vector(10, 10, Direction.NORTH);
        assertEquals(10, r.x);
        assertEquals(10, r.y);
        assertEquals(Direction.NORTH, r.direction);
    }

    @Test
    void vectorCanRotateLeftFromNorth(){
        Vector r = new Vector(10, 10, Direction.NORTH);
        Vector newVector = r.left();
        assertEquals(Direction.WEST, newVector.direction);
    }

    @Test
    void vectorCanRotateLeftFromEast(){
        Vector r = new Vector(10, 10, Direction.EAST);
        Vector newVector = r.left();
        assertEquals(Direction.NORTH, newVector.direction);
    }

    @Test
    void vectorCanRotateLeftFromSouth(){
        Vector r = new Vector(10, 10, Direction.SOUTH);
        Vector newVector = r.left();
        assertEquals(Direction.EAST, newVector.direction);
    }

    @Test
    void vectorCanRotateLeftFromWest(){
        Vector r = new Vector(10, 10, Direction.WEST);
        Vector newVector = r.left();
        assertEquals(Direction.SOUTH, newVector.direction);
    }

    @Test
    void vectorCanRotateRightFromNorth(){
        Vector r = new Vector(10, 10, Direction.NORTH);
        Vector newVector = r.right();
        assertEquals(Direction.EAST, newVector.direction);
    }

    @Test
    void vectorCanRotateRightFromEast(){
        Vector r = new Vector(10, 10, Direction.EAST);
        Vector newVector = r.right();
        assertEquals(Direction.SOUTH, newVector.direction);
    }

    @Test
    void vectorCanRotateRightFromSouth(){
        Vector r = new Vector(10, 10, Direction.SOUTH);
        Vector newVector = r.right();
        assertEquals(Direction.WEST, newVector.direction);
    }

    @Test
    void vectorCanRotateRightFromWest(){
        Vector r = new Vector(10, 10, Direction.WEST);
        Vector newVector = r.right();
        assertEquals(Direction.NORTH, newVector.direction);
    }

}

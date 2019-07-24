package com.tavisca.workshops.pratham.rover;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class VectorTest {


    @Test
    void vectorInitializesWithStartingPosition(){
        Vector r = new Vector(10, 10, 'N');
        assertEquals(10, r.x);
        assertEquals(10, r.y);
        assertEquals('N', r.direction);
    }

    @Test
    void constructionWithInvalidParameterThrowsInvalidParameterException(){
        try{
            Vector r = new Vector(10, 10, 'I');
        }catch (InvalidParameterException e){
            return;
        }

        fail();
    }

/*    @Test
    void vectorCanRotateLeftFromNorth(){
        Vector r = new Vector(10, 10, 'N');
        Vector newVector = r.left();
        assertEquals('W', newVector.direction);
    }

    @Test
    void vectorCanRotateLeftFromEast(){
        Vector r = new Vector(10, 10, 'E');
        Vector newVector = r.left();
        assertEquals('N', newVector.direction);
    }

    @Test
    void vectorCanRotateLeftFromSouth(){
        Vector r = new Vector(10, 10, 'S');
        Vector newVector = r.left();
        assertEquals('E', newVector.direction);
    }

    @Test
    void vectorCanRotateLeftFromWest(){
        Vector r = new Vector(10, 10, 'W');
        Vector newVector = r.left();
        assertEquals('S', newVector.direction);
    }

    @Test
    void vectorCanRotateRightFromNorth(){
        Vector r = new Vector(10, 10, 'N');
        Vector newVector = r.right();
        assertEquals('E', newVector.direction);
    }

    @Test
    void vectorCanRotateRightFromEast(){
        Vector r = new Vector(10, 10, 'E');
        Vector newVector = r.right();
        assertEquals('S', newVector.direction);
    }

    @Test
    void vectorCanRotateRightFromSouth(){
        Vector r = new Vector(10, 10, 'S');
        Vector newVector = r.right();
        assertEquals('W', newVector.direction);
    }

    @Test
    void vectorCanRotateRightFromWest(){
        Vector r = new Vector(10, 10, 'W');
        Vector newVector = r.right();
        assertEquals('N', newVector.direction);
    }*/

}

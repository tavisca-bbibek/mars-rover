package com.tavisca.workshops.pratham.rover;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class Vector {
    public final int y;
    public final int x;
    public final char direction;

    private static final Map<Character, Character> leftMap
            = new HashMap<>() {{
        put('N', 'W');
        put('E', 'N');
        put('S', 'E');
        put('W', 'S');
    }};

    private static final Map<Character, Character> rightMap
            = new HashMap<>() {{
        put('N', 'E');
        put('E', 'S');
        put('S', 'W');
        put('W', 'N');
    }};

    public Vector(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        if (direction == 'N' || direction == 'E' || direction == 'S' || direction == 'W')
            this.direction = direction;
        else
            throw new InvalidParameterException("Invalid direction.");
    }

    public Vector left() {
        return new Vector(x, y, leftMap.get(direction));
    }

    public Vector right() {
        return new Vector(x, y, rightMap.get(direction));
    }

    public Vector next() {
        switch (direction) {
            case 'N':
                return new Vector(x, y + 1, direction);
            case 'E':
                return new Vector(x + 1, y, direction);
            case 'W':
                return new Vector(x - 1, y, direction);
            case 'S':
                return new Vector(x, y - 1, direction);
            default:
                throw new InvalidParameterException("Invalid direction: " + direction);
        }
    }

   /* public Vector left() {
        char[] directions = {'N', 'E', 'S', 'W'};
        int i;
        for(i = 0; i < directions.length; i++){
            if(direction == directions[i])
                break;
        }
        i--;
        return new Vector(x, y, directions[
                mod(i, directions.length)
                ]);
    }

    private int mod(int a, int b){
        return ((a % b) + b)%b;
    }*/
}

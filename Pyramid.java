/*
 * Filename: Pyramid.java
 * ---------------------------------------
 * Author: Jts76 | Jts76@me.com
 * ---------------------------------------
 *
 * This program creates a pyramid out of bricks using an integer
 * as the number of bricks for the first row.
 * Each row uses 1 less brick than the last all the way down to one.
 *
 */
import acm.program.*;
import acm.graphics.*;

public class Pyramid extends GraphicsProgram{

    public void run(){
        int startWidth = getWidth() / 2 - (BRICK_WIDTH * (BRICKS_IN_BASE / 2));
        int startHeight = getHeight() / 2 + (BRICK_HEIGHT * (BRICKS_IN_BASE / 2));
        int dx = startWidth;
        int dy = startHeight;
        for (int i = BRICKS_IN_BASE; i > 0; i--) {
            makeBrick(startWidth, startHeight);
        }
    }
    private void makeBrick(int cx, int cy){
        GRect brick = new GRect(cx, cy, BRICK_WIDTH, BRICK_HEIGHT);
        add (brick);
    }

    /* Class Variables
     * ---------------------------------------- */


    /* Constants
     * ---------------------------------------- */
    private static final int BRICK_WIDTH = 30;
    private static final int BRICK_HEIGHT = 10;
    private static final int BRICKS_IN_BASE = 12;

}


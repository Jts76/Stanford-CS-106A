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
        int numBricks = BRICKS_IN_BASE;
        int brickX = startWidth;
        for (int row = 0; row < BRICKS_IN_BASE; row++){

            for (int brick = 0; brick < numBricks; brick++) {
                makeBrick(brickX, startHeight);
                brickX += BRICK_WIDTH;
            }
            startHeight -= BRICK_HEIGHT;
            startWidth += BRICK_WIDTH / 2;
            brickX = startWidth;
            numBricks--;

        }
    }
    private void makeBrick(int cx, int cy){
        GRect brick = new GRect(cx, cy, BRICK_WIDTH, BRICK_HEIGHT);
        add (brick);
    }


    /* Constants
     * ---------------------------------------- */
    private static final int BRICK_WIDTH = 30;
    private static final int BRICK_HEIGHT = 10;
    private static final int BRICKS_IN_BASE = 12;

}


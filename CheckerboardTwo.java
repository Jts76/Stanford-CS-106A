/*
 * Filename: CheckerboardTwo.java
 * ---------------------------------------
 * Author: Jts76 | Jts76@me.com
 * ---------------------------------------
 *
 * Attempt at checkerboard
 *
 */


import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

public class CheckerboardTwo extends GraphicsProgram {

    /* The number of rows in the checkerboard */
    public static final int NUM_ROWS = 8;

    /* The number of columns in the checkerboard */
    public static final int NUM_COLS = 8;

    public void run(){
        int sqSize = getHeight() / NUM_ROWS;
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                int x = j * sqSize;
                int y = i * sqSize;
                GRect square = new GRect(x, y, sqSize, sqSize);
                square.setFilled(((i+j) % 2) != 0);
                square.setFillColor(Color.ORANGE);
                add(square);
            }
        }

    }

}

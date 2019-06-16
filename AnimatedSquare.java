/*
 * Filename: AnimatedSquare.java
 * ---------------------------------------
 * Author: Jts76 | Jts76@me.com
 * ---------------------------------------
 *
 * This program animates a square so that it moves from the
 * upper left corner of the window to the lower right corner.
 *
 */


import acm.program.*;
import acm.graphics.*;

public class AnimatedSquare extends GraphicsProgram {

    public void run() {
        GRect square = new GRect(0, 0, SQUARE_SIZE, SQUARE_SIZE);
        square.setFilled(true);
        add(square);
        double dx = (getWidth() - SQUARE_SIZE) / N_STEPS;
        double dy = (getHeight() - SQUARE_SIZE) / N_STEPS;
        for (int i = 0; i < N_STEPS; i++) {
            square.move(dx, dy);
            pause(PAUSE_TIME);
        }

    }
/*
 *  CONSTANTS
 *  ================================== */
    private static final int N_STEPS = 4000;
    private static final int PAUSE_TIME = 5;
    private static final double SQUARE_SIZE = 50;

}

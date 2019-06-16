/*
 * Filename: BouncingBall.java
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

import java.awt.*;

public class BouncingBall extends GraphicsProgram {

    public void run() {
        GOval oval = new GOval(getWidth() / 2.0 - OVAL_SIZE, getHeight() / 2.0 - OVAL_SIZE, OVAL_SIZE, OVAL_SIZE);
        oval.setFilled(true);
        oval.setFillColor(Color.ORANGE);
        add(oval);
        double dx = (getWidth() - OVAL_SIZE) / N_STEPS;
        double dy = (getHeight() - OVAL_SIZE) / N_STEPS * 1.75;
        while (true) {
            if(oval.getX() + OVAL_SIZE >= getWidth() - 1) {
                dx = -dx;
            } else if( oval.getX() <= 0) {
                dx = (getWidth() - OVAL_SIZE) / N_STEPS;
            } else if(oval.getY() + OVAL_SIZE >= getHeight()) {
                dy = -dy;
            } else if(oval.getY() <= 0) {
                dy = (getHeight() - OVAL_SIZE) / N_STEPS;
            }

            oval.move(dx, dy);
            pause(PAUSE_TIME);
        }

    }
/*
 *  CONSTANTS
 *  ================================== */
    private static final int N_STEPS = 1000;
    private static final int PAUSE_TIME = 7;
    private static final double OVAL_SIZE = 50;

}

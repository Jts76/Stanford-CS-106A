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
import acm.util.RandomGenerator;

import java.awt.*;

public class BouncingBall extends GraphicsProgram {

    public void run() {
        GOval oval = new GOval(getWidth() / 2.0 - OVAL_SIZE, getHeight() / 2.0 - OVAL_SIZE, OVAL_SIZE, OVAL_SIZE);
        oval.setFilled(true);
        oval.setFillColor(Color.ORANGE);
        add(oval);
        RandomGenerator rgen = RandomGenerator.getInstance();
        double rGen = 0;
        double dx = (getWidth() - OVAL_SIZE) / N_STEPS;
        double dy = (getHeight() - OVAL_SIZE) / N_STEPS;
        while (true) {
            if(oval.getX() + OVAL_SIZE >= getWidth() - 1) {
                dx = -dx;
            } else if( oval.getX() <= 0) {
                dx = ((getWidth() - OVAL_SIZE) / N_STEPS)  * rGen;
                rGen = rgen.nextDouble(1.0, 1.25);
                println(rGen);

            } else if(oval.getY() + OVAL_SIZE >= getHeight()) {
                dy = -dy;
            } else if(oval.getY() <= 0) {
                dy = ((getHeight() - OVAL_SIZE) / N_STEPS)  * rGen;
                rGen = rgen.nextDouble(1.0, 1.25);
                println(rGen);

            }
            oval.move(dx, dy);
            pause(PAUSE_TIME);
        }

    }
/*
 *  CONSTANTS
 *  ================================== */
    private static final int N_STEPS = 1000;
    private static final int PAUSE_TIME = 3;
    private static final double OVAL_SIZE = 50;

}

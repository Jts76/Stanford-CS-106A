/*
 * Filename: Headline.java
 * ---------------------------------------
 * Author: Jts76 | Jts76@me.com
 * ---------------------------------------
 *
 * This program draws a scrolling headline in the Graphics window.
 *
 */

import acm.graphics.*;
import acm.program.*;

public class Headline extends GraphicsProgram {

    public void run() {
        GLabel headline = new GLabel(HEADLINE, getWidth(), getHeight() / 2);
        double lx = getWidth() / N_STEPS;
        // double ly = getHeight() / 2;
        headline.setFont("*-*-60");
        add(headline);
        while(headline.getX() + headline.getWidth() > 0) {
            headline.move(-lx, 0);
            pause(PAUSE);
        }
    }

/*
 *  CONSTANTS
 *  ================================== */
    private static final String HEADLINE = "Extra, Extra, Read all about it!!";
    private static final int N_STEPS = 500;
    private static final int PAUSE = 10;

}

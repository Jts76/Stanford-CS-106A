/*
 * Filename: Checkerboard.java
 * ---------------------------------------
 * Author: The Art & Science of Java
 *         Figure 4-9, Page 123
 * EDITED BY: Jts76 | Jts76@me.com
 * ---------------------------------------
 *
 * This program draws a checkerboard.  The dimensions of the
 * checkerboard are specified by the constants N_ROWS and
 * N_COLUMNS, and the size of the squares is chosen so
 * that the checkerboard fills the available vertical space.
 *
 */

import acm.program.*;
import acm.graphics.*;

import java.awt.*;

public class Checkerboard extends GraphicsProgram {

    public void run() {
        double sqSize = (double) getHeight() / N_ROWS;
        for (int i = 0; i < N_ROWS; i++) {
            for (int j = 0; j < N_COLUMNS; j++){
                double x = j * sqSize - (N_ROWS / 2.0) * sqSize + (double) getWidth() / 2;
                double y = i * sqSize;
                GRect sq = new GRect(x, y, sqSize, sqSize);
                sq.setFilled((i + j) % 2 != 0);
                sq.setFillColor(Color.GRAY);
                add(sq);
                GOval oval = new GOval(x + sqSize * .1, y + sqSize * .1, sqSize *.8, sqSize *.8);
                oval.setFilled(true);
                if (i < 3) {
                    oval.setFillColor(Color.RED);
                } else {
                    oval.setFillColor(Color.BLACK);

                }
                if ((i + j) % 2 != 0 && i < 3 || (i + j) % 2 != 0 && i > 4) {
                    add(oval);
                }
            }
        }
    }

/*
 *  CONSTANTS
 *  ================================== */
    private static final int N_ROWS = 8;
    private static final int N_COLUMNS = 8;

}
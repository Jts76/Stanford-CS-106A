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
        /* The square size is the height of the windows divided
         * by the number of rows wanted. */
        double sqSize = (double) getHeight() / N_ROWS;
        for (int i = 0; i < N_ROWS; i++) {
            for (int j = 0; j < N_COLUMNS; j++){
                double x = j * sqSize - (N_ROWS / 2.0) * sqSize + (double) getWidth() / 2;
                double y = i * sqSize;
                GRect sq = new GRect(x, y, sqSize, sqSize);
                /* Fill the Odd squares */
                sq.setFilled((i + j) % 2 != 0);
                sq.setFillColor(Color.GRAY);
                add(sq);
                /* Create the circle checker pieces, their size is 80% of the board squares
                 * and they have a 10% cushion */
                GOval oval = new GOval(x + sqSize * .1, y + sqSize * .1, sqSize *.8, sqSize *.8);

                /* Fill the top 3 rows red and the bottom 3 rows black.
                 * Technically if you were to add more pieces in the middle
                 * everything but the first 3 rows would be black. */
                oval.setFilled(true);
                if (i < 3) {
                    oval.setFillColor(Color.RED);
                } else {
                    oval.setFillColor(Color.BLACK);

                }
                /* add the pieces to the first 3 rows and the last 3 rows. */
                if ((i + j) % 2 != 0 && i < 3 || (i + j) % 2 != 0 && i > 4) {
                    add(oval);
                }
            }
        }
    }

/*
 *  Private CONSTANTS
 *  ================================== */
    private static final int N_ROWS = 8;
    private static final int N_COLUMNS = 8;

}
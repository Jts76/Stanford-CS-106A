/*
 * Filename: Target.java
 *
 * This program draws a 3 ring archery target that
 * alternates red and white fill colors with the
 * ring and inner bullseye being red
 */

import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class Target extends GraphicsProgram {

    public void run() {
        int centerWidth = getWidth() / 2;
        int centerHeight = getHeight() / 2;
        drawCircle(centerWidth - TARGET_WIDTH / 2, centerHeight - TARGET_HEIGHT / 2,
                TARGET_WIDTH, TARGET_HEIGHT, Color.RED);
        drawCircle(centerWidth - (TARGET_WIDTH * .65) / 2, centerHeight - (TARGET_HEIGHT * .65) / 2,
                TARGET_WIDTH * .65, TARGET_HEIGHT * .65, Color.WHITE);
        drawCircle(centerWidth - (TARGET_WIDTH * .3) / 2, centerHeight - (TARGET_HEIGHT * .3) / 2,
                TARGET_WIDTH * .3, TARGET_HEIGHT * .3, Color.RED);
    }

    private void drawCircle(double cx, double cy, double cWidth, double cHeight, Color color) {
        GOval circle = new GOval(cx, cy, cWidth, cHeight);
        circle.setFilled(true);
        circle.setFillColor(color);
        add(circle);
    }

    private static final int TARGET_WIDTH = 90;
    private static final int TARGET_HEIGHT = 90;

}
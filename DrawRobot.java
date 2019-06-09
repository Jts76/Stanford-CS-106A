/*
 * Filename: DrawRobot.java
 * ---------------------------------------
 * Author: Jts76 | Jts76@me.com
 * ---------------------------------------
 *
 * This program draws a gray robot face on the canvas
 * with yellow eyes and a white mouth.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class DrawRobot extends GraphicsProgram {

    public void run () {
        drawHead();
        drawEyes();
        drawMouth();
    }

    private void drawHead(){
        GRect head = new GRect ((getWidth() / 2) - (HEAD_WIDTH / 2), (getHeight() / 2) - (HEAD_HEIGHT / 2), HEAD_WIDTH, HEAD_HEIGHT);
        head.setFilled(true);
        head.setFillColor(Color.GRAY);
        add (head);
    }

    private void drawEyes(){
        GOval eye1 = new GOval (((getWidth() / 2) - (HEAD_WIDTH / 4)) - EYE_RADIUS, ((getHeight() / 2) - (HEAD_HEIGHT / 4)) - EYE_RADIUS, EYE_RADIUS * 2, EYE_RADIUS * 2);
        GOval eye2 = new GOval (((getWidth() / 2) + (HEAD_WIDTH / 4)) - EYE_RADIUS, ((getHeight() / 2) - (HEAD_HEIGHT / 4)) - EYE_RADIUS, EYE_RADIUS * 2, EYE_RADIUS * 2);
        eye1.setFilled(true);
        eye1.setFillColor(Color.YELLOW);
        eye2.setFilled(true);
        eye2.setFillColor(Color.YELLOW);
        add (eye1);
        add (eye2);

    }
    private void drawMouth(){
        GRect mouth = new GRect  ((getWidth() / 2) - (MOUTH_WIDTH / 2), (getHeight() / 2) + (HEAD_HEIGHT / 4), MOUTH_WIDTH, MOUTH_HEIGHT);
        mouth.setFilled(true);
        mouth.setFillColor(Color.WHITE);
        add (mouth);
    }

    /* Constants */

    private static final int HEAD_WIDTH = 220;
    private static final int HEAD_HEIGHT = 300;
    private static final int EYE_RADIUS = 25;
    private static final int MOUTH_WIDTH = 120;
    private static final int MOUTH_HEIGHT = 30;
}
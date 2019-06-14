/*
 * Filename: DrawHouse.java
 * ---------------------------------------
 * Author: Jts76 | Jts76@me.com
 * ---------------------------------------
 *
 * This program draws a house with 2 windows a door and a doorknob.
 *
 */


import acm.program.*;
import acm.graphics.*;


public class DrawHouse extends GraphicsProgram {

    public void run() {
        double start_x = (getWidth() / 2.0) - (HOUSE_WIDTH / 2.0);
        double start_y = (getHeight() / 2.0) - (HOUSE_HEIGHT / 3.0);

        // Create and add the house frame to the canvas
        GRect house = new GRect(start_x, start_y, HOUSE_WIDTH, HOUSE_HEIGHT);

        add(house);

        // Create and add the first window
        GRect win1 = new GRect(start_x + HOUSE_HEIGHT * cushion, start_y + HOUSE_HEIGHT * cushion,
                WINDOW_WIDTH, WINDOW_HEIGHT);

        add(win1);

        // Create and add the second window
        GRect win2 = new GRect(start_x + ((HOUSE_WIDTH - HOUSE_HEIGHT * cushion) - WINDOW_WIDTH),
                start_y + HOUSE_HEIGHT * cushion, WINDOW_WIDTH, WINDOW_HEIGHT);

        add(win2);

        // Create and add the door
        GRect door = new GRect((start_x + (HOUSE_WIDTH /2) - (DOOR_WIDTH / 2)), start_y + HOUSE_HEIGHT * .20,
                DOOR_WIDTH, DOOR_HEIGHT);

        add(door);

        // Create the doorknob
        GOval doorknob = new GOval((start_x + HOUSE_WIDTH / 2 + DOOR_WIDTH /2 - DOORKNOB * 1.5),
                start_y + HOUSE_HEIGHT - DOOR_HEIGHT / 2, DOORKNOB, DOORKNOB);

        add(doorknob);

        // Create the roof
        GLine roof1 = new GLine(start_x, start_y, start_x + HOUSE_WIDTH / 2, start_y - HOUSE_HEIGHT / 2);

        add(roof1);

        GLine roof2 = new GLine(start_x + HOUSE_WIDTH, start_y, start_x + HOUSE_WIDTH / 2, start_y - HOUSE_HEIGHT / 2);

        add(roof2);


    }

    /*Constants*/
    private static final double HOUSE_WIDTH = 400;
    private static final double HOUSE_HEIGHT = 200;
    private static final double WINDOW_WIDTH = HOUSE_WIDTH * .25;
    private static final double WINDOW_HEIGHT = HOUSE_HEIGHT * .40;
    private static final double DOOR_WIDTH = HOUSE_WIDTH * .25;
    private static final double DOOR_HEIGHT = HOUSE_HEIGHT * .80;
    private static final double DOORKNOB = DOOR_WIDTH * .10;

    /* The distance from the side / top of the house to the windows
    This value is a % of the house height */
    private static final double  cushion = .12;

}

/*
 * Filename: AreaFromRadius.java
 * ---------------------------------------
 * Author: Jts76 | Jts76@me.com
 * ---------------------------------------
 *
 * This program calculates the area of a circle given the radius from the user.
 * Author: Jts76 | Jts76@me.com
 */

import acm.program.*;


public class AreaFromRadius extends ConsoleProgram {
    public void run() {
        println("Given the radius, this program will calculate the Area of a circle.");
        int radius = readInt("Enter an integer for the radius:");
        double area = PI * (radius * radius );
        println("The area of your circle is: " + area);
    }
    /* Constant Class Variables
     * -----------------------------------------
     */
    private static final double PI = 3.14;

}

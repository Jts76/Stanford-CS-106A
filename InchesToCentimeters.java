/*
 * File: InchesToCentimeters.java
 * ---------------------------------------
 * Author: Jts76 | Jts76@me.com
 * ---------------------------------------
 *
 * This program converts inches to centimeters.
 */
import acm.program.*;
public class InchesToCentimeters extends ConsoleProgram {
    public void run() {
        println("This program converts inches to centimeters.");
        int feet = readInt("Enter number of feet: ");
        int inches = readInt("Enter number of inches: ");
        double cm = ((feet * INCHES_PER_FOOT) + inches) * CENTIMETERS_PER_INCH;
        println(feet + "ft " + inches + "in = " + cm + "cm");
    }
    private static final double CENTIMETERS_PER_INCH = 2.54;
    private static final int INCHES_PER_FOOT = 12;
}
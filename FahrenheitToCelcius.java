/*
 * Filename: FahrenheitToCelcius.java
 * ---------------------------------------
 * Author: Jts76 | Jts76@me.com
 * ---------------------------------------
 *
 * This program converts Fahrenheit to Celcius!
 * Author: Jts76 | Jts76@me.com
 */
import acm.program.*;

public class FahrenheitToCelcius extends ConsoleProgram{
    public void run(){
        println("Convert Fahrenheit to Celcius!");
        int fahrenheit = readInt("Enter a temperature in Fahrenheit:");
        double celcius = (fahrenheit -32) * .56;
        println(fahrenheit + " degrees fahrenheit is " + (int)celcius + " degrees celcius!");
    }
}

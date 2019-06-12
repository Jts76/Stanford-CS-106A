/*
 * Filename: FahrenheitToCelsius.java
 * ---------------------------------------
 * Author: Jts76 | Jts76@me.com
 * ---------------------------------------
 *
 * This program converts Fahrenheit to Celcius!
 * Author: Jts76 | Jts76@me.com
 */
import acm.program.*;

public class FahrenheitToCelsius extends ConsoleProgram{
    public void run(){
        println("Convert Fahrenheit to Celsius!");
        int fahrenheit = readInt("Enter a temperature in Fahrenheit:");
        double celsius = (fahrenheit -32) * .56;
        println(fahrenheit + " degrees fahrenheit is " + (int)celsius + " degrees celsius!");
    }
}

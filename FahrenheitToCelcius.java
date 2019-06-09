/* Filename: FahrenheitToCelcius.java
 * =====================================
 * This program converts Fahrenheit to Celcius!
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

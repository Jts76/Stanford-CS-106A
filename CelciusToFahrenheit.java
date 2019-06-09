/* Filename: CelciusToFahrenheit.java
 * =================================================
 * This program converts Celcius to Fahrenheit
 */
import acm.program.*;

public class CelciusToFahrenheit extends ConsoleProgram{
    public void run(){
        println("Convert Celcius to Fahrenheit!");
        int celcius = readInt("Enter a temperature in Celcius:");
        double fahrenheit = celcius * 1.8 + 32;
        println(celcius + " degrees celcius is " + (int)fahrenheit + " degrees fahrenheit!");
    }
}

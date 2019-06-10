/*
 * Filename: FirstOddIntegers.java
 * ---------------------------------------
 * Author: Jts76 | Jts76@me.com
 * ---------------------------------------
 *
 * This program takes an integer value from the user and adds all odd integers
 * starting at one and using how ever many numbers the user picked.
 * Ex. If the user picked 4 it would add the first 4 odd integers (1+3+5+7)
 *
 */

import acm.program.*;

public class FirstOddIntegers extends ConsoleProgram{

    public void run(){
        int n = readInt("How many odd integers would you like to add?");
        int total = 0;
        int i = 1;
        while (n != 0){
            if (i % 2 != 0){
               total += i;
               println(i + " +");
               n--;
            }
            i++;
        }
        println("equals " + total);
    }
}

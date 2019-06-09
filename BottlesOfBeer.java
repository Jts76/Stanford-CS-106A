/*
 * Filename: BottlesOfBeer.java
 * ---------------------------------------
 * Author: Jts76 | Jts76@me.com
 * ---------------------------------------
 *
 * This program recites the 99 bottles of bear on the wall poem
 * using a custom number of bottles!
 */

import acm.program.ConsoleProgram;


public class BottlesOfBeer extends ConsoleProgram {
    public void run(){
        // Get the number of bottles from the user.
        int bottles = readInt("How many bottles would you like to use?");
        println("");
        // As long as there are bottles, print the poem.
        while (bottles > 0) {
                println(bottles + " bottles of beer on the wall.");
                println(bottles + " bottles of beer.");
                println("You take one down, pass it around.");
                bottles--; // The decrementor is placed here to remove a bottle after one is taken down.
                println(bottles + " bottles of beer on the wall.");
                println("");
        }
    }


}

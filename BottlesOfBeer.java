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
        int bottles = TOTAL_BOTTLES;
        while (bottles > 0) {
                println(bottles + " bottles of beer on the wall.");
                println(bottles + " bottles of beer.");
                println("You take one down, pass it around.");
                bottles--;
                println(bottles + " bottles of beer on the wall.");
                println("");
        }
    }

    /* Contants */
    private static final int TOTAL_BOTTLES = 5;

}

/*
 * Filename: DivisibleBySixOrSeven.java
 * ---------------------------------------
 * Author: Jts76 | Jts76@me.com
 * ---------------------------------------
 *
 * This program displays all integers between 1 and 100 that are divisible by
 * Six or Seven but not both.
 */

import acm.program.ConsoleProgram;


public class DivisibleBySixOrSeven extends ConsoleProgram {

    public void run(){
        int i = 1;
        while (i < MAX_INTEGER) {
            if (((i % 6 == 0) && !(i % 7 == 0)) || ((i % 7 == 0) && !(i % 6 == 0))) {
                println(i);
            }
            i++;
        }
    }

    /* Class Variables
    * -----------------------------*/
    private static int MAX_INTEGER = 100;
}


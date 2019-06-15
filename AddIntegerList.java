/*
 * Filename: AddIntegerList.java
 * ---------------------------------------
 * Author: The Art & Science of Java
 *         Figure 4-2 page 104
 * ---------------------------------------
 *
 * This program reads integers one per line until the
 * user enters a special sentinel value to signal the
 * end of the input.  At that point, the program
 * prints the sum of the numbers entered so far.
 *
 */


import acm.program.ConsoleProgram;

public class AddIntegerList extends ConsoleProgram {
    public void run(){
        println("This program adds a list of integers.");
        println("Enter values, one per line, using " + SENTINEL);
        println("to signal the end of the list.");
        int total = 0;
        while (true) {
            int value = readInt("?");
            if (value == SENTINEL) break;
            total += value;
        }
        println("The total is " + total + ".");
    }

    /* CONSTANTS
     *---------------------------------------------*/
    private static final int SENTINEL = 0;
}

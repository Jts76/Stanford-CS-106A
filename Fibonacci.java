/*
 * Filename: Fibonacci.java
 * ---------------------------------------
 * Author: Jts76 | Jts76@me.com
 * ---------------------------------------
 *
 * This program prints the Fibonacci sequence!
 *
 */
import acm.program.ConsoleProgram;

public class Fibonacci extends ConsoleProgram {

    public void run() {
        println("This Program lists the Fobonacci Sequence.");
        int t1 = 0;
        int t2 = 1;

        while (t1 <= MAX_TERM_VALUE) {
            println (t1);
            int t3 = t1 + t2;
            t1 = t2;
            t2 = t3;
        }
    }
    /*
    * Constant Variables
    * Used to set the max value of the Fibonacci sequence
    */
    private static final int MAX_TERM_VALUE = 10000;

}

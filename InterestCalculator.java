/* File: InterestCalculator.java
 * ------------------------------------------------------------
 * This program takes a balance and interest rate from the user
 * and calculates the interest for the year.
 */

import acm.program.*;

public class InterestCalculator extends ConsoleProgram {
    public void run(){
        println("Interest calculation program");
        int balance = readInt("Enter starting balance:");
        double interestRate = readDouble("Enter Annual Interest Rate:") / 100;
        double total = (double) balance + (balance * interestRate);
        println("Balance after one year = " + total);
        println("Balance after two years = " + (total + (total * interestRate)));
    }


}

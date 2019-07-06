/*
 * File: Countdown.java
 * --------------------
 * This program counts backwards from the value START
 * to zero, as in the countdown preceding a rocket
 * launch.
 */

import acm.program.*;

public class Countdown extends ConsoleProgram {

	public void run() {
		int t = START;
		while (t >= 0) {
			println(t);
			t--;
		}
		println("Liftoff!");
	}

/* Private constants */
	private static final int START = 10;   /* Specifies the value from which to start counting down */

}

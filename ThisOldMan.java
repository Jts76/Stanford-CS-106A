/*
 * Filename: ThisOldMan.java
 * ---------------------------------------
 * Author: Jts76 | Jts76@me.com
 * ---------------------------------------
 *
 * This program recites the This Old Man poem!
 */

import acm.program.ConsoleProgram;

public class ThisOldMan extends ConsoleProgram {
    public void run(){
        int i = 1;
        String stuff = "";
        while (i <= 10) {
            switch (i) {
                case 1: stuff = "thumb"; break;
                case 2: stuff = "shoe"; break;
                case 3: stuff = "knee"; break;
                case 4: stuff = "door"; break;
                case 5: stuff = "hive"; break;
                case 6: stuff = "sticks"; break;
                case 7: stuff = "heaven"; break;
                case 8: stuff = "pate"; break;
                case 9: stuff = "spine"; break;
                case 10: stuff = "shin"; break;
            }
            println("This old man, he played " + i);
            println("He played knick-knack on my " + stuff);
            println("With a knick-knack, paddy-whack");
            println("Give your dog a bone.");
            println("This old man came rolling home.");
            println("");
            i++;
        }
    }
}

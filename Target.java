/*
 * Filename: Target.java
 *
 * This program draws a 3 ring archery target that
 * alternates red and white fill colors with the
 * ring and inner bullseye being red
 */
 
 import acm.graphics.*;
 import acm.program.*;
 
 public class Target extends GraphicsProgram (){
 
     public void run() {
         
     }
     private void drawCircle(int cx, int cy, int cWidth, int cHeight) {
         GOval circle = new GOval(cx, cy, cWidth, cHeight);
     } 
 }
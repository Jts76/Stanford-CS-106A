/*
 * Filename: FilledRect.java
 * ---------------------------------------
 * Author: The Art and Science of Java
 * Figure 6-8 Pg. 207
 * ---------------------------------------
 *
 * This file defines a graphical object that appears as
 * a filled rectangle.
 *
 */

import acm.graphics.*;
import java.awt.*;

public class FilledRect extends GRect {

/** Creates a new FilledRect with the specified bounds. */
    public FilledRect(double x, double y, double width, double height) {
        super(x, y, width, height);
        setFilled(true);
    }

/** Creates a new FilledRect with the specified bounds and color. */
    public FilledRect(double x, double y, double width, double height, Color color) {
        this(x, y, width, height);
        setColor(color);
    }
}

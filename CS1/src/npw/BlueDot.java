/*
 * Program to paint a blue dot in the context of the Nonrepresentational
 * Painting World, npw.
 * Modified By Miguel Cruz ] Lab 2
 */
package npw;

import painter.SPainter;
import shapes.SCircle;

import javax.swing.*;
import java.awt.*;
public class BlueDot {
    // THE SOLUTION TO THE BLUE DOT PROBLEM
    private void paintTheImage() {
        SPainter klee = new SPainter("Blue Dot",600,600);
        SCircle dot = new SCircle(200);
        klee.setColor(Color.BLUE);
        klee.paint(dot);
    }
    // REQUIRED INFRASTRUCTURE
    public BlueDot() {
        paintTheImage();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BlueDot();
            }
        });
    }
}
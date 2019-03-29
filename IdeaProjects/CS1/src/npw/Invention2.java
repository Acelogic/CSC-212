/*
 * This interpreter is intended to paint different colored dots in a window.
 *
 * The commands that the interpreter can recognize and respond to are:
 * - BLUE: paint a blue dot
 * - RED: paint a red dot
 * - HELP: show a list of the commands in a dialog message box
 * - EXIT: terminate the program
 */
package npw;

import painter.SPainter;
import shapes.SCircle;
import shapes.SSquare;

import javax.swing.*;
import java.awt.*;


public class Invention2 {
    private void paintTheImage() {
// CREATE OBJECTS TO THINK WITH
        SPainter paintBrush = new SPainter("Deterministic Invention", 400, 400);
        paintBrush.setScreenLocation(0, 0);
        SCircle dot = new SCircle(180);
        SSquare squareObj = new SSquare(20);
// REPEATEDLY TAKE A COMMAND FROM AN INPUT DIALOG BOX AND INTERPRET IT
        while (true) {
            String command = JOptionPane.showInputDialog(null, "Command?");
            if (command == null) {
                command = "exit";
            } // user clicked on Cancel
            if (command.equalsIgnoreCase("blue")) {
                paintBrush.setColor(Color.BLUE);
                paintBrush.paint(dot);
            } else if (command.equalsIgnoreCase("red")) {
                paintBrush.setColor(Color.RED);
                paintBrush.paint(dot);
            } else if (command.equalsIgnoreCase("help")) {
                JOptionPane.showMessageDialog(null, "Valid commands are: "
                        + "RED | BLUE | HELP | EXIT ");
            } else if (command.equalsIgnoreCase("exit")) {
                paintBrush.end();
                System.out.println("Thank you for viewing the dots ...");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Unrecognizable command: "
                        + command.toUpperCase());
            }
        }
    }

    // INFRASTRUCTURE FOR SOME SIMPLE PAINTING
    public Invention2() {
        paintTheImage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Invention2();
            }
        });
    }
}
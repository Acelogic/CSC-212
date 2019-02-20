/*
 * This interpreter is intended to paint different colored dots in a window.
 *
 * The commands that the interpreter can recognize and respond to are:
 * - BLUE: paint a blue dot
 * - RED: paint a red dot
 * - HELP: show a list of the commands in a dialog message box
 * - EXIT: terminate the program
 */
package interpreters;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.Color;

import painter.SPainter;
import shapes.SCircle;


public class Interpreter1 {
    private void interpreter() {
// CREATE OBJECTS TO THINK WITH
        SPainter miro = new SPainter("Dot Thing", 400, 400);
        miro.setScreenLocation(0, 0);
        SCircle dot = new SCircle(180);
// REPEATEDLY TAKE A COMMAND FROM AN INPUT DIALOG BOX AND INTERPRET IT
        while (true) {
            String command = JOptionPane.showInputDialog(null, "Command?");
            if (command == null) {
                command = "exit";
            } // user clicked on Cancel
            if (command.equalsIgnoreCase("blue")) {
                miro.setColor(Color.BLUE);
                miro.paint(dot);
            } else if (command.equalsIgnoreCase("red")) {
                miro.setColor(Color.RED);
                miro.paint(dot);
            } else if (command.equalsIgnoreCase("help")) {
                JOptionPane.showMessageDialog(null, "Valid commands are: "
                        + "RED | BLUE | HELP | EXIT ");
            } else if (command.equalsIgnoreCase("exit")) {
                miro.end();
                System.out.println("Thank you for viewing the dots ...");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Unrecognizable command: "
                        + command.toUpperCase());
            }
        }
    }

    // INFRASTRUCTURE FOR SOME SIMPLE PAINTING
    public Interpreter1() {
        interpreter();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interpreter1();
            }
        });
    }
}
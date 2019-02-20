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


public class Interpreter3 {
// STATIC METHOD
    private static Color randomColor(){
        int rv = (int)(Math.random()*256);
        int gv = (int)(Math.random()*256);
        int bv = (int)(Math.random()*256);
        return new Color(rv,gv,bv);
    }
    private void interpreter3() {
// CREATE OBJECTS TO THINK WITH
        SPainter miro = new SPainter("Dot Thing", 400, 400);
        miro.setScreenLocation(0, 0);
        SCircle dot = new SCircle(180);
// REPEATEDLY TAKE A COMMAND FROM AN INPUT DIALOG BOX AND INTERPRET IT
        while (true) {
            String command = JOptionPane.showInputDialog(null, "Command? Type \"help\" if you want to know more");
            if (command == null) {
                command = "exit";
            } // user clicked on Cancel
            if (command.equalsIgnoreCase("blue")) {
                miro.setColor(Color.BLUE);
                miro.paint(dot);
            } else if (command.equalsIgnoreCase("red")) {
                miro.setColor(Color.RED);
                miro.paint(dot);
            }
            else if (command.equalsIgnoreCase("green")) {
                miro.setColor(Color.GREEN);
                miro.paint(dot);
            }
            else if (command.equalsIgnoreCase("yellow")) {
                miro.setColor(Color.YELLOW);
                miro.paint(dot);
            }
            else if (command.equalsIgnoreCase("random")) {
                miro.setColor(randomColor());
                miro.paint(dot);
            }
            else if (command.equalsIgnoreCase("help")) {
                JOptionPane.showMessageDialog(null, "Valid commands are: "
                        + "RED | BLUE | GREEN | YELLOW | HELP | RANDOM | EXIT ");
            } else if (command.equalsIgnoreCase("exit")) {
                miro.end();
                JOptionPane.showMessageDialog(null, "Thank you for viewing the dots");
                System.out.println("Thank you for viewing the dots");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Unrecognizable command: "
                        + command.toUpperCase());
            }
        }
    }


    // INFRASTRUCTURE FOR SOME SIMPLE PAINTING
    public Interpreter3() {
        interpreter3();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interpreter3();
            }
        });
    }
}


/*
 * Program to paint a Target
 * Painting World, npw.
 * Modified By Miguel Cruz | Lab 2
 */
package npw;
import java.awt.Color;
import javax.swing.SwingUtilities;
import painter.SPainter;
import shapes.SCircle;

public class Target {
    // THE SOLUTION TO THE BLUE DOT PROBLEM
    private void paintTheImage() {
        SPainter target = new SPainter("Target",600,600);
        SCircle ColoredBGLayer = new SCircle(200);
        SCircle WhiteLayer= new SCircle(125);
        SCircle DotLayer= new SCircle(50);
        // Step 1
        target.setColor(Color.RED);
        target.paint(ColoredBGLayer);
        // Step 2
        target.setColor(Color.WHITE);
        target.paint(WhiteLayer);
        // Step 3
        target.setColor(Color.RED);
        target.paint(DotLayer);
    }
    // REQUIRED INFRASTRUCTURE
    public Target() {
        paintTheImage();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Target();
            }
        });
    }
}
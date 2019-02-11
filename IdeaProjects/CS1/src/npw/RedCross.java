package npw;

import painter.SPainter;
import shapes.*;
import javax.swing.SwingUtilities;
import java.awt.Color;



public class RedCross {



    private void paintTheImage() {
        SPainter paintBrush = new SPainter("Red Cross",600,600);
        SRectangle rectangle = new SRectangle(500,100);

        paintBrush.setColor(Color.RED);
        paintBrush.paint(rectangle);
        paintBrush.moveToCenter();
        paintBrush.tl();
        paintBrush.paint(rectangle);
    }
    // REQUIRED INFRASTRUCTURE
    public RedCross() {
        paintTheImage();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { //Static
            public void run() {
                new RedCross();
            }
        });
    }


}

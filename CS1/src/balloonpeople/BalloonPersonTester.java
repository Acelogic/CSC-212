package balloonpeople;

import painter.SPainter;

import javax.swing.*;
import java.awt.geom.Point2D;

public class BalloonPersonTester {


    public BalloonPersonTester() {
        // Create some BalloonPerson instances to test with!
        SPainter paintBrush = new SPainter("Balloon Person Tester ", 1920, 1080);

        //Starting Position
        int startingX = 200;
        int startingY = 200;
        paintBrush.moveTo(new Point2D.Double(startingX, startingY));

        BalloonPerson person = new BalloonPerson("Test", 25, 60);
        person.paintPerson(paintBrush);
        System.out.println(person);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BalloonPersonTester();
        });
    }
}
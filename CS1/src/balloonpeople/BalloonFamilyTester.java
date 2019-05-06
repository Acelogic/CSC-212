package balloonpeople;

import painter.SPainter;

import javax.swing.SwingUtilities;

public class BalloonFamilyTester {


    public BalloonFamilyTester() {
        // Create some BalloonPerson instances to test with!
        SPainter paintBrush = new SPainter("Balloon People", 1920, 1080);

        BalloonFamily family = new BalloonFamily(3);
        family.paint(paintBrush);
        System.out.println(family);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BalloonFamilyTester();
        });
    }
}
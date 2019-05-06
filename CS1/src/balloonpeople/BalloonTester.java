package balloonpeople;
import painter.SPainter;
import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class BalloonTester {


    public BalloonTester() {
        // Create some BalloonPerson instances to test with!
        SPainter paintBrush = new SPainter("Balloon People", 1920, 1080);

        BalloonFamily family = new BalloonFamily(2);
        family.paint(paintBrush);
        System.out.println(family);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BalloonTester();
        });
    }
}
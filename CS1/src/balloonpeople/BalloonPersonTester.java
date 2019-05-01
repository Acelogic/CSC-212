package balloonpeople;

import painter.SPainter;
import javax.swing.SwingUtilities;
import java.awt.geom.Point2D;

public class BalloonPersonTester {

    public BalloonPersonTester() {
        // Create some BalloonPerson instances to test with!
        SPainter painter = new SPainter("Balloon People", 1920, 1080);
        BalloonPerson[] people = {new BalloonPerson("Bob", 2, 30),
                                    new BalloonPerson("Mai", 30, 40),
                                        new BalloonPerson("Josh", 14, 40)};



        for (int i = 0; i < people.length-1; i++) {
            people[i].paint(painter);
            painter.moveTo(new Point2D.Double(200,1080/2));
            painter.mrt(200);
            System.out.println(people.length);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BalloonPersonTester::new);
    }
}
package balloonpeople;

import painter.SPainter;

public class BalloonPersonDemo {
    public static void main(String[] args) {

        SPainter painter = new SPainter("Balloon Person", 800, 800);

        BalloonPerson b1 = new BalloonPerson("Bob", 5, 66);
        System.out.println(b1);
        b1.paint(painter);

    }


}

package balloonpeople;

import painter.SPainter;
import shapes.SCircle;

import java.awt.*;

public class BalloonPerson {

    private String name;
    private int age;
    private double height;
    private Color balloonColor;

    public BalloonPerson(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
        // Color Class will extract the r,g,b components from the 32bit integer
        balloonColor = new Color((int) (Math.random() * 0x1000000));

    }

    public String toString() {
        return "Name:" + name + "Age:" + age + "Height: " + height;
    }


    public void paint(SPainter painter) {
        int headRadius = 100;

        SCircle head = new SCircle(headRadius);
        painter.setColor(balloonColor);
        painter.paint(head);
        head.shrink(headRadius / 2);
        for (int i = 0; i < height/3; i++) {
            painter.mbk(headRadius / 2);
            painter.paint(head);
           // System.out.println(i + " Loop Working");
        }

    }
}




package balloonpeople;

import painter.SPainter;

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


    public void paint(SPainter paint) {

    }

}




package balloonpeople;

import painter.SPainter;
import shapes.SCircle;

import java.awt.*;
import java.awt.geom.Point2D;

public class BalloonPerson {

    private String name;
    private int age;
    private double height;
    private double headSize = 100;
    private double shrinkFactor = 1.5;
    private SCircle baseCircle = new SCircle(headSize);
    private Point2D.Double leftEdge;
    private Point2D.Double rightEdge;
    private Point2D.Double headPos;


    public BalloonPerson(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }


    public String toString() {
        return " Name: " + name + " Age: " + age + " Height: " + height + "\n";
    }


    public void paintPerson(SPainter painter) {
        paintHead(painter);
        paintArmSpan(painter);
        paintLegs(painter);
    }

    public void setHeadSize(double headSize) {
        this.headSize = headSize;
    }

    public double getRightEdgeX() {
        return rightEdge.x;
    }


    public double getRightEdgeY() {
        return rightEdge.y;
    }

    public double getHeadPositionY() {
        return headPos.y;
    }

    public double getHeadPositionX() {
        return headPos.x;
    }


    public boolean isAtEdge(SPainter painter) {
        return getRightEdgeX() >= painter.canvasWidth();
    }

    private void paintHead(SPainter painter) {
        //Head
        painter.setRandomColor();
        painter.saveColor();
        painter.paint(baseCircle);
        headPos = painter.getPosition();

        //Name
        int fontsize = 20;
        painter.setColor(Color.black);
        painter.setFontSize(fontsize);
        painter.draw(name);
        painter.mbk(fontsize);
        painter.draw("Age: " + age);
        painter.mbk(fontsize);
        painter.draw("height: " + height);
    }

    private void paintArmSpan(SPainter painter) {
        //Center Circle
        painter.restoreColor();
        painter.mbk(baseCircle.diameter() + height);
        baseCircle.shrink(headSize / shrinkFactor);
        painter.paint(baseCircle);

        //Right Circle
        painter.mrt(baseCircle.diameter() * 2);
        painter.paint(baseCircle);
        rightEdge = painter.getPosition();
        painter.mlt(baseCircle.diameter() * 2); // TODO: Inspect this behavior
        painter.paint(baseCircle);

        // Left Circle
        painter.mlt(baseCircle.diameter() * 2);
        painter.paint(baseCircle);
        leftEdge = painter.getPosition();
    }


    private void paintLegs(SPainter painter) {

        // Torso (2nd Circle)
        painter.mrt(baseCircle.diameter() * 2);
        painter.mbk(baseCircle.diameter() * 2);
        painter.paint(baseCircle);

        // Right Leg
        painter.tl(300);
        painter.mrt(baseCircle.diameter() * 2);
        painter.paint(baseCircle);

        //Left Leg
        painter.tr(300);
        painter.mlt(baseCircle.diameter() * 2);
        painter.paint(baseCircle);
    }

}






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
    private SCircle baseCircle = new SCircle(headSize);
    private Point2D.Double edge1;
    private Point2D.Double edge2;

    public BalloonPerson(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public void setHeadSize(double headSize){
        this.headSize = headSize;
    }


    public String toString() {
        return " Name: " + name + " Age: " + age + " Height: " + height + "\n";
    }


    public void paint(SPainter painter) {

        painter.setRandomColor();
        painter.paint(baseCircle);

        painter.mbk(baseCircle.diameter() + height);
        baseCircle.shrink(headSize/1.5);
        painter.paint(baseCircle);

        //Right Circle
        painter.mrt(baseCircle.diameter()*2);
        painter.paint(baseCircle);
        edge2 = painter.getPosition();



        //Center Circle
        painter.mlt(baseCircle.diameter() * 2);
        painter.paint(baseCircle);

        // Left Circle
        painter.mlt(baseCircle.diameter() * 2);
        painter.paint(baseCircle);
        edge1 = painter.getPosition();



        painter.mrt(baseCircle.diameter() * 2);
        painter.mbk(baseCircle.diameter() * 2);
        painter.paint(baseCircle);

        painter.tl(300);
        painter.mrt(baseCircle.diameter() * 2);
        painter.paint(baseCircle);

        painter.tr(300);
        painter.mlt(baseCircle.diameter() * 2);
        painter.paint(baseCircle);
        }


    public double RightEdge(){
        return edge2.x;
    }

    public boolean isAtEdge(SPainter painter){
        return edge2.x >= painter.canvasWidth();
    }

}





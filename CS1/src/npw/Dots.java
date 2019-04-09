package npw;

import painter.SPainter;
import shapes.SCircle;
import shapes.SRectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D.Double;


public class Dots {

    private void drawCartesianPlane(SPainter painter, SRectangle lines) {
    painter.setColor(Color.BLACK);

    painter.draw(lines);
    painter.moveToCenter();

    painter.tl();
    painter.draw(lines);
    painter.moveToCenter();
    }
    private void drawPositiveY(SPainter painter, SCircle circleMin, SCircle circleMed,SCircle circleMax) {
    painter.setColor(Color.RED);

    painter.setPosition(new Double(300,200));
    painter.paint(circleMin);

    painter.setPosition(new Double(400,200));
    painter.paint(circleMin);

    painter.setColor(Color.GREEN);
    painter.setPosition(new Double(500,200));
    painter.paint(circleMed);

    painter.setColor(Color.BLUE);
    painter.setPosition(new Double(600,0));
    painter.paint(circleMax);


    }

    private void drawNegativeY(SPainter painter, SCircle circleMin, SCircle circleMed,SCircle circleMax) {
        painter.setColor(Color.RED);

        painter.setPosition(new Double(300,400));
        painter.paint(circleMin);

        painter.setPosition(new Double(400,400));
        painter.paint(circleMin);

        painter.setColor(Color.GREEN);
        painter.setPosition(new Double(500,400));
        painter.paint(circleMed);

        painter.setColor(Color.BLUE);
        painter.setPosition(new Double(600,600));
        painter.paint(circleMax);


    }



    private void paintTheImage() {
        SPainter painter = new SPainter("Dots",600,600);
        SRectangle lines = new SRectangle(1, 600);
        SCircle circleMin = new SCircle(25);
        SCircle circleMed = new SCircle(50);
        SCircle circleMax = new SCircle(75);
        drawCartesianPlane(painter,lines);
        drawPositiveY(painter, circleMin, circleMed,circleMax);
        drawNegativeY(painter, circleMin, circleMed,circleMax);
    }




    // REQUIRED INFRASTRUCTURE
    public Dots() {
        paintTheImage();

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { //Static
            public void run() {
                new Dots();
            }
        });
    }}

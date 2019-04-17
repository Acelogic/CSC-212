package npw;

import painter.SPainter;
import shapes.SSquare;

import javax.swing.*;
import java.awt.*;



public class PumpItUp {
static double sideOfSquare;

    public void paintYellowSquare(SPainter painter, SSquare square){
        painter.setColor(Color.YELLOW);
        painter.paint(square);
    }

    public void paintRedSquares(SPainter painter, SSquare square){
        painter.setColor(Color.RED);
        painter.mfd(sideOfSquare);
        painter.mlt(sideOfSquare);
        painter.paint(square);
        painter.moveToCenter();

        painter.mfd(sideOfSquare);
        painter.mrt(sideOfSquare);
        painter.paint(square);
        painter.moveToCenter();
    }

    public void paintBlueSquares(SPainter painter, SSquare square){
        painter.setColor(Color.BLUE);

        painter.mbk(sideOfSquare);
        painter.mlt(sideOfSquare);
        painter.paint(square);
        painter.moveToCenter();

        painter.mbk(sideOfSquare);
        painter.mrt(sideOfSquare);
        painter.paint(square);
        painter.moveToCenter();
    }

    public void paintGraySquares(SPainter painter, SSquare square){
        painter.setColor(Color.GRAY);

        painter.mbk(sideOfSquare);
        painter.paint(square);
        painter.moveToCenter();

        painter.mfd(sideOfSquare);
        painter.paint(square);
        painter.moveToCenter();

        painter.mlt(sideOfSquare);
        painter.paint(square);
        painter.moveToCenter();

        painter.mrt(sideOfSquare);
        painter.paint(square);
        painter.moveToCenter();
    }

    private void paintTheImage() {
        SPainter painter = new SPainter("PumpItUp",600,600);
        SSquare square = new SSquare(150);
        sideOfSquare = square.side();
        paintYellowSquare (painter,square);
        paintRedSquares(painter,square);
        paintBlueSquares(painter,square);
        paintGraySquares(painter,square);
    }
    // REQUIRED INFRASTRUCTURE
    public PumpItUp() {
        paintTheImage();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { //Static
            public void run() {
                new PumpItUp();
            }
        });
    }}

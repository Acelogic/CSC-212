package npw;

import painter.SPainter;
import shapes.SSquare;

import javax.swing.*;
import java.awt.*;



public class PumpItUp {

    public void paintYellowSquare(SPainter painter, SSquare square){
        painter.setColor(Color.YELLOW);
        painter.paint(square);
    }

    public void paintRedSquares(SPainter painter, SSquare square){
        painter.setColor(Color.RED);

        painter.mfd(150);
        painter.mlt(150);
        painter.paint(square);
        painter.moveToCenter();

        painter.mfd(150);
        painter.mrt(150);
        painter.paint(square);
        painter.moveToCenter();
    }

    public void paintBlueSquares(SPainter painter, SSquare square){
        painter.setColor(Color.BLUE);

        painter.mbk(150);
        painter.mlt(150);
        painter.paint(square);
        painter.moveToCenter();

        painter.mbk(150);
        painter.mrt(150);
        painter.paint(square);
        painter.moveToCenter();
    }

    public void paintGraySquares(SPainter painter, SSquare square){
        painter.setColor(Color.GRAY);

        painter.mbk(150);
        painter.paint(square);
        painter.moveToCenter();

        painter.mfd(150);
        painter.paint(square);
        painter.moveToCenter();

        painter.mlt(150);
        painter.paint(square);
        painter.moveToCenter();

        painter.mrt(150);
        painter.paint(square);
        painter.moveToCenter();
    }

    private void paintTheImage() {
        SPainter painter = new SPainter("PumpItUp",600,600);
        SSquare square = new SSquare(150);
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

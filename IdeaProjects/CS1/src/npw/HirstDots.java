/*
 * A program to paint an abstract gradient in the vertical direction.
 */

package npw;

import painter.SPainter;
import shapes.SCircle;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class HirstDots {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HirstDots();
            }
        });
    }

    public HirstDots() {
        paintTheImage();
    }

    private void paintTheImage(){
        // Grab the input information
        int width = getNumber("width in pixels");
        int height = getNumber("height in pixels ");
        int spacing = getNumber("Dot Spacing in pixels");
        // Establish the painter
        SPainter painter = new SPainter("HirstDots", width, height);
        SCircle dot = new SCircle(5);

        // Move the painter to the upper left corner to get ready to paint the gradient
        painter.mfd(height/2);
        painter.tl(90);
        painter.mfd(width/2 - 10);
        painter.tl(90);

        // Paint it!
        paintGradient(painter, dot, height, width, spacing);
    }

    private static int getNumber(String prompt) {
        String nss = JOptionPane.showInputDialog(null,prompt+"?");
        Scanner scanner = new Scanner(nss);
        return scanner.nextInt();
    }

    private void paintGradient(SPainter painter, SCircle dot, int height, int width, int colWidth){
        int cols = 0;
        // Calcuate the number of columns. We want to fill the screen, but we don't want
        // any dots only half on the canvas, so we subtract some space.
        int nrOfCols = ( width / colWidth ) - 2;

        while (cols < nrOfCols){
            nextCol(painter, colWidth);
            paintColumn(painter, dot, height);
            cols = cols + 1;
        }
    }

    private void paintOneDot(SPainter painter, SCircle dot){
        randomColor(painter);
        painter.paint(dot);
    }

    // Dots are spaced tighter together near the bottom of the canvas.
    private void paintColumn(SPainter painter, SCircle dot, int height) {
       int totalDistanceTraveled = 0;
        while(totalDistanceTraveled < height) {
           System.out.println("Still Drawing");
           painter.mfd(height);
           paintOneDot(painter, dot);
           totalDistanceTraveled = height;
       }
        painter.mbk(totalDistanceTraveled);
    }

    // Moves the painter to the next column.
    private void nextCol(SPainter painter, int colWidth){
        painter.tl(90);
        painter.mfd(colWidth);
        painter.tr(90);
    }

    private int fixedDistance(int maxDistance){
        return maxDistance;
    }

    private void randomColor(SPainter painter){
        Random rgen = new Random();
        int randomRGBValue1 = rgen.nextInt(255);
        int randomRGBValue2 = rgen.nextInt(255);
        int randomRGBValue3 = rgen.nextInt(255);
        painter.setColor(new Color(randomRGBValue1,randomRGBValue2,randomRGBValue3));
    }
}

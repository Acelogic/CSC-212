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
    static int columnCount;
    static int spacingFactor = getNumber("Dot Spacing in Pixels");

    private void paintTheImage(){
         int width = getNumber("Canvas Width in Pixels");
         int height = getNumber("Canvas Height in Pixels ");
        // Establish the painter
        SPainter painter = new SPainter("SimpleDots", width, height);
        SCircle dot = new SCircle(5);

        // Move the painter to the upper left corner to get ready to paint the gradient
        painter.mfd(height/2);
        painter.tl(90);
        painter.mfd(width/2 - 10);
        painter.tl(90);

        // Paint it!
        paintGradient(painter, dot, height, width, spacingFactor);
    }

    private static int getNumber(String prompt) {
        String nss = JOptionPane.showInputDialog(null,prompt+"?");
        Scanner scanner = new Scanner(nss);
        return scanner.nextInt();
    }

    // Supports floating point numbers as spacingFactor values
    private void paintGradient(SPainter painter, SCircle dot, int height, int width, int verticalSpacing){
        // Calcuate the number of columns. We want to fill the screen, but we don't want
        // any dots only half on the canvas, so we subtract some space.
        int nrOfCols = ( width / verticalSpacing ) - 2;
        columnCount = 0;
        while (columnCount < nrOfCols){
            nextCol(painter, verticalSpacing);
            columnCount = columnCount + 1;
            paintColumn(painter, dot, height);

        }
    }

    private void paintOneDot(SPainter painter, SCircle dot){
        randomColor(painter);
        painter.paint(dot);
    }

    private void paintColumn(SPainter painter, SCircle dot, int height) {
        int horizontalSpacing = spacingFactor;
        int displacement = 0;
        int dotsPainted = -1; // Debug
        while(displacement < height) {

            System.out.println("DEBUG: Calculation: " + horizontalSpacing+"px" + " + " + displacement+"px"); // Debug

            displacement = displacement + horizontalSpacing;
            painter.mfd(horizontalSpacing);
            paintOneDot(painter, dot);
            dotsPainted = dotsPainted + 1;

            //Debug Code
            System.out.println("DEBUG: Total Distance Traveled: "+ displacement+"px");
            System.out.println("DEBUG: Dots Painted: "+ dotsPainted);
            System.out.println("DEBUG: Working Column: " + columnCount);
            System.out.println("-------------------------------------------------");
        }
            // Make the method invariant with respect to painter position.
            painter.mbk(displacement);

            //Debug Code
            System.out.println("DEBUG: Spacing Factor: " + spacingFactor +"px");
            System.out.println("DEBUG: Dot Array Size: " + dotsPainted + " x " + columnCount);
            System.out.println("DEBUG: Total Dots Painted: " + dotsPainted * columnCount);
        }

    // Moves the painter to the next column.
    private void nextCol(SPainter painter, double colWidth){
        painter.tl(90);
        painter.mfd(colWidth);
        painter.tr(90);
    }

    private void randomColor(SPainter painter){
        Random rgen = new Random();
        int r = rgen.nextInt(255);
        int g = rgen.nextInt(255);
        int b = rgen.nextInt(255);
        painter.setColor(new Color(r,g,b));
    }

    private HirstDots() {
        paintTheImage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HirstDots();
            }
        });
    }



}

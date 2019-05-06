/*
 * A program to paintPerson an abstract gradient in the vertical direction.
 */

package npw;

import painter.SPainter;
import shapes.SCircle;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

import static javax.swing.SwingUtilities.invokeLater;

public class HirstDots {
     private int spacingFactor = getNumber(" Dot Spacing");
     private int width = getNumber("Canvas Width in Pixels");
     private int height = getNumber("Canvas Height in Pixels ");

     private HirstDots() {
        paintTheImage();
    }

    public static void main(String[] args) {
        invokeLater( HirstDots::new );
    }

    private void paintTheImage(){
        // Establish the painter
        SPainter painter = new SPainter("SimpleDots", width, height);
        SCircle dot = new SCircle(5);
        // Move the painter to the upper left corner to get ready to paintPerson the gradient
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

    // Supports double precision floating point numbers as spacingFactor values
    private void paintGradient(SPainter painter, SCircle dot, int height, int width, int verticalSpacing){
        // Calculate the number of columns. We want to fill the screen, but we don't want
        // any dots only half on the canvas, so we subtract some space.
        int nrOfCols = ( width / verticalSpacing ) - 2;
        int columnCount = 0;
        while (columnCount < nrOfCols){
            nextCol(painter, verticalSpacing);
            columnCount = columnCount + 1;
            paintColumn(painter, dot, height);
        }
    }

    private void paintOneDot(SPainter painter, SCircle dot){
        painter.setColor(randomColor());
        painter.paint(dot);
    }

    private void paintColumn(SPainter painter, SCircle dot, int height) {
        int horizontalSpacing = spacingFactor;
        int displacement = 0;

        while(displacement < height) {
            displacement = displacement + horizontalSpacing;
            painter.mfd(horizontalSpacing);
            paintOneDot(painter, dot);
        }
            // Make the method invariant with respect to painter position.
            painter.mbk(displacement);
        }
        // Moves the painter to the next column.
    private void nextCol(SPainter painter, double colWidth){
        painter.tl(90);
        painter.mfd(colWidth);
        painter.tr(90);
    }
    private Color randomColor(){
        Random rgen = new Random();
        int r = rgen.nextInt(255);
        int g = rgen.nextInt(255);
        int b = rgen.nextInt(255);
        return new Color(r,g,b);
    }
}

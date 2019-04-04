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

public class SimpleDots {
    // Grab the input information
    private static String colorChose = getString( "What Color Would You like" );
    private static int spacingFactor = getNumber( "Dot Spacing in Pixels" );
    private static int columnCount;

    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                new SimpleDots();
            }
        } );
    }

    public SimpleDots() {
        paintTheImage();
    }

    private void paintTheImage() {
        int width = getNumber( "Canvas Width in Pixels" );
        int height = getNumber( "Canvas Height in Pixels " );

        SPainter painter = new SPainter( "SimpleDots", width, height );
        SCircle dot = new SCircle( 5 );
        // Move the painter to the upper left corner to get ready to paint the gradient
        painter.mfd( height / 2 );
        painter.tl( 90 );
        painter.mfd( width / 2 - 10 );
        painter.tl( 90 );

        // Paint it!
        paintGradient( painter, dot, height, width, spacingFactor );
    }

    private static int getNumber(String prompt) {
        String nss = JOptionPane.showInputDialog( null, prompt + "?" );
        Scanner scanner = new Scanner( nss );
        return scanner.nextInt();
    }

    private static String getString(String prompt) {
        String nss = JOptionPane.showInputDialog( null, prompt + "?" );
        Scanner scanner = new Scanner( nss );
        return scanner.next();
    }

    // Supports floating point numbers as spacingFactor values
    private void paintGradient(SPainter painter, SCircle dot, int height, int width, int spacingFactor) {
        // Calculate the number of columns. We want to fill the screen, but we don't want
        // any dots only half on the canvas, so we subtract some space.
        int nrOfCols = (width / spacingFactor) - 2;
        columnCount = 0;
        while (columnCount < nrOfCols) {
            nextCol( painter, spacingFactor );
            columnCount = columnCount + 1; // Debug
            paintColumn( painter, dot, height );
        }
    }

    private void paintOneDot(SPainter painter, SCircle dot) {
        dynamicColor( painter );
        painter.paint( dot );
    }

    private void paintColumn(SPainter painter, SCircle dot, int height) {
        int horizontalSpacing = spacingFactor;
        int totalDistanceTraveled = 0;
        int dotsPainted = -1; // Debug
        while (totalDistanceTraveled < height) {
            System.out.println( "DEBUG: Calculation: " + horizontalSpacing + "px" + " + " + totalDistanceTraveled + "px" ); // Debug

            totalDistanceTraveled = totalDistanceTraveled + horizontalSpacing;
            painter.mfd( horizontalSpacing );
            paintOneDot( painter, dot );
            dotsPainted = dotsPainted + 1;

            //Debug Code
            System.out.println( "DEBUG: Total Distance Traveled: " + totalDistanceTraveled + "px" );
            System.out.println( "DEBUG: Dots Painted: " + dotsPainted );
            System.out.println( "DEBUG: Working Column: " + columnCount );
            System.out.println( "-------------------------------------------------" );
        }
            // Make the method invariant with respect to painter position.
            painter.mbk( totalDistanceTraveled );

            //Debug Code
            System.out.println( "DEBUG: Spacing Factor: " + spacingFactor + "px" );
            System.out.println( "DEBUG: Dot Array Size: " + dotsPainted + " x " + columnCount );
            System.out.println( "DEBUG: Total Dots Painted: " + dotsPainted * columnCount );
    }

    // Moves the painter to the next column.
    private void nextCol(SPainter painter, double colWidth) {
        painter.tl( 90 );
        painter.mfd( colWidth );
        painter.tr( 90 );
    }


    private void dynamicColor(SPainter painter) {
        Random rgen = new Random();
        if (colorChose.equalsIgnoreCase( "red" )) {
            painter.setColor( Color.RED );
        } else if (colorChose.equalsIgnoreCase( "green" )) {
            painter.setColor( Color.GREEN );
        } else if (colorChose.equalsIgnoreCase( "blue" )) {
            painter.setColor( Color.BLUE );
        } else if (colorChose.equalsIgnoreCase( "random" )) {
            int r = rgen.nextInt( 255 );
            int g = rgen.nextInt( 255 );
            int b = rgen.nextInt( 255 );
            painter.setColor( new Color( r, g, b ) );
        } else {
            painter.setColor( Color.BLACK );
        }
    }
}


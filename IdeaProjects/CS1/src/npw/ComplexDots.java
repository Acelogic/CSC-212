/*
 * A program to paint an abstract gradient in the vertical direction.
 */

package npw;

import painter.SPainter;
import shapes.SCircle;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ComplexDots {
    // Grab the input information
    private static int spacingFactor = getNumber( "Dot Spacing in Pixels" );
    private static int columnCount;

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                try {
                    new ComplexDots();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
    }

    public ComplexDots() throws IOException {
        paintTheImage();
    }

    private void paintTheImage() throws IOException {
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
    private void paintGradient(SPainter painter, SCircle dot, int height, int width, int spacingFactor) throws IOException {
        // Calculate the number of columns. We want to fill the screen, but we don't want
        // any dots only half on the canvas, so we subtract some space.
        int nrOfCols = (width / spacingFactor) - 2;
        columnCount = 0;
        while (columnCount < nrOfCols) {
            nextCol( painter, spacingFactor );
            columnCount = columnCount + 1;
            paintColumn( painter, dot, height );
        }
    }

    private void paintOneDot(SPainter painter, SCircle dot) throws IOException {
        System.out.println( "PaintOneDot" );
        String separator = System.getProperty( "file.separator" );
        String home = System.getProperty( "user.dir" );// Changed this from user.home in order to work on windows
        String path = home + separator + "CS1Files" + separator + "data" + separator + "img.jpg";
        File file = new File( path );
        BufferedImage image = ImageIO.read( file );
        int width = 0;
        int increasingWidth = 0;
        if (width < image.getWidth()){
           increasingWidth = width + 1;
        }
        painter.setColor( grabOneImgPixelColor(increasingWidth ,1  ) );
        painter.paint( dot );
    }

    private void paintColumn(SPainter painter, SCircle dot, int height) throws IOException {
        int horizontalSpacing = spacingFactor;
        int totalDistanceTraveled = 0;
        int dotsPainted = -1;
        while (totalDistanceTraveled < height) {
            // Good Debug Code
            System.out.println( "Calculation: " + horizontalSpacing + "px" + " + " + totalDistanceTraveled + "px" );

            totalDistanceTraveled = totalDistanceTraveled + horizontalSpacing;
            painter.mfd( horizontalSpacing );
            paintOneDot( painter, dot );
            dotsPainted = dotsPainted + 1;

            // Good Debug Code
            System.out.println( "Total Distance Traveled: " + totalDistanceTraveled + "px" );
            System.out.println( "Dots Painted: " + dotsPainted );
            System.out.println( "Working Column: " + columnCount );
            System.out.println( "-------------------------------------------------" );
        }
        // Make the method invariant with respect to painter position.
        painter.mbk( totalDistanceTraveled );
        System.out.println( "Spacing Factor: " + spacingFactor + "px" );
        System.out.println( "Dot Array Size: " + dotsPainted + " x " + columnCount );
        System.out.println( "Total Dots Painted: " + dotsPainted * columnCount );
    }

    // Moves the painter to the next column.
    private void nextCol(SPainter painter, double colWidth) {
        painter.tl( 90 );
        painter.mfd( colWidth );
        painter.tr( 90 );
    }

    private static Color grabOneImgPixelColor(int x , int y) throws IOException {
        System.out.println( "IMG COLORS" );
        String separator = System.getProperty( "file.separator" );
        String home = System.getProperty( "user.dir" );// Changed this from user.home in order to work on windows
        String path = home + separator + "CS1Files" + separator + "data" + separator + "img.jpg";
        File file = new File( path );
        BufferedImage image = ImageIO.read( file );
        // Getting pixel color by position x and y
        int clr = image.getRGB( x,y );
        int red = (clr & 0x00ff0000) >> 16;
        int green = (clr & 0x0000ff00) >> 8;
        int blue = clr & 0x000000ff;
        Color PixelColor = new Color( red, green, blue );
        System.out.println( PixelColor.toString() );
        return PixelColor;
    }
    }

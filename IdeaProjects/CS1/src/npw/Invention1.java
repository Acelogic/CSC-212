/*
 * A program to paint an abstract gradient in the vertical direction.
 */

package npw;

import painter.SPainter;
import shapes.SCircle;
import shapes.SSquare;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;

import static javax.swing.SwingUtilities.*;

public class Invention1 {
    //----- Fields Vars and Objects  -----
    private BufferedImage image = getImageFromPath();
    private double pixelSize = 1;
    private int height = image.getHeight();
    private int width = image.getWidth();
    private SPainter painter = new SPainter( "Invention 1", width, height );
    //Changing this stretches picture
    private SCircle circlePixel = new SCircle( pixelSize );
    private SSquare squarePixel = new SSquare( pixelSize );

    //----- Constructors  -----
    private Invention1() throws IOException {
        paintTheRows();
    }
    //----- Methods / Functions  -----
    public static void main(String[] args) {
        invokeLater( () -> {
            try {
                new Invention1();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );
    }
    private BufferedImage getImageFromPath() throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter( "JPG,JPEG,PNG,", "jpg", "png", "jpeg" );
        chooser.setFileFilter( filter );
        int returnVal = chooser.showOpenDialog( chooser );
        String path = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getPath();
        }
        File file = new File( path );
        return ImageIO.read( file );
    }

    private Color getPixelColor(int x, int y) {
        int rgb = image.getRGB( x, y );
        int red = (rgb & 0x00ff0000) >> 16;
        int green = (rgb & 0x0000ff00) >> 8;
        int blue = (rgb & 0x000000ff);
        Color PixelColor = new Color( red, green, blue );
        System.out.println( PixelColor.toString() );
        return PixelColor;
    }
    private void paintOnePixel(int workingPixel, int workingRow) throws IOException {
        Color pixelColor = getPixelColor( workingPixel, workingRow);
        painter.setColor( pixelColor );
        //Changing this may make pictures generate faster
        painter.mrt( 1 );

        // Randomly use a square or circle as a pixel
        Random rgen = new Random();
        int randomNum = rgen.nextInt( 1 );
        if (randomNum == 1) {
            painter.paint( squarePixel );
        } else {
            painter.paint( circlePixel );
        }
    }
    private void paintOneRow(int workingRow) throws IOException {
        int pixelIterator = 0;
        while (pixelIterator < image.getWidth()) {
            paintOnePixel( pixelIterator, workingRow);
            pixelIterator = pixelIterator +1;
        }
    }
    private void paintTheRows() throws IOException {
        int rowCount = 0;
        // Starts Off From Corner of Canvas
        painter.moveTo( new Point2D.Double( 0, 0 ) );
        for (int rowIterator = 0; rowIterator < image.getHeight(); rowIterator++) {
            paintOneRow( rowIterator);
            rowCount = rowCount + 1;
            // Makes a new Row
            painter.moveTo( new Point2D.Double( 0, rowIterator ));
            if (rowCount == image.getHeight()) {
                break;
            }
        }
    }
}

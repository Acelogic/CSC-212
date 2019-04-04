/*
 * A program to paint an abstract gradient in the vertical direction.
 */

package npw;

import painter.SPainter;
import shapes.SRectangle;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static javax.swing.SwingUtilities.invokeLater;

public class Invention2 {
    //----- Field Vars and Objects  -----
    private BufferedImage image = randomlyGetImageFromPath();
    private int height = image.getHeight();
    private int width = image.getWidth();
    private SPainter painter = new SPainter( "Invention 2", width, height );
    //Changing this stretches picture
    private double pixelSize = 1;
    private SRectangle rectanglePixel = new SRectangle( pixelSize,pixelSize );

    //----- Constructors  -----
    private Invention2() throws IOException {
        paintTheRows();
    }
    //----- Methods / Functions  -----
    public static void main(String[] args) {
        invokeLater( () -> {
            try {
                new Invention2();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );
    }
    private BufferedImage randomlyGetImageFromPath() throws IOException {
        Random rgen = new Random();
        String separator = System.getProperty("file.separator");
        String home = System.getProperty("user.dir");// Changed this from user.home in order to work on windows
        String path = home + separator + "CS1Files" + separator + "data" + separator;
        // TODO: Randomly choose any image from the folder (Scan for Jpg and PNG);
        File file = new File( path );
        return ImageIO.read( file );
    }
    private Color getPixelColor(int x, int y) {
        int clr = image.getRGB( x, y );
        int red = (clr & 0x00ff0000) >> 16;
        int green = (clr & 0x0000ff00) >> 8;
        int blue = clr & 0x000000ff;
        Color PixelColor = new Color( red, green, blue );
        System.out.println( PixelColor.toString() );
        return PixelColor;
    }
    private void paintOnePixel(int workingPixel, int workingRow){
        Color pixelColor = getPixelColor( workingPixel, workingRow);
        painter.setColor( pixelColor );
        //Changing this may make pictures generate faster
        painter.mrt( pixelSize );
        painter.paint( rectanglePixel );
    }
    private void paintOneRow(int workingRow){
        int rowPixelCount = 0;
        for (int pixelIterator = 0; pixelIterator < image.getWidth(); pixelIterator++) {
            paintOnePixel( pixelIterator, workingRow);
            rowPixelCount = rowPixelCount + 1;
            System.out.println( "DEBUG: Row Pixel Count:  " + rowPixelCount );
        }
    }
    private void paintTheRows(){
        int rowCount = 0;
        // Starts Off From Corner of Canvas
        painter.moveTo( new Point2D.Double( 0, 0 ) );
        for (int rowIterator = 0; rowIterator < image.getHeight(); rowIterator++) {
            paintOneRow( rowIterator);
            rowCount = rowCount + 1;
            System.out.println( "DEBUG: Row Count:  " + rowCount );
            // Makes a new Row
            painter.moveTo( new Point2D.Double( 0, rowIterator ));
            System.out.println( "DEBUG: NEXT ROW" );
            if (rowCount == image.getHeight()) {
                break;
            }
        }
    }
}

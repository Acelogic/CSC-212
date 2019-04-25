/*
 * A program to paint an abstract gradient in the vertical direction.
 */

package npw;

import painter.SPainter;
import shapes.SRectangle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Queue;
import java.util.Random;

import static javax.swing.SwingUtilities.invokeLater;

public class Invention2Concurrent {
    //----- Fields / Global Vars and Objects  -----
    private String path = pathBuilder();
    private BufferedImage image = GetAnyImage(path);
    private int height = image.getHeight();
    private int width = image.getWidth();
    private SPainter painter = new SPainter( "Invention 2 Concurrent", width, height );
    //Changing this stretches picture
    private double pixelSize = 1;
    private SRectangle rectanglePixel = new SRectangle( pixelSize , pixelSize );

    //----- Constructors  -----
    private Invention2Concurrent() throws IOException {
        paintTheRows();
    }

    //----- Methods / Functions  -----
    public static void main(String[] args) {
        invokeLater( () -> {
            try {
                new Invention2Concurrent();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );
    }
    private String pathBuilder(){
        String separator = System.getProperty("file.separator");
        String home = null;

        //Make Program Compatible With Windows (I use windows :P )
        if(System.getProperty("os.name").startsWith("Windows")) {
            home = System.getProperty("user.dir");
        }
        else if(System.getProperty("os.name").startsWith("Windows 10")) {
            home = System.getProperty("user.dir");
        }
        else {
            home = System.getProperty("user.home");
        }
        String path = home + separator + "CS1Files" + separator + "data" + separator;
        return path;
    }
    private BufferedImage GetAnyImage(String path) throws IOException {
        Random rgen = new Random();
        File dataFolder = new File(path);
        // Randomly choose any image from the folder (Scan for Jpg and PNG);
        FilenameFilter filter = (dir, name) -> {
            String lowercaseName = name.toLowerCase();
            if (lowercaseName.endsWith(".jpg")  ) {
                return true;
            }
            else if (lowercaseName.endsWith(".png")){
                return true;
            }
            else if(lowercaseName.endsWith(".jpeg")) {
                return true;
            }
            else {
                return false;
            }
        };
        File[] listOfFiles = dataFolder.listFiles(filter);
        File randomPicture = listOfFiles[rgen.nextInt(listOfFiles.length)];
        return ImageIO.read(randomPicture);
    }

    private Color getPixelColor(int x, int y) {
        return new Color(image.getRGB(x,y));
    }
    private void paintOnePixel(int workingPixel, int workingRow){
        painter.setColor(getPixelColor( workingPixel, workingRow));
        painter.mrt( rectanglePixel.width());
        painter.paint(rectanglePixel);
    }
    private void paintOneRow(int workingRow){
       for(int workingPixel = 0; workingPixel < image.getWidth(); workingPixel++) {
            paintOnePixel(workingPixel, workingRow);
        }
    }
    private void paintTheRows(){
        // Starts Off From Corner of Canvas
        painter.moveTo( new Point2D.Double( 0, 0 ));

        for (int workingRow = 0; workingRow < image.getHeight(); workingRow++) {
            paintOneRow(workingRow);
            // Makes a new Row
            painter.moveTo( new Point2D.Double( 0, workingRow ));
            if (workingRow == image.getHeight()) {
                break;
            }
        }
    }
}

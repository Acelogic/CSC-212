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
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Random;

import static javax.swing.SwingUtilities.invokeLater;

class SpawnNewSession implements Runnable {
    public void run() {
        try {
           Invention2Threaded invention =  new Invention2Threaded();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Invention2Threaded {
    //----- Field Vars and Objects  -----
    public String path = pathBuilder();
    public BufferedImage image = randomlyGetImageFromPath( path );
    public int height = image.getHeight();
    public int width = image.getWidth();
    public SPainter painter = new SPainter( "Threaded Invention 2", width, height );
    public JFramelessPainter painter2 = new JFramelessPainter(painter);
    //Changing this stretches picture
    public double pixelSize = 1;
    public SRectangle rectanglePixel = new SRectangle( pixelSize, pixelSize );

    //----- Constructors  -----
    public Invention2Threaded() throws IOException {
        //paintTopRows();
        Thread top = new Thread(new Runnable() {
            @Override
            public void run() {
                paintTopRows();
            }
        });
        top.start();

        Thread bottom = new Thread(new Runnable() {
            @Override
            public void run() {
                paintBottomRows();
            }
        });
        bottom.start();

        //paintBottomRows();
    }
    //----- Methods / Functions  -----

    public static void main(String[] args) {
        invokeLater( () -> {
            try {
                // Use this to show how it draws on one core
                new Invention2Threaded();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );

        // Run Multiple Programs in parallel
        Thread thread1 = new Thread( new SpawnNewSession() );
        thread1.start();

    }


    public String pathBuilder() {
        String separator = System.getProperty( "file.separator" );
        String home = null;

        //Make Program Compatible With Windows (I use windows :P )
        if (System.getProperty( "os.name" ).startsWith( "Windows" )) {
            home = System.getProperty( "user.dir" );
        } else if (System.getProperty( "os.name" ).startsWith( "Windows 10" )) {
            home = System.getProperty( "user.dir" );
        } else {
            home = System.getProperty( "user.home" );
        }
        String path = home + separator + "CS1Files" + separator + "data" + separator;
        return path;
    }

    public BufferedImage randomlyGetImageFromPath(String path) throws IOException {

        Random rgen = new Random();
        File dataFolder = new File( path );

        // Randomly choose any image from the folder (Scan for Jpg and PNG);
        FilenameFilter filter = (dir, name) -> {
            String lowercaseName = name.toLowerCase();
            if (lowercaseName.endsWith( ".jpg" )) {
                return true;
            } else if (lowercaseName.endsWith( ".png" )) {
                return true;
            } else if (lowercaseName.endsWith( ".jpeg" )) {
                return true;
            } else {
                return false;
            }
        };
        File[] listOfFiles = dataFolder.listFiles( filter );
        File randomPicture = listOfFiles[rgen.nextInt( listOfFiles.length )];
        return ImageIO.read( randomPicture );
    }

    public Color getPixelColor(int x, int y) {
        int rgb = image.getRGB( x, y );
        int red = (rgb & 0x00ff0000) >> 16;
        int green = (rgb & 0x0000ff00) >> 8;
        int blue = (rgb & 0x000000ff);
        Color PixelColor = new Color( red, green, blue );
        System.out.println( "Thread #:" + Thread.currentThread().getId() + "|" + PixelColor.toString() );
        return PixelColor;
    }

    public void paintOnePixel(int workingPixel, int workingRow) {
        Color pixelColor = getPixelColor( workingPixel, workingRow );
        painter.setColor( pixelColor );
        //Changing this may make pictures generate faster
        painter.mrt( 1 );
        painter.paint( rectanglePixel );
    }

    public void paintOnePixel2(int workingPixel, int workingRow) {
        Color pixelColor = getPixelColor( workingPixel, workingRow );
        painter2.setColor( pixelColor );
        //Changing this may make pictures generate faster
        painter2.mrt( 1 );
        painter2.paint( rectanglePixel );
    }

    public void paintOneRow(int workingRow) {
        int pixelIterator = 0;
        while (pixelIterator < image.getWidth()) {
            paintOnePixel( pixelIterator, workingRow );
            pixelIterator = pixelIterator + 1;
            System.out.println( "Thread #:" + Thread.currentThread().getId() + "| DEBUG: Row Pixel Count:  " + pixelIterator );
        }
    }

    public void paintTopRows() {
        int rowCount = 0;
        // Starts Off From Corner of Canvas
        painter.moveTo( new Point2D.Double( 0, 0 ) );
        for (int rowIterator = 0; rowIterator < image.getHeight() / 2; rowIterator++) {
            paintOneRow( rowIterator );
            rowCount = rowCount + 1;
            System.out.println( "Thread #:" + Thread.currentThread().getId() + "| DEBUG: Row Count:  " + rowCount );
            // Makes a new Row
            painter.moveTo( new Point2D.Double( 0, rowIterator ) );
            System.out.println( "-------------------------------------------------" );
            System.out.println( "Thread #: " + Thread.currentThread().getId() + "| DEBUG: NEXT ROW" );
            System.out.println( "-------------------------------------------------" );
            if (rowCount == image.getHeight()) {
                System.out.println( "-------------------------------------------------" );
                System.out.println( "Thread #: " + Thread.currentThread().getId() + "| Picture Finished Drawing" );
                System.out.println( "-------------------------------------------------" );
                break;
            }


        }
    }
    public void paintOneBottomRow(int workingRow) {
        int pixelIterator = 0;
        while (pixelIterator < image.getWidth()) {
            paintOnePixel2( pixelIterator, workingRow );
            pixelIterator = pixelIterator + 1;
            System.out.println( "Thread #:" + Thread.currentThread().getId() + "| DEBUG: Row Pixel Count:  " + pixelIterator );
        }
    }

    public void paintBottomRows() {
        System.out.println("Paint Bottom Rows");
        int rowCount = 0;
        // Starts Off at Bottom Corner
        painter2.moveTo( new Point2D.Double( 0, -height ) );
        int rowIterator = -1+height; // -1 to make getPixelColor Happy
        int rowMover = 3; // 3 offset to compensate for gap and over draw
        while( rowIterator > image.getHeight() / 2) {
            paintOneBottomRow( rowIterator );
            rowIterator = rowIterator - 1;
            rowMover = rowMover + 1;
            rowCount = rowCount + 1;
            System.out.println( "Thread #:" + Thread.currentThread().getId() + "| DEBUG: Row Count:  " + rowCount );
            // Makes a new Row
            painter2.moveTo( new Point2D.Double( 0, -height - rowMover));
            System.out.println( "-------------------------------------------------" );
            System.out.println( "Thread #: " + Thread.currentThread().getId() + "| DEBUG: NEXT ROW" );
            System.out.println( "-------------------------------------------------" );
            if (rowCount == image.getHeight()) {
                System.out.println( "-------------------------------------------------" );
                System.out.println( "Thread #: " + Thread.currentThread().getId() + "| Picture Finished Drawing" );
                System.out.println( "-------------------------------------------------" );
                break;
            }


        }
    }
}

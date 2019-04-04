/*
 * A program to paint an abstract gradient in the vertical direction.
 */

package npw;

import painter.SPainter;
import shapes.SSquare;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;

public class ComplexSquares {
    int width = getNumber("Canvas Width in Pixels");
    int height = getNumber("Canvas Height in Pixels ");

    public static String getPathFromFileChooser() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG,JPEG,PNG,", "jpg", "png", "jpeg");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(chooser);
        String path = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getPath();
        }
        return path;
    }

    static BufferedImage chosenImage;

    public static BufferedImage getImageFromPath(String path) throws IOException {
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        return image;
    }


    static {
        try {
            chosenImage = getImageFromPath(getPathFromFileChooser());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Most likely we don't need this one
    private static Color getPixelColor(int x, int y, BufferedImage image) {
        // Getting pixel color by position x and y
        int clr = image.getRGB(x, y);
        int red = (clr & 0x00ff0000) >> 16;
        int green = (clr & 0x0000ff00) >> 8;
        int blue = clr & 0x000000ff;
        Color PixelColor = new Color(red, green, blue);
        System.out.println(PixelColor.toString());
        return PixelColor;
    }

    private void paintOnePixel(int rowWidth, int colheight, SPainter painter, SSquare square, BufferedImage image) throws IOException {
        painter.setColor(getPixelColor(rowWidth, colheight, image));
        //Changing this may make pictures generate faster
        painter.mrt(pixelSize);
        painter.paint(square);


    }

    private void paintOneRow(int height, SPainter painter, SSquare square, BufferedImage image) throws IOException {
        int rowPixelCount = 0;
        for (int width = 0; width < image.getWidth(); width++) {
            paintOnePixel(width, height, painter, square, chosenImage);
            rowPixelCount = rowPixelCount + 1;
            System.out.println("DEBUG: Row Pixel Count:  " + rowPixelCount);

        }

    }

    public void drawRows(SPainter painter, SSquare square, BufferedImage image) throws IOException {
        int rowCount = 0;
        for (int height = 0; height < image.getHeight(); height++) {
            paintOneRow(height, painter, square, chosenImage);
            rowCount = rowCount + 1;
            System.out.println("DEBUG: Row Count:  " + rowCount);
            nextRow(height, painter, image);
            if (rowCount == image.getHeight()) {
                break;
            }
        }
    }

    private void nextRow(int pushDownFactor, SPainter painter, BufferedImage image) {
        System.out.println("DEBUG: NEXT ROW");
        painter.moveTo(new Point2D.Double(0, pushDownFactor));

    }

    //Changing this stretches picture
    static double pixelSize = 1;

    private void paintTheImage() throws IOException {

        SPainter painter = new SPainter("ComplexSquares", width, height);
        SSquare pixel = new SSquare(pixelSize);
        painter.moveTo(new Point2D.Double(0, 0));
        // Paint it!
        drawRows(painter, pixel, chosenImage);
    }

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ComplexSquares();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static int getNumber(String prompt) {
        String nss = JOptionPane.showInputDialog(null, prompt + "?");
        Scanner scanner = new Scanner(nss);
        return scanner.nextInt();
    }

    public ComplexSquares() throws IOException {
        paintTheImage();
    }
}

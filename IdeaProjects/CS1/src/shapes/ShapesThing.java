/*
This program affords opportunities to explore the computational solution to simple geometrical problems
by means of the construction and use of basic shapes.
Made By Miguel Cruz | Lab 4
 */

package shapes;
import java.awt.Color;
import javax.swing.SwingUtilities;

import painter.SPainter;

public class ShapesThing {
    //Global
    SPainter paintBrush = new SPainter("ShapesThing",600,600);
    SSquare square = new SSquare(400);
    SCircle disk = square.inscribingCircle();
    SSquare diamond = disk.inscribingSquare();

    public void paintTheImage(){

        paintBrush.setColor(Color.BLACK);
        paintBrush.setBrushWidth(2);
        paintBrush.draw(square);
        paintBrush.draw(disk);
        paintBrush.setColor(Color.BLUE);
        paintBrush.tl(45);
        paintBrush.paint(diamond);
    }
    public void printShapeData(){

        System.out.println("-------------------------------------------------");
        System.out.println("Square = " + square.toString());
        System.out.println("Area of the square = " + square.area());
        System.out.println("Perimeter of the square = " + square.perimeter());
        System.out.println("Diagonal of the square = " + square.diagonal());
        System.out.println("-------------------------------------------------");

        System.out.println("Disk = " + disk.toString());
        System.out.println("Area of the disk = " + disk.area());
        System.out.println("Perimeter of the disk = " + disk.perimeter());
        System.out.println("-------------------------------------------------");

        System.out.println("Diamond = " + diamond.toString());
        System.out.println("Area of the diamond = " + diamond.area());

    }






    public ShapesThing() {
        paintTheImage();
        printShapeData();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShapesThing();
            }

        });
    }
}


// TODO: 2/20/19  WORK ON WEBSITE ENTRY FOR THIS LAB (Lab 4)
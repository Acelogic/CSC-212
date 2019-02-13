/*
This program affords opportunities to explore the computational solution to simple geometrical problems
by means of the construction and use of basic shapes.
Made By Miguel Cruz | Lab 4
 */

package shapes;
import java.awt.Color;
import javax.swing.SwingUtilities;
import painter.*;
import shapes.*;

public class ShapesThing {

    static SSquare square = new SSquare(400);
    static SCircle disk = square.inscribingCircle();
    static SSquare diamond = disk.inscribingSquare();


    public void paintTheImage(){
        SPainter paintBrush = new SPainter("idk",800,800);
        paintBrush.setRandomColor();
        paintBrush.paint(square);
        paintBrush.draw(disk);
        paintBrush.setColor(Color.BLUE);
        paintBrush.paint(diamond);
    }

    public ShapesThing() {
        paintTheImage();
    }


    public static void main(String[] args) {

        System.out.println("-------------------------------------------------");
        System.out.println("square = " + square.toString());
        System.out.println("area of square = " + square.area());
        System.out.println("perimeter of square = " + square.perimeter());
        System.out.println("diagonal of the square = " + square.diagonal());
        System.out.println("-------------------------------------------------");

        System.out.println("disk = " + disk.toString());
        System.out.println("area of disk = " + disk.area());
        System.out.println("perimeter of disk = " + disk.perimeter());
        System.out.println("-------------------------------------------------");

        System.out.println("diamond = " + diamond.toString());
        System.out.println("area of diamond = " + diamond.area());





        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShapesThing();
            }
        });
    }
}

package npw;

import painter.SPainter;
import shapes.SSquare;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Stella {
    private static void paintCanvas() {
        int squareCount = getNumber( "How many Squares to Draw" );
        SPainter painter = new SPainter( "Stella", 800, 800 );
        drawSquare( painter, squareCount );
    }

    private static void drawSquare(SPainter painter, int squareCount) {
        int squareSide = 700;
        int colorSwitchFlag = 1;
        int rgenColor1Count = 0;
        int rgenColor2Count = 0;
        Color rgenColor1 = randomColor();
        Color rgenColor2 = randomColor();
        SSquare square = new SSquare( squareSide );
        for (int i = 0; i < squareCount; i++) {
            System.out.println( "DEBUG: Drawing Something" ); // Debug
            if (colorSwitchFlag == 1) {
                System.out.println( "DEBUG: Color 1 " ); // Debug
                painter.setColor( rgenColor1 );
                painter.paint( square );
                square.shrink( squareSide / squareCount );
                colorSwitchFlag = 2;
                rgenColor1Count = rgenColor1Count +1; // Debug
            } else {
                System.out.println( "DEBUG: Color 2 " ); // Debug
                painter.setColor( rgenColor2 );
                painter.paint( square );
                square.shrink( squareSide/(double)squareCount );
                colorSwitchFlag = 1;
                rgenColor2Count = rgenColor2Count +1; // Debug
            }
        }
        System.out.println("DEBUG: "+rgenColor1Count + " Colors of Color Type " + rgenColor1.toString() + " was drawn"); // Debug
        System.out.println("DEBUG: "+rgenColor2Count + " Colors of Color Type " + rgenColor2.toString() + " was drawn"); // Debug
    }
    private static Color randomColor() {
        Random rgen = new Random();
        int r = rgen.nextInt( 255 );
        int g = rgen.nextInt( 255 );
        int b = rgen.nextInt( 255 );
        return new Color( r, g, b );
    }
    private static int getNumber(String prompt) {
        String nss = JOptionPane.showInputDialog( null, prompt + "?" );
        Scanner scanner = new Scanner( nss );
        return scanner.nextInt();
    }

    private Stella() {
        paintCanvas();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                new Stella();
            }
        } );
    }


}

/*
 * Program to simulate the phenomenon known as grapheme to color synesthesia.
 * This program is written as an interpreter that recognizes and responds to:
 * - exit | terminate the program
 * - remap | redefine the mapping from letters to colors
 * - WORD OR PHRASE | simply show the word or phrase in synesthetic color
 */
package synesthesia;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import painter.SPainter;
public class GraphemeToColorSynesthesia {
    private static final int fontsize = 30;
    //private static final String theLetters = "AEIOU";
    private static final String theLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String[] letters;
    private static Color[] colors;
    private void paintingCode() {
// INITIALIZATION
        SPainter miro = new SPainter(1200,220);
        miro.setScreenLocation(30, 30);
        miro.setFontSize(fontsize);
        initializeColorMap(theLetters);
// INTERPRETATION
        while ( true ) { 
            String input = JOptionPane.showInputDialog(null,
                    "Please enter a word, or a few words ...");
            if ( input == null ) { input = "EXIT"; }
            input = input.toUpperCase();
            if ( input.equals("EXIT") ) {
                break;
            } else if ( input.equals("REMAP") ) {
                initializeColorMap(theLetters);
                showLetters(miro,theLetters);
            } else {
                showLetters(miro,input.toUpperCase());
            }
        }
        miro.end();
    }
    private static void showLetters(SPainter miro, String input) {
// READY
        eraseWhiteBoard(miro);
// SET
        miro.moveTo(new Point.Double(100,100));
// GO
        for ( int i = 0; i < input.length(); i = i + 1 ) {
            String letter = input.substring(i, i+1);
            Color color = getLetterColor(letter);
            miro.setColor(color);
            miro.draw(letter);
            miro.mrt(fontsize);
        }
    }
    private static void initializeColorMap(String specialLetters) {
        letters = new String[specialLetters.length()];
        colors = new Color[specialLetters.length()];
        for ( int i = 0; i < specialLetters.length(); i = i + 1) {
            letters[i] = specialLetters.substring(i,i+1);
            colors[i] = randomColor();
        }
    }
    private static Color getLetterColor(String letter) {
        for ( int i = 0; i < letters.length; i =i + 1 ) {
            if ( letter.equalsIgnoreCase(letters[i]) ) {
                return colors[i];
            }
        }
        return Color.BLACK;
    }
    private static Color randomColor() {
        int rv = (int)(Math.random()*256);
        int gv = (int)(Math.random()*256);
        int bv = (int)(Math.random()*256);
        return new Color(rv,gv,bv);
    }
    private static void eraseWhiteBoard(SPainter miro) {
        miro.setColor(Color.WHITE);
        miro.wash();
        miro.paintFrame(Color.black, 5);
    }
    // INFRASTRUCTURE FOR SOME SIMPLE PAINTING
    public GraphemeToColorSynesthesia() {
        paintingCode();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GraphemeToColorSynesthesia();
            }
        });
    }
}
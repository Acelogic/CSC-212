/*
 * This program interprets melodic lines given in ABC notation as a
 * chromesthete might.
 *
 * A Pitch class will be defined, and will take center stage in the
 * processing.
 *
 * Interpreting a melody in ABC notation will amount to flashing
 * colored rectangles for prescribed durations, while sounding
 * the pitch! The color of the rectangle will correspond to pitch
 * class. The duration will correspond to the duration of the note.
 * For this first version of the program, the duration will be held
 * constant at 1 beat.
 *
 * Three sorts of images will appear on the screen, the chromesthetic
 * output box, a text input box, and an error message box. Simplicity
 * of design is rendered by permitting only one box to be on the screen
 * at a time.
 *
 * ABC represents notes in a manner consistent with these examples:
 * C, D, E, C D E c d e
 *
 * Google ABC music representation if you would like to know more aAbout it.
 */
package chromesthesia0;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import painter.SPainter;

public class Chromesthesia {
    // INFRASTRUCTURE FOR THE PROGRAM -- LAUNCHING A "GRAPHICS" THREAD
    public static void main(String[] args) {
        SwingUtilities.invokeLater( new ThreadForGUI() );
    }

    private static class ThreadForGUI implements Runnable {
        @Override
        public void run() {
            new Chromesthesia();
        }
    }

    public Chromesthesia() {
        interpreter();
    }

    // FEATURED VARIABLES
    private static SPainter miro;
    private static Pitch[] pitches;

    // THE INTERPRETER
    public static void interpreter() {
        initialization(); // miro and pitches
        while (true) {
            String input = getInput();
            if (input.equalsIgnoreCase( "EXIT" )) {
                break;
            } else {
                try {
                    playMelody( input, pitches );
                } catch (Exception ex) {
                    showErrorMessage( ex.toString() );
                }
            }
        }
        cleanup(); // miro has to go
    }

    // METHODS PERTAINING TO THE CHROMESTHETIC PITCHES
    private static Pitch[] establishPitches(SPainter painter) {
        Pitch[] pitches = new Pitch[9];
        Pitch pitchMiddleC = new Pitch( "C", painter );
        pitches[0] = pitchMiddleC;
        Pitch pitchLowC = new Pitch( "C,", painter );
        pitches[1] = pitchLowC;
        Pitch pitchHighC = new Pitch( "c", painter );
        pitches[2] = pitchHighC;
        Pitch pitchMiddleD = new Pitch( "D", painter );
        pitches[3] = pitchMiddleD;
        Pitch pitchLowD = new Pitch( "D,", painter );
        pitches[4] = pitchLowD;
        Pitch pitchHighD = new Pitch( "d", painter );
        pitches[5] = pitchHighD;
        Pitch pitchMiddleE = new Pitch( "E", painter );
        pitches[6] = pitchMiddleE;
        Pitch pitchLowE = new Pitch( "E,", painter );
        pitches[7] = pitchLowE;
        Pitch pitchHighE = new Pitch( "e", painter );
        pitches[8] = pitchHighE;
        return pitches;
    }

    private static Pitch find(String token, Pitch[] pitches) throws Exception {
        for (int i = 0; i < pitches.length; i = i + 1) {
            Pitch pitch = pitches[i];
            if (pitch.abcName().equals( token )) {
                return pitch;
            }
        }
        throw new Exception( "### PITCH " + token + " NOT FOUND" );
    }

    private static void display(Pitch[] pitches) {
        for (int i = 0; i < pitches.length; i = i + 1) {
            System.out.println( pitches[i].toString() );
        }
    }

    private static void playMelody(String input, Pitch[] pitches) throws Exception {
        Scanner scanner = new Scanner( input );
        while (scanner.hasNext()) {
            String token = scanner.next();
            Pitch pitch = find( token, pitches );
            pitch.play( "1" );
        }
    }

    // INITIALIZATION, CLEANUP, GETTING INPUT, ERROR MESSAGING
    static private void showErrorMessage(String message) {
        miro.setVisible( false );
        JOptionPane.showMessageDialog( null, message );
    }

    private static void initialization() {
// ESTABLISH THE PAINTER AND GIVE IT A SUBSTANTIAL BRUSH WIDTH
        miro = new SPainter( "Chromesthesia", 500, 500 );
        miro.setVisible( false );
        miro.setBrushWidth( 7 );
// ESTABLISH THE CHROMESTITIC PITCH CLASS OBJECTS
        pitches = establishPitches( miro );
        display( pitches );
    }

    private static String getInput() {
        miro.setVisible( false );
        String label = "Please enter a melody in ABC notation, or EXIT ... ";
        String input = JOptionPane.showInputDialog( null, label );
        miro.setVisible( true );
        if (input == null) {
            input = "";
        }
        return input;
    }

    static private void cleanup() {
        System.exit( 0 );
    }
}
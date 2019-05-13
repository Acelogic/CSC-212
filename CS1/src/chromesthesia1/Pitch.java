/*
* The Pitch class models the pitch of a note in a manner that will facilitate
* the chromesthetic processing of the pitch. A Pitch object will have five
* properties:
* - String name | ABC notation pitch name
* - JFramelessPainter painter | the painting agent
* - Note note | a note that will be set to the pitch corresponding to the
121
* ABC notation pitch name
* - SRectangle box | an SRectangle object that will chromesthetically
* represent the pitch
* - Color color | the color associated with the pitch for the presumed
* chromesthete
*/
package chromesthesia1;

import note.SNote;
import painter.SPainter;
import shapes.SRectangle;

import java.awt.*;

public class Pitch {
    // INSTANCE VARIABLES
    private String abcName;
    private SPainter painter;
    private SRectangle box;
    private SNote note;
    private Color color;

    public Pitch(String abcName, SPainter painter) {
        this.abcName = abcName;
        this.painter = painter;
        this.box = new SRectangle( painter.painterHeight - 50, painter.painterWidth - 50 );
        this.note = createNoteForThisPitch( abcName );
        this.color = getPitchClassColor( abcName.substring( 0, 1 ).toUpperCase() );
    }

    public String toString() {
        return "[ " + abcName + " | " + note.degree() + " | " + color + " ]";
    }

    public String abcName() {
        return abcName;
    }

    private SNote createNoteForThisPitch(String abcPitchClassName) {
        // TODO: Fix Musical Notes for new pitches


        SNote note = new SNote();
        if (abcPitchClassName.equals( "C" )) {
        } else if (abcPitchClassName.equals( "C," )) {
            note.lp( 7 );
        } else if (abcPitchClassName.equals( "c" )) {
            note.rp( 7 );

        } else if (abcPitchClassName.equals( "D" )) {
            note.rp( 1 );
        } else if (abcPitchClassName.equals( "D," )) {
            note.lp( 6 );
        } else if (abcPitchClassName.equals( "d" )) {
            note.rp( 8 );

        } else if (abcPitchClassName.equals( "E" )) {
            note.rp( 2 );
        } else if (abcPitchClassName.equals( "E," )) {
            note.lp( 5 );
        } else if (abcPitchClassName.equals( "e" )) {
            note.rp( 9 );

        } else if (abcPitchClassName.equals( "F" )) {
            note.rp( 3 );
        } else if (abcPitchClassName.equals( "F," )) {
            note.lp( 4 );
        } else if (abcPitchClassName.equals( "f" )) {
            note.rp( 10 );

        } else if (abcPitchClassName.equals( "G" )) {
            note.rp( 4);
        } else if (abcPitchClassName.equals( "G," )) {
            note.lp( 3 );
        } else if (abcPitchClassName.equals( "g" )) {
            note.rp( 11 );

        } else if (abcPitchClassName.equals( "A" )) {
            note.rp( 5 );
        } else if (abcPitchClassName.equals( "A," )) {
            note.lp( 2 );
        } else if (abcPitchClassName.equals( "a" )) {
            note.rp( 12 );

        } else if (abcPitchClassName.equals( "B" )) {
            note.rp( 6 );
        } else if (abcPitchClassName.equals( "B," )) {
            note.lp( 1);
        } else if (abcPitchClassName.equals( "b" )) {
            note.rp( 13 );

        }
        return note;
    }

    private Color getPitchClassColor(String letter) {
        if (letter.equals( "C" )) {
            return Color.BLUE;
        } else if (letter.equals( "D" )) {
            return Color.GREEN;
        } else if (letter.equals( "E" )) {
            return new Color( 127, 0, 127 );
        } else if (letter.equals( "F" )) {
            return Color.RED;
        } else if (letter.equals( "G" )) {
            return Color.CYAN;
        } else if (letter.equals( "A" )) {
            return Color.YELLOW;
        } else if (letter.equals( "B" )) {
            return Color.ORANGE;
        }
        else {
            return Color.BLACK;
        }
    }

    public void play(String d) {
        painter.setColor( color );
        painter.paint( box );
        painter.setColor( randomColor() );
        painter.draw( box );
        if (d.equals( "1" )) {
            note.play();
        }
    }

    private static Color randomColor() {
        int rv = (int) (Math.random() * 256);
        int gv = (int) (Math.random() * 256);
        int bv = (int) (Math.random() * 256);
        return new Color( rv, gv, bv );
    }
}
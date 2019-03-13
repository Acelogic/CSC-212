package stringthing;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class StringThing {

    public


    static void main(String[] args) {
// POINT A: CREATE A PRINT SOME STRINGS THAT REPRESENT NAMES
        String singer = "Holiday, Billie";
        String sculptor = "Claudel, Camille";
        String painter = "Picasso, Pablo";
        String dancer ="Zotto, Osvaldo";
        String self = "Cruz, Miguel";

        System.out.println("\nNames ...");

        System.out.println(singer);
        System.out.println(sculptor);
        System.out.println(painter);
        System.out.println(dancer);
        System.out.println(self);

// POINT B: COMPUTE AND PRINT THE LENGTHS OF THE STRINGS, WITHOUT LABELS
        int singerLength = singer.length();
        int sculptorLength = sculptor.length();
        int painterLength = painter.length();
        int dancerLength = dancer.length();
        int selfLength = self.length();

        System.out.println("\nName lengths ...");

        System.out.println(singerLength);
        System.out.println(sculptorLength);
        System.out.println(painterLength);
        System.out.println(dancerLength);
        System.out.println(selfLength);


// POINT C: COMPUTE AND PRINT THE LOCATION OF THE COMMA WITHIN EACH STRING, NO LABELS
        int singerCommaPosition = singer.indexOf(",");
        int sculptorCommaPosition = sculptor.indexOf(",");
        int painterCommaPosition = painter.indexOf(",");
        int dancerCommaPosition = dancer.indexOf(",");
        int selfCommaPosition = self.indexOf(",");

        System.out.println("\nComma positions ...");

        System.out.println(singerCommaPosition);
        System.out.println(sculptorCommaPosition);
        System.out.println(painterCommaPosition);
        System.out.println(dancerCommaPosition);
        System.out.println(selfCommaPosition);

// POINT D: COMPUTE AND PRINT THE FIVE FIRST NAMES, WITH NO LABELS
        String singerFirst = singer.substring(singerLength - singerCommaPosition);  //an offset of +2 could be added to CommaPosition to bare the same results
        String sculptorFirst = sculptor.substring(sculptorLength - sculptorCommaPosition);
        String painterFirst = painter.substring(painterLength - painterCommaPosition);
        String dancerFirst = dancer.substring(dancerLength - dancerCommaPosition);
        String selfFirst = self.substring(selfLength - selfCommaPosition);

        System.out.println("\nFirst names ...");

        System.out.println(singerFirst);
        System.out.println(sculptorFirst);
        System.out.println(painterFirst);
        System.out.println(dancerFirst);
        System.out.println(selfFirst);
// POINT E: COMPUTE AND PRINT THE FIVE LAST NAMES, WITH NO LABELS
        String singerLast = singer.substring(0, singerCommaPosition  );
        String sculptorLast = sculptor.substring(0 ,sculptorCommaPosition);
        String painterLast = painter.substring( 0, painterCommaPosition);
        String dancerLast = dancer.substring( 0, dancerCommaPosition);
        String selfLast = self.substring( 0, selfCommaPosition);

        System.out.println("\nLast names ...");

        System.out.println(singerLast);
        System.out.println(sculptorLast);
        System.out.println(painterLast);
        System.out.println(dancerLast);
        System.out.println(selfLast);

// POINT F: COMPUTE AND PRINT THE FIRST NAMES, AGAIN



        System.out.println("\nFirst names, once again ...");
        System.out.println(firstName(singer));
        System.out.println(firstName(sculptor));
        System.out.println(firstName(painter));
        System.out.println(firstName(dancer));
        System.out.println(firstName(self));

// // POINT G: COMPUTE AND PRINT THE LAST NAMES, AGAIN

        System.out.println("\nLast names, once again ...");
        System.out.println(lastName(singer));
        System.out.println(lastName(sculptor));
        System.out.println(lastName(painter));
        System.out.println(lastName(dancer));
        System.out.println(lastName(self));

// // POINT H: COMPUTE AND PRINT THE FULL NAMES, NATURAL STYLE
        System.out.println("\nFull names, natural style ...");
        System.out.println(fullName(singer));
        System.out.println(fullName(sculptor));
        System.out.println(fullName(painter));
        System.out.println(fullName(dancer));
        System.out.println(fullName(self));



    }

    private static String firstName(String directoryStyleName) {
        String firstName = directoryStyleName.substring(2+directoryStyleName.indexOf(","));

        return firstName;

    }

    private static String lastName(String directoryStyleName) {

       String lastName = directoryStyleName.substring(0, directoryStyleName.indexOf(","));

        return lastName;

    }


    private static String fullName(String directoryStyleName) {


        return firstName(directoryStyleName ) + " " + lastName(directoryStyleName );

    }
}



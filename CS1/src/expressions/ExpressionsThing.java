/*
 *This program affords opportunities to explore the construction of arithmetic expressions in the context
  of some very simple problem solving.
 * Made By Miguel Cruz | Lab 4
 */
package expressions;

public class ExpressionsThing {
    public static void main(String[] args) {
        double one = 3.14 * 5 + 5; // Incorrect Expression
        System.out.println("one = " + one);

        double two = 3.14 * ( 5 + 5 );
        System.out.println("two = " + two);

        double three = ( 3.14 * ( 5 + 5 ) ); // Fully Parenthesized
        System.out.println("three = " + three);

        int four = (2*3);
        System.out.println("four = " + four);

        double five = ((double)55/2);
        System.out.println("five = " + five);

        double six = (((double)65)/3);
        System.out.println("six = " + six);

        double seven = ((double) 55 / 2) + ((double) 65 / 3);
        System.out.println("seven = " + seven);

        double eight = (3.14 * (11.3 * 11.3));
        System.out.println(("eight = " + eight));

        double nine = (27.7 * 27.7);
        System.out.println("nine = " + nine);

        double ten = (((3.14 * (11.3 * 11.3))+(27.7 * 27.7))/2);
        System.out.println("ten = " + ten);

        double eleven = (0.17*243.5);
        System.out.println("eleven = " + eleven);

        int twelve = (3/3);
        System.out.println("twelve = " + twelve);

        int thirteen = ((7-4)-2);
        System.out.println("thirteen = " + thirteen);

        int fourteen = (((9-7)+3)-1);
        System.out.println("fourteen = " + fourteen);

        int fifteen = (6-((2+2+4)/8));
        System.out.println("fifteen = " + fifteen);


    }

}

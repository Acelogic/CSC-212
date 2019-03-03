package shapes;

import java.math.*;


public class GraySpace {
    public static void main(String[] args) {
        //Constants
                double darkSquareSide = 40.0;
                double graySquareGap = 3;

                //There's no way to compute the side of the gray square without getting the diagonal by hand
                double graySquareDiagonal = ((darkSquareSide - (graySquareGap*2))/2);

                //Pythagorean Theorem
                double graySquareSide = Math.sqrt(Math.pow(graySquareDiagonal/2,2)+ Math.pow(graySquareDiagonal/2,2));

                double goldSquareGap = 4.5;

        //Object Instantiations
                SSquare darkSquare = new SSquare(darkSquareSide);
                SSquare graySquare = new SSquare(graySquareSide);


        //Area Calculations
                double netDarkSquareArea = darkSquare.area();
                double netGraySquareArea = graySquare.area();

        //Print Statements
                System.out.println("Gray Square Diagonal: " + graySquareDiagonal);
                System.out.println("Gray Square Side: " +graySquareSide);
    }
}

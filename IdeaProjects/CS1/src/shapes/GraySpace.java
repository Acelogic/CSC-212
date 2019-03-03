package shapes;


public class GraySpace {

    public static double pythagoreanTheorem(double a, double b){
        double c = Math.sqrt( Math.pow(a,2) + Math.pow(b,2));
        return c;
    }

    //Constants
    static double getDarkSquareSide = 40;
    static double quarterOfDarkSquareSide = getDarkSquareSide * 0.25;

        // Grey Square Constants
        static double getGraySquareGap = 3;
        static double getAmountOfGraySquares = 2;
            // Diagonals are calculated using the Circle Class and the gaps given (Should be within restrictions)
            static SCircle graySquareHelper = new SCircle(quarterOfDarkSquareSide);
            static double getGraySquareDiagonal = graySquareHelper.diameter() - getGraySquareGap;
            static double getGraySquareSide = pythagoreanTheorem(getGraySquareDiagonal/2 ,getGraySquareDiagonal/2);

        // Orange Square Constants
        static double getOrangeSquareBottomGap = 4.5;
        static double getOrangeSquareTopGap = getGraySquareDiagonal/2 + getGraySquareGap;
        static double getAmountOfOrangeSquares = 1;
            // Diagonals are calculated using the Circle Class and the gaps given (Should be within restrictions)
            static SCircle orangeSquareHelper = new SCircle((getDarkSquareSide - getOrangeSquareTopGap - getOrangeSquareBottomGap)/2);
            static double getOrangeSquareDiagonal = orangeSquareHelper.diameter();
            static double getOrangeSquareSide = pythagoreanTheorem(getOrangeSquareDiagonal/2, getOrangeSquareDiagonal/2);

public static void main(String[] args) {

        //Object Instantiations
                SSquare darkSquare = new SSquare(getDarkSquareSide);
                SSquare graySquare = new SSquare(getGraySquareSide);
                SSquare orangeSquare = new SSquare(getOrangeSquareSide);
        //Area Calculations
                double netDarkSquareArea = darkSquare.area();
                double netGraySquareArea = graySquare.area() * getAmountOfGraySquares;
                double netOrangeSquareArea = orangeSquare.area() * getAmountOfOrangeSquares;
                double netRemainingDarkSquareArea = netDarkSquareArea - (netGraySquareArea + netOrangeSquareArea);
        //Print Statements
            System.out.println("-------------------------------------------------");
                System.out.println("Dark Gray Square Area: " + netDarkSquareArea);
            System.out.println("-------------------------------------------------");
                System.out.println("Net Gray Square Area: " + netGraySquareArea + " With: " + getAmountOfGraySquares + " Gray Squares");
                System.out.println("Gray Square Diagonal: " + getGraySquareDiagonal);
                System.out.println("Gray Square Side: " + getGraySquareSide);
            System.out.println("-------------------------------------------------");
                System.out.println("Net Orange Square Area: " + netOrangeSquareArea + " With: " + getAmountOfOrangeSquares + " Orange Squares");
                System.out.println("Orange Square Diagonal: " + getOrangeSquareDiagonal);
                System.out.println("Orange Square Side: " + getOrangeSquareSide);
            System.out.println("-------------------------------------------------");
                System.out.println("Dark Gray Square Area Available: " + netRemainingDarkSquareArea);
            System.out.println("-------------------------------------------------");
                System.out.println("Calculation: " + netDarkSquareArea + " - " + (netGraySquareArea + netOrangeSquareArea) + " = " + netRemainingDarkSquareArea );
    }
}

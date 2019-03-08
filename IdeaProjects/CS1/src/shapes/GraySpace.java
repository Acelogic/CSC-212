package shapes;


public class GraySpace {
    //Constants
    static double getDarkSquareSide = 40;
    static double getGraySquareGap = 3;

    static double getAmountOfGraySquares = 2;
    static double getOrangeSquareBottomGap = 4.5;
    static double getAmountOfOrangeSquares = 1;

    static double getGraySquareHelperRadius = (getDarkSquareSide - 2*getGraySquareGap)/4;
    static SCircle graySquareHelper = new SCircle(getGraySquareHelperRadius);


    static double getOrangeSquareTopGap = getGraySquareHelperRadius + getGraySquareGap;
    static double getOrangeSquareHelperRadius = (getDarkSquareSide - (getOrangeSquareTopGap + getOrangeSquareBottomGap))/2;
    static SCircle orangeSquareHelper = new SCircle((getOrangeSquareHelperRadius));

public static void main(String[] args) {

        //Object Instantiations
                SSquare darkSquare = new SSquare(getDarkSquareSide);
                SSquare graySquare = graySquareHelper.inscribingSquare();
                SSquare orangeSquare = orangeSquareHelper.inscribingSquare();
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
                System.out.println("Gray Square Diagonal: " + graySquare.diagonal());
                System.out.println("Gray Square Side: " + graySquare.side());
            System.out.println("-------------------------------------------------");
                System.out.println("Net Orange Square Area: " + netOrangeSquareArea + " With: " + getAmountOfOrangeSquares + " Orange Squares");
                System.out.println("Orange Square Diagonal: " + orangeSquare.diagonal());
                System.out.println("Orange Square Side: " + orangeSquare.side());
            System.out.println("-------------------------------------------------");
                System.out.println("Dark Gray Square Area Available: " + netRemainingDarkSquareArea);
            System.out.println("-------------------------------------------------");
                System.out.println("Calculation: " + netDarkSquareArea + " - " + (netGraySquareArea + netOrangeSquareArea) + " = " + netRemainingDarkSquareArea );
    }
}

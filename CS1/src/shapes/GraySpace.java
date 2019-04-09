package shapes;


public class GraySpace {
    //Constants
    double getDarkSquareSide = 40;
    double getGraySquareGap = 3;

    double getAmountOfGraySquares = 2;
    double getOrangeSquareBottomGap = 4.5;
    double getAmountOfOrangeSquares = 1;

    double getGraySquareHelperRadius = (getDarkSquareSide - (2 * getGraySquareGap)) / 4;
    SCircle graySquareHelper = new SCircle(getGraySquareHelperRadius);


    double getOrangeSquareTopGap = getGraySquareHelperRadius + getGraySquareGap;
    double getOrangeSquareHelperRadius = (getDarkSquareSide - (getOrangeSquareTopGap + getOrangeSquareBottomGap)) / 2;
    SCircle orangeSquareHelper = new SCircle((getOrangeSquareHelperRadius));

    public GraySpace(){
        calculate();
    }

    public static void main(String[] args) {
        new GraySpace();
    }

    public void calculate() {
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
        System.out.println("Calculation: " + netDarkSquareArea + " - " + (netGraySquareArea + netOrangeSquareArea) + " = " + netRemainingDarkSquareArea);
    }
}

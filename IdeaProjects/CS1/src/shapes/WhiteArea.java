package shapes;

public class WhiteArea {

    public static void main(String[] args) {

    //Constants
    double edgeWidth = 0.75;
    double dotDiameter = edgeWidth/8;
    double dotRadius = dotDiameter/2;
    double amountOfDots = 21;
    double amountOfFaces = 6;


    //Object Instantiation
    SSquare diceFace = new SSquare(edgeWidth);
    SCircle diceDot = new SCircle(dotRadius);

    //Area Calculations
    double netDiceFaceArea = diceFace.area() * amountOfFaces;
    double netDotArea = (diceDot.area() * amountOfDots);

    //White Space Available
    double netDiceWhiteSpace = netDiceFaceArea - netDotArea;

    //Print Statements
    System.out.println("-------------------------------------------------");
    System.out.println("Faces in a Dice: " + amountOfFaces);
    System.out.println("Dots in a Dice: " + amountOfDots);
    System.out.println("-------------------------------------------------");
    System.out.println("Area of Dice Faces: " + netDiceFaceArea);
    System.out.println("Area Covered By Dots: " + netDotArea);
    System.out.println("White Space Available: " + netDiceWhiteSpace);
    System.out.println("-------------------------------------------------");
    System.out.println("Calculation: " + netDiceFaceArea + " - " + netDotArea + " = " + netDiceWhiteSpace );

    //TODO: Task is Done

    }

}

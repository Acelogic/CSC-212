package shapes;

public class WorkArea {
    public static void main(String[] args) {
        //Constants
        double deskHeight = 24;
        double deskWidth = 36;

        double bookHeight = 8.5;
        double bookWidth = 11;

        double cupRadius = 1.15;
        double plateRadius = 6;

        double amountOfBooks = 2;
        double amountOfPlates = 3;
        double amountOfCoasters = 3;

        //Object Instantiation
        SRectangle desk = new SRectangle(deskHeight, deskWidth);
        SRectangle book = new SRectangle(bookHeight, bookWidth);

        SSquare coaster = new SSquare(cupRadius*2); // *2 because the diameter of the inscribing cup would be the length of the square
        SCircle glassCups = coaster.inscribingCircle();

        SCircle plate = new SCircle(plateRadius);

        //Area Calculations
        double netDeskArea = desk.area();
        double netBookArea = book.area()*amountOfBooks;
        double netPlateArea = plate.area()*amountOfPlates;
        double netCoasterArea = coaster.area()*amountOfCoasters;

        //Desk area occupied and area available
        double areaCovered = netBookArea + netPlateArea + netCoasterArea;
        double areaUncovered = netDeskArea - areaCovered;

        //Print Statements
        System.out.println("-------------------------------------------------");
        System.out.println("Desk Area: " + netDeskArea);
        System.out.println("Area Covered: " + areaCovered);
        System.out.println("Area Uncovered: " + areaUncovered);
        System.out.println("-------------------------------------------------");
        System.out.println("Calculation: " +netDeskArea + " - " + areaCovered + " = " + areaUncovered );
    }
}

//TODO: Ask Question about step 2 in task 1 regarding the coaster generation (Task 1 Done For the Most Part)


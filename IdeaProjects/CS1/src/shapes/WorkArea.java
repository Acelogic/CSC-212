package shapes;
// How is this working without imports ????

public class WorkArea {
    public static void main(String[] args) {

        double cupRadius = 1.15;

        SRectangle desk = new SRectangle(24, 36);
        SRectangle books = new SRectangle(8.5, 11);

        SSquare coasters = new SSquare(cupRadius*2); // *2 because the diameter of the inscribing cup would be the length of the square
        SCircle glassCups = coasters.inscribingCircle();

        SCircle plates = new SCircle(6);

        double netBookArea = books.area() *2; // I'm not writing books.area() + ... to represent multiple books, that's over abstracting.
        double netPlateArea = plates.area() *3;
        double netCoasterArea = coasters.area() *3;
        double netDeskArea = desk.area();

        double areaCovered = netBookArea + netPlateArea + netCoasterArea;
        double areaUncovered = netDeskArea - areaCovered;




        System.out.println("Desk Area: " + netDeskArea);
        System.out.println("Area Covered: " + areaCovered);
        System.out.println("Area Uncovered: " + areaUncovered);
    }

}

//TODO: Compare area of glassCups to area of a coaster. (Task 1 done for the most part)

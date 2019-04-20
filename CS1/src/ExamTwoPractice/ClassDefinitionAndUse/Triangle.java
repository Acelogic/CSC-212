package ExamTwoPractice.ClassDefinitionAndUse;

public class Triangle {
    // Part 1 (Instance Variables / Fields)
    private double sideA;
    private double sideB;
    private double sideC;


    // Part 2 ( Constructor that one input to initialize the triangle )
    public Triangle(double side) {
        sideA = side;
        sideB = side;
        sideC = side;
    }

    // Part 3 (Constructor that multiple inputs to initialize the triangle)
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;   // "this" is used to DISAMBIGUATE the **NAME** of the PARAMETER from the INSTANCE VARIABLE/FIELD
        this.sideB = sideB;   // Basically for java to know which sideA we are talking about, the global one declared above
        this.sideC = sideC;   // or the local declared as a parameter within this method block

    }

    // Part 4 (Methods)
    public double perimeter() {
        return sideA + sideB + sideC;
    }

}

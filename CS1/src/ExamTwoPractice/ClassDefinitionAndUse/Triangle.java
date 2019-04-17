package ExamTwoPractice.ClassDefinitionAndUse;

public class Triangle {
    // Part 1
    private double sideA;
    private double sideB;
    private double sideC;


    // Part 2
    public Triangle(double side) {
        sideA = side;
        sideB = side;
        sideC = side;
    }

    // Part 3
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;

    }

    // Part 4
    public double perimeter() {
        return sideA + sideB + sideC;
    }

}

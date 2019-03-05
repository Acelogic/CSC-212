package shapes;

import java.util.Scanner;

public class ShippingContainer {

    public static void main(String[] args) {
       //Constants
        Scanner scanner = new Scanner(System.in);
        double width = scanner.nextDouble();
        double length = scanner.nextDouble();
        double height = scanner.nextDouble();
        double face;
        double key;
        double distance;
        //Objects
        SRectangle prismLateralSides = new SRectangle(length, width);
        SSquare prismBase =  new SSquare(height);

        key = prismLateralSides.diagonal() * height;


    }

}

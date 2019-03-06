package shapes;

import java.util.Scanner;

public class ShippingContainer {



    //Constants
    static double width;
    static double length;
    static double height;

    static SRectangle prismFace;
    static double distance;


    public static void setDimensions(Scanner scan){
        // User input Dimensions
        System.out.println("-------------------------------------------------");
        System.out.println("Enter Your Width");
        width = scan.nextDouble();

        System.out.println("-------------------------------------------------");
        System.out.println("Enter Your Length");
        length = scan.nextDouble();

        System.out.println("-------------------------------------------------");
        System.out.println("Enter Your Height");

        height = scan.nextDouble();
        System.out.println("-------------------------------------------------");
        //Inputs are set as input to a static rectangle object
        prismFace = new SRectangle(length, width);

        //Confirming Dimensions
        System.out.println("Just to Confirm Your Dimensions are ");
        System.out.println("Width : " + width + " | Length : " + length + " | Height : " + height);
        System.out.println("-------------------------------------------------");
        System.out.println("yes/no");
        System.out.println("-------------------------------------------------");

        //Conditional to Fix Dimensions if user enter wrong thing
        String confirmFlag = scan.next();

        if (confirmFlag.equals("yes")) {
            System.out.println("Okay :) ");

        }
        else if(confirmFlag.equals("no")){
            System.out.println("Feel Free to Enter it again");
            setDimensions(scan);
        }
        else{
            System.out.println("Invalid answer try again");
            setDimensions(scan);
        }


    }

    public static void getCalculations(){
        //Constants
        SRectangle key = new SRectangle(height, prismFace.diagonal());
        double keyWidth = prismFace.diagonal();
        double keyHeight = height;
        double keyArea = key.area();
        distance = key.diagonal();
        double longestObject = distance;

        //Print Statements
        System.out.println("-------------------------------------------------");
        System.out.println("Key/Curtain Width: " + keyWidth);
        System.out.println("Key/Curtain Height: " + keyHeight);
        System.out.println("Key/Curtain Area: " + keyArea);
        System.out.println("-------------------------------------------------");
        System.out.println("Diagonal Rect Prism Distance : " + longestObject);




    }

    public static void main(String[] args) {
        //Objects
        Scanner scanner = new Scanner(System.in);
        setDimensions(scanner);
        getCalculations();



    }
}
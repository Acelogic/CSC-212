package Exam2;

public class StringAndThings {
    public static void main(String[] args) {
        String courseIdentifier = "CSC212-800";
        String startTime = "10:20 AM";

        //Part A
        int colon = startTime.indexOf(":");

        //Part B
        int space = startTime.indexOf(" ");

        //Part C
        String hour = startTime.substring(0, colon);

        //Part D
        String ampm = startTime.substring(space + 1);

        //Part E
        boolean earlyClass = hour.equals("8") | hour.equals("9");

        //Part F
        boolean eightAM = hour.equals("8") & ampm.equals("AM");

        //Part G
        if (ampm.equals("AM")) {
            System.out.println("Morning");
        } else {
            System.out.println("Afternoon");
        }


    }


}

//TODO: Signatures

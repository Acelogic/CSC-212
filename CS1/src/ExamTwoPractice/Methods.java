package ExamTwoPractice;

import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
    // Part A
    public static ArrayList<String> littleList(String x, String y, String z){
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add(x);
        stringList.add(y);
        stringList.add(z);
        return stringList;
    }
    // Part B
    public static void interpretPrintCommand(int[] numbers, String command){
        if(command.equalsIgnoreCase("First")) {
            System.out.println(numbers[0]);
        }
        else if(command.equalsIgnoreCase("Last")){
            System.out.println(numbers[numbers.length -1]);
        }
        else {
            Scanner sc = new Scanner(command);
            System.out.println(numbers[sc.nextInt()]);
        }
    }
    public static void main(String[] args) {
        //Part A Test
        System.out.println("Expected Output For Part A");
        System.out.println("----------------------------");
        System.out.println(littleList("Testing", "Testing", "123"));
        System.out.println("----------------------------");

        //Part B Test
        Scanner sc = new Scanner(System.in);
        int[] numberArray = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Part B Demo ");
        System.out.print("Enter a command along the lines of \" First, Last, or Nth Element \": ");
        interpretPrintCommand(numberArray, sc.next());
        System.out.println("^ Expected Output For Part B");
    }

}

package algorithms.Searching;


import java.util.ArrayList;


public class SequentialSearch {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = generateNumbers(30);
        System.out.println("The Numbers....");
        display(numbers);
        System.out.println("\n\n");
        for(int i = 1; i <=10; i++){
            Integer it = (int)(Math.random()*90)+10;
            System.out.println("Searching for " + it  + "...");
            search(it,numbers,0,numbers.size()-1);

        }

    }


    private static void search(Integer it, ArrayList<Integer> numbers, int first, int last) {
        if (first > last) {
            System.out.println("FAILURE");

        } else {
            Integer key = numbers.get(first);
            System.out.print(key + " ");
            if (it == key) {
                System.out.println("SUCCESS");
            } else {
                search(it, numbers, first + 1, last);
            }
        }


    }

    private static ArrayList<Integer> generateNumbers(int numberOfNumbers) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= numberOfNumbers; i++) {
            Integer number = (int) (Math.random() * 90) + 10;
            numbers.add(number);

        }
        return numbers;
    }

    private static void display(ArrayList<Integer> numbers){
        for(Integer number : numbers) {
            System.out.print(number + " ");

        }
        System.out.println();
    }





}
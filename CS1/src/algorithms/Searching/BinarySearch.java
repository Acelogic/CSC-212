package algorithms.Searching;

import java.util.ArrayList;


public class BinarySearch {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = generateNumbers(30);
        System.out.println("The Numbers ...");
        display(numbers);
        sort(numbers);
        System.out.println("The numbers ordered low to high ..");
        display(numbers);
        System.out.println("\n\n");
        for (int i = 1; i < 10; i++) {
            Integer it = (int) (Math.random() * 90) + 10;
            System.out.println("Searching for " + it + "...");
            search(it, numbers, 0, numbers.size() - 1);

        }

    }

    private static void search(Integer it, ArrayList<Integer> numbers, int first, int last) {
        if (first > last) {
            System.out.println("FAILURE");
        } else {
            int middle = (first + last) / 2;
            Integer key = numbers.get(middle);
            System.out.print(key + " ");
            if (it == key) {
                System.out.println("SUCCESS");
            } else if (it < key) {
                search(it, numbers, first, middle - 1);
            } else if (it > key) {
                search(it, numbers, middle + 1, last);
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


    private static Integer maximumIndex(ArrayList<Integer> numbers, int limit) {
        Integer champion = numbers.get(0);
        int mx = 0;
        for (int x = 0; x <= limit; x++) {
            Integer challenger = numbers.get(x);
            if (challenger > champion) {
                champion = challenger;
                mx = x;
            }
        }
        return mx;
    }


    private static void sort(ArrayList<Integer> numbers) {
        for (int x = numbers.size() - 1; x >= 1; x--) {
            int mx = maximumIndex(numbers, x);
            swap(numbers, mx, x);
        }

    }


    private static void display(ArrayList<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private static void swap(ArrayList<Integer> numbers, int mx, int x) {
        Integer temp = numbers.get(mx);
        numbers.set(mx, numbers.get(x));
        numbers.set(x, temp);
    }
}
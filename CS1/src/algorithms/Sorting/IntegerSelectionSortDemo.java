package algorithms.Sorting;

import java.util.ArrayList;

public class IntegerSelectionSortDemo {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = generateNumbers(30);

        IntegerSelectionSort intSort = new IntegerSelectionSort(numberList);
        // Number List
        System.out.println("\033[1mNUMBER SORTING (SELECTION SORT)\033[0m\n");

        System.out.println("Original List Size: " + numberList.size());
        System.out.println("Unsorted List: " + intSort.unsortedList());
        System.out.println("Max Value: " + intSort.maxValue());
        System.out.println("\033[1mSorted List: \033[31m" + intSort.sort());




    }
    public static ArrayList<Integer> generateNumbers(int numberOfNumbers) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= numberOfNumbers; i++) {
            Integer number = (int) (Math.random() * 90) + 10;
            numbers.add(number);
        }
        return numbers;
    }

}

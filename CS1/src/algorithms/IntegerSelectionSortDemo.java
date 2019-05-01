package algorithms;

import java.util.ArrayList;

public class IntegerSelectionSortDemo {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(8);
        numberList.add(54);
        numberList.add(32);
        numberList.add(9);
        numberList.add(1);
        numberList.add(3);
        numberList.add(4);
        numberList.add(-20);
        numberList.add(23);
        numberList.add(100);

        IntegerSelectionSort intSort = new IntegerSelectionSort(numberList);
        // Number List
        System.out.println("\033[1mNUMBER SORTING (SELECTION SORT)\033[0m\n");

        System.out.println("Original List Size: " + numberList.size());
        System.out.println("Unsorted List: " + intSort.unsortedList());
        System.out.println("Max Value: " + intSort.maxValue());

        System.out.println("\033[1mSorted List: \033[31m" + intSort.sort());




    }
}

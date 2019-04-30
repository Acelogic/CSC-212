package algorithms;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class SelectionSortDemo {
    public static void main(String[] args) {

        ArrayList<Integer> numberList = new ArrayList<>();

        numberList.add(8);
        numberList.add(12);
        numberList.add(64);
        numberList.add(23);
        numberList.add(2);
        numberList.add(34);
        numberList.add(88);
        numberList.add(79);

        IntegerSelectionSort intSort = new IntegerSelectionSort(numberList);

        System.out.println("Max Value: " + intSort.maxValue());
        System.out.println("Unsorted List: " + intSort.unsortedList());
        System.out.println("Sorted List: " + intSort.sort());

    }


}

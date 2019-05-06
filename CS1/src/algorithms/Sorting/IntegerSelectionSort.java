package algorithms.Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class IntegerSelectionSort {

    private ArrayList<Integer> list;

    public IntegerSelectionSort(ArrayList<Integer> list) {
        this.list = list;
    }

    public ArrayList<Integer> unsortedList() {
        return list;
    }

    public Integer maxValue() {
        Integer currentMax = list.get(0);
        for (Integer maxCandidate : list) {
            if (currentMax < maxCandidate) {
                currentMax = maxCandidate;
            }
        }
        return currentMax;
    }

    public int maxValue(int index1, int index2) {
        Integer currentMax = list.subList(index1, index2).get(0);
        System.out.println("First Max: " + currentMax);
        for (int i = 1; i < list.subList(index1, index2).size(); i++) {
            int maxCandidate = list.subList(index1, index2).get(i);
            if (currentMax < maxCandidate) {
                currentMax = maxCandidate;
                System.out.println("Current Max: " + currentMax);
            }
        }
        return currentMax;
    }


    public ArrayList<Integer> sort() {
        for (int i = 1; i < list.size(); i++) {
            System.out.println("--------------------------------------------");
            System.out.println("List Size: " + (list.size() - i));
            System.out.println("Sub List: " + list.subList(0, list.size() - i));
            Collections.swap(list, list.indexOf(maxValue(0, (list.size() - i) +1)), list.size() - i);
        }
        return list;
    }


}
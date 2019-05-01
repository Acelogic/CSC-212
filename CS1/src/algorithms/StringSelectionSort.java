package algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class StringSelectionSort {

    private ArrayList<String> list;

    public StringSelectionSort(ArrayList<String> list) {
        this.list = list;

    }

    public ArrayList<String> unsortedList() {
        return list;
    }

    public String maxValue() {
        String currentMax = list.get(0);
        for (String maxCandidate : list) {
            if (currentMax.length() < maxCandidate.length()) {
                currentMax = maxCandidate;
            }
        }
        return currentMax;
    }

    public String maxValue(int index1, int index2) {
        String currentMax = list.subList(index1, index2).get(0);

        System.out.println("First Max: " + currentMax);

        for (int i = 1; i < list.subList(index1, index2 + 1).size(); i++) { // Magic
            String maxCandidate = list.subList(index1, index2 + 1).get(i); // Magic
            if (currentMax.length() < maxCandidate.length()) {
                currentMax = maxCandidate;
                System.out.println("Current Max: " + currentMax);

            }
        }
        return currentMax;
    }


    public ArrayList<String> sort() {
        for (int i = 1; i < list.size(); i++) {
            System.out.println("--------------------------------------------");
            System.out.println("List Size: " + (list.size() - i));
            System.out.println("Sub List: " + list.subList(0, list.size() - i));
            Collections.swap(list, list.indexOf(maxValue(0, list.size() - i)), list.size() - i);
        }
        return list;
    }


}
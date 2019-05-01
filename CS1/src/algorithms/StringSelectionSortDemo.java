package algorithms;

import java.util.ArrayList;

public class StringSelectionSortDemo {
    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("Testing");
        wordList.add("floccinaucinihilipilification");
        wordList.add("Random ");
        wordList.add("StringSS");
        wordList.add("Java");
        wordList.add("sorta");
        wordList.add("pneumonoultramicroscopicsilicovolcanoconiosis");
        wordList.add("antidisestablishmentarianism");
        wordList.add("lol");
        wordList.add("supercalifragilisticexpialidocious");



        StringSelectionSort stringSort = new StringSelectionSort(wordList);

        System.out.println("\033[1mSTRING SORTING (SELECTION SORT)\033[0m\n");

        // String List
        System.out.println("Original List Size: " + wordList.size());
        System.out.println("Unsorted List: " + stringSort.unsortedList());
        System.out.println("Max Value: " + stringSort.maxValue());

        System.out.println("\033[1mSorted List: \033[31m" + stringSort.sort());
    }

}

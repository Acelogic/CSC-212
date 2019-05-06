package algorithms.Sorting;

import java.util.ArrayList;

public class StringSelectionSortDemo {
    public static void main(String[] args) {
        ArrayList<String> wordList = generateStrings(10);

        StringSelectionSort stringSort = new StringSelectionSort(wordList);

        System.out.println("\033[1mSTRING SORTING (SELECTION SORT)\033[0m\n");

        // String List
        System.out.println("Original List Size: " + wordList.size());
        System.out.println("Unsorted List: " + stringSort.unsortedList());
        System.out.println("Max Value: " + stringSort.maxValue());
        System.out.println("\033[1mSorted List: \033[31m" + stringSort.sort());
    }

    public static ArrayList<String> generateStrings(int numberOfStrings) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 1; i <= numberOfStrings; i++) {
            String str = getAlphaNumericString((int) (Math.random() * 10)); // Generate Random String of Length Between 0-10
            strings.add(str);
        }
        return strings;
    }

    //Borrowed From GeeksForGeek :)

    // function to generate a random string of length n
    public static String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}


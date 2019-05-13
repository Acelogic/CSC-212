package ExamTwoPractice;

import java.util.ArrayList;

public class ArrayLists {
    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();

        // Arbitrary Characters just for part D
        words.add("Go lshnflfsbnfs");
        words.add("C");
        words.add("Kotlin hohogfdshgfdnvfdk");
        words.add("C#");
        words.add("Java ssfghdlsjhfc");
        words.add("Python");
        words.add("C++");


        //Part A
        System.out.println("Number Of Words in Array: " + words.size());

        //Part B
        String first = words.get(0);

        //Part C
        String last = words.get(words.size() - 1); // words.size() returns the value of the arraylist
                                                   // if you were to count starting from 1
                                                   // the words.get() functions uses indices, that's why we have to use words.size() - 1

        //Part D ( in 3 Examples)
        // For Each Loop (The Most Easiest One TBH)
        for (String element : words) {
            if (element.length() >= 7) {
                System.out.println(element);
            }
        }
        // While Loop
        int i = 0;
        while (i < words.size()) {
            if (words.get(i).length() >= 7) {
                System.out.println(words.get(i));
                i++;
            }
            else {
                i++;
            }
        }
        // For Loop
        for (int j = 0; j < words.size(); j++) {
            if (words.get(j).length() >= 7) {
                System.out.println(words.get(j));
            }
        }
    }

}

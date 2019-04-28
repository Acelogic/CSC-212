package Exam2;

import javax.lang.model.element.Element;
import java.util.ArrayList;

public class Methods {

    // Part A (Creating A LongerList)
    public static ArrayList<String> longerList(ArrayList<String> paramArrayList, String paramString1 , String paramString2 ){

        ArrayList<String> all = new ArrayList<>();

        for(String element : paramArrayList) {
            all.add(element);
        }

        all.add(paramString1);
        all.add(paramString2);
        return all;
    }

    //Part B (Swapping Two Elements of an Array
    public void swap(Element[] Array , int position1, int position2){
        Element tempPosition = Array[position1 - 1]; //Stores the contents of Array at index position1 -1
        Array[position1 - 1] = Array[position2 - 1]; //Replaces What's in the Array at index position1 -1 with position1 -1
        Array[position2 - 1] = tempPosition; // Puts what's stored in tempPosition back into Array at index position2 -1

        // 3 Steps: Store, Replace, Put Back
    }

}

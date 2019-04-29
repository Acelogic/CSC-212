package Testing;

import java.util.ArrayList;

public class Testing {

    public static void main(String[] args) {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);

        int[] testList2 = {1,2,3,4};

        for (int i = 0 ; i < testList.size(); i++) {
            System.out.println(testList.get(i));


        }
        System.out.println("List Size: " + testList.size());

        for (int i = 0 ; i < testList2.length; i++) {
            System.out.println(testList2[i]);


        }
        System.out.println("Array Size: " + testList2.length);



    }
}



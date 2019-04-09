package arraylistplay;

import java.util.ArrayList;

public class Streets {

    public static void main(String[] args) {
        ArrayList<String> streets = new ArrayList<>();

        streets.add("Iberville");
        streets.add("Decatur");
        streets.add("Toulouse");
        streets.add("Bourbon");
        streets.add("Dauphine");
        streets.add("Royal");
        streets.add("St Ann");
        streets.add("St Peter");
        streets.add("Conti");
        streets.add("Exchange");
        streets.add("Bienville");
        streets.add("Dumaine");

        System.out.println("Size of street list = " + streets.size());
        System.out.println("First street = " + streets.get(0));
        System.out.println("Last street = " + streets.get(11));
        System.out.println("Last street = " + streets.get(streets.size() - 1));

        System.out.println("\nThe initial list ...");
        for (String street : streets) {
            System.out.println(street);
        }

        String swap = streets.get(0);
        streets.set(0, streets.get(streets.size() - 1));
        streets.set(streets.size() - 1, swap);

        System.out.println("\nThe final list ...");
        for (String street : streets) {
            System.out.println(street);
        }


    }


}

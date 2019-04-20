package ExamTwoPractice;

public class StringsAndThings {

    public static void main(String[] args) {
        // Part A
        String animal1 = "elephant";
        String animal2 = "eagle";

        String first = animal1.substring(0,1);

        // Part B
        String last = animal2.substring(animal2.length() - 1);

        // Part C
        int average = (animal1.length() + animal2.length()) / 2;

        // Part D
        String animal;
        if (animal1.length() > animal2.length()) {
            animal = animal1;
        } else {
            animal = animal2;
        }

        //Part E
        int index = animal.indexOf("a");

        //Part F
        String before = animal.substring(0, index);


        //Part G
        String after = animal.substring(index +1 );


        // Demo
        System.out.println("Expected Results");
        System.out.println("Working Strings: " + "animal1 = " + animal1 + "|" + "animal2 = " + animal2);
        System.out.println("Part A: " + first);
        System.out.println("Part B: " + last);
        System.out.println("Part C: " + average);
        System.out.println("Part D: " + animal);
        System.out.println("Part E: " + index);
        System.out.println("Part F: " + before);
        System.out.println("Part G: " + after);

      }

}





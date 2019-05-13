package Testing;

import shapes.SRectangle;

import java.util.ArrayList;

public class Testing {

    public static void main(String[] args) {

//Making Regular Arrays ( You determine how big it is)
        int[] nameOfArray = new int[2]; // <-- Size of Array
        String[] nameOfStringArray = new String[2];

            //Adding Stuff to a regular array
            nameOfArray[0] = 1;
            nameOfArray[1] = 2;
            nameOfStringArray[0] = "Testing";

            //Using Stuff from array
            int firstElement =  nameOfArray[0];
            nameOfStringArray[0].substring(2);

// Making Array Lists (Expands as you add stuff automatically)
        ArrayList<Integer> nameOfTheArrayList = new ArrayList<>();
        ArrayList<String>  nameOfStringArrayList = new ArrayList<>();

        //Adding stuff to an ArrayList
        nameOfTheArrayList.add(1);
        nameOfTheArrayList.add(2);
        nameOfStringArrayList.add("Testing");

        //Using Stuff from ArrayList
        int firstElementArrayList = nameOfTheArrayList.get(0);
        nameOfStringArrayList.get(0).substring(2);

//ArrayList Example
        ArrayList<String> words = new ArrayList<>();
        words.add("Go lshnflfsbnfs");
        words.add("C");
        words.add("Kotlin hohogfdshgfdnvfdk");
        words.add("C#");
        words.add("Java ssfghdlsjhfc");
        words.add("Python");
        words.add("C++");

        System.out.println(words.size());
        words.get(0);

        words.get(words.size() -1);

        for(int i = 0; i < words.size(); i++) {
            if (words.get(i).length() >= 7) {
                System.out.println(words.get(i));
            }
        }

     // Actually Making a dog
      Dog d1 = new Dog("Bob", "Pitbull", "Black", 120);
      d1.bark();
      d1.roll();



    }

//Blue Print of a dog
    public static class Dog {
        // Instance Variables
        private String name;
        private int age;
        private String color;
        private String breed;

        //Constructors
        public Dog(String name, String breed, String color, int age) {
            // Using "this" because parameter name is the same as instance variable
            this.name = name;
            this.breed = breed;
            this.color = color;
            this.age = age;
        }

        // Another Constructor
        public Dog(String dogName, String dogBreed, String dogColor) {
            name = dogName;
            breed = dogBreed;
            color = dogColor;
        }

        public void bark(){
            System.out.println("woof");
        }

        public void roll(){
            System.out.println("woofy woof woof, I'm rolling");
        }

        public String getColor(){
            return color;
        }


        public String toString() {
            return "Name: " + name + " Breed: " + breed + " Color: " + color + " Age " + age;
        }
}


}



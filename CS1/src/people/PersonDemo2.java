package people;

public class PersonDemo2 {

    public static void main(String[] args) {
        Person[] people = new Person[6];
        people[0] = new Person( "Bob Dylan", 5, 24, 1941 );
        people[1] = new Person( "Noomi Rapace", 12, 28, 1974 );
        people[2] = new Person( "Pharrell Williams", 4, 5, 1973 );
        people[3] = new Person( "Frank Sinatra", 12, 12, 1915 );
        people[4] = new Person( "Diana Krall", 11,16,1964 );
        people[5] = new Person( "Miguel Cruz", 4,6,2000);

        System.out.println("\nThe people array ...");

        //Regular way

        /*for(int i =0; i<people.length; i++) {
            System.out.println(people[i]);
        }*/

        //Alternative way of using loop
        for(Person personElement: people) {   //For each element in array "people"
            System.out.println(personElement); // print out the elements/data (in this case objects) within the array
        }

    }
}
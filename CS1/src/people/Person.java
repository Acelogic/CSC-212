package people;

import java.util.stream.IntStream;

/*
This Program will model a person in five
properties (first name, last name, month, date, year of birth)
*/
public class Person implements PersonSpecification {
    // Instance Variables
    private String firstName;
    private String lastName;
    private int month;
    private int day;
    private int year;

    //Constructors
    public Person(String name, int month, int day, int year) {
        int spacePosition = name.indexOf( " " );
        firstName = name.substring( 0, spacePosition );
        lastName = name.substring( spacePosition + 1 );
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String toString() {
        return firstName + " " + lastName + "," + " " + "Born: " + month + "/" + day + "/" + year;
    }


    @Override
    public String firstName() {
        return firstName;
    }

    @Override
    public String lastName() {
        return lastName;
    }

    @Override
    public int month() {
        return month;
    }

    @Override
    public int day() {
        return day;
    }

    @Override
    public int year() {
        return year;
    }

    @Override
    public String initials() {
        return firstName.substring( 0, 1 ).toUpperCase() + lastName.substring( 0, 1 ).toUpperCase();
    }

    @Override
    public boolean isBoomer() {
        return year >= 1946 && year <= 1964;

    }
}



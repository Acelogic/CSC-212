/*
 * Program to make use of the Die class.
 */
package chanceapps;

import chance.Die;

public class Roller {
    public static void main(String[] args) {

        // CREATE A STANDARD DIE AND ROLL IT 5 TIMES
        createAndRollStandardDieFiveTimes();

        // CREATE A TWENTY SIDED DIE AND ROLL IT 5 TIMES
        createAndRollTwentySidedDieFiveTimes();

        // CREATE A STANDARD DIE AND ROLL IT 20 TIMES
        createAndRollStandardDie(20);

        // CREATE A STANDARD DIE AND ROLL IT 30 TIMES
        createAndRollStandardDie(30);

        // CREATE A TEN SIDED DIE AND ROLL IT 20 TIMES
        createAndRollNineSidedDie(20);

        // CREATE A NINE SIDED DIE AND ROLL IT 30 TIMES
        createAndRollNineSidedDie(30);

        // TEN TIMES, CREATE A STANDARD DIE AND ROLL IT UNTIL YOU GET A 1
        System.out.println("Ten times, roll a standard die for a 1.");
        for (int i = 1; i <= 10; i++) {
            createAndRollStandardDieFor1();
        }
        // TEN TIMES, CREATE A TWELVE SIDED DIE AND ROLL IT UNTIL YOU GET A 1
        System.out.println("Ten times, roll a twelve sided die for a 1.");
        for (int i = 1; i <= 10; i++) {
            createAndRollTwelveSidedDieFor1();
        }
    }

    private static void createAndRollStandardDieFiveTimes() {
        System.out.println("Roll a standard die 5 times ...");
        Die die = new Die();
        die.roll();
        System.out.print(die.top() + " ");
        die.roll();
        System.out.print(die.top() + " ");
        die.roll();
        System.out.print(die.top() + " ");
        die.roll();
        System.out.print(die.top() + " ");
        die.roll();
        System.out.print(die.top() + " ");
        System.out.println();
    }

    private static void createAndRollTwentySidedDieFiveTimes() {
        System.out.println("Roll a twenty sided die 5 times ...");
        Die die = new Die(20);
        die.roll();
        System.out.print(die.top() + " ");
        die.roll();
        System.out.print(die.top() + " ");
        die.roll();
        System.out.print(die.top() + " ");
        die.roll();
        System.out.print(die.top() + " ");
        die.roll();
        System.out.print(die.top() + " ");
        System.out.println();
    }

    private static void createAndRollStandardDie(int nrOfTimes) {

        System.out.println("Roll a standard die " + nrOfTimes + " times ...");
        Die lucky = new Die();
        for (int i = 1; i <= nrOfTimes; i = i + 1) {
            lucky.roll();
            System.out.print(lucky.top() + " ");
        }
        System.out.println();
    }

    private static void createAndRollNineSidedDie(int nrOfTimes) {
        System.out.println("Roll a nine sided die " + nrOfTimes + " times ...");
        int incrementer = 0;
        Die die = new Die(9);

        while (incrementer <= nrOfTimes) {
            incrementer++;
            die.roll();
            System.out.print(die.top() + " ");
        }
        System.out.println();
    }

    private static void createAndRollStandardDieFor1() {
       Die die = new Die();
       die.roll();
       System.out.print(die.top() + " ");
       while(die.top() != 1) {
       die.roll();
       System.out.print(die.top() + " ");
       }
       System.out.println();

    }

    private static void createAndRollTwelveSidedDieFor1() {
        Die die = new Die(12);
        die.roll();
        System.out.print(die.top() + " ");
        while(die.top() != 1) {
            die.roll();
            System.out.print(die.top() + " ");
        }
        System.out.println();

    }
}



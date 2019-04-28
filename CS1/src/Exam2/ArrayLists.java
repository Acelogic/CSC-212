package Exam2;
import chance.Die;

import java.util.ArrayList;

public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<Die> dice = new ArrayList<>();
        dice.add(new Die());
        dice.add(new Die());
        dice.add(new Die());
        dice.add(new Die());


        //Part A
        Die first = dice.get(0);

        //Part B
        Die last = dice.get(dice.size() - 1);

        //Part C
        ArrayList<Die> sixes = new ArrayList<>();

        //Part D
        for (Die element: dice) {
            if(element.top() == 6) {
            sixes.add(element);
            }
        }
        // OR
        for (int i = 0; i < dice.size(); i++) {
            if(dice.get(i).top() == 6) {
                sixes.add(dice.get(i));

            }
        }
    }
}

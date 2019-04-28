package Exam2.ClassDefinitionAndUse;

public class Domino {
    private int edge1;
    private int edge2;


    public Domino(int edge1, int edge2) {
        this.edge1 = edge1;
        this.edge2 = edge2;

    }

    public void display() {
        System.out.print("[");

        for (int i = 0; i < edge1; i++) {
            System.out.print("*");
        }

        System.out.print(" | ");

        for(int i = 0; i < edge2; i++) {
            System.out.print("*");
        }

        System.out.println("]");
    }

    public String toString() {
        return "[" + edge1 + " | " + edge2 + "]";
    }

    public String max() {
        if (edge1 > edge2) {
            return " " + edge1;
        } else if (edge2 > edge1) {
            return " " + edge2;
        } else {
            return " Strangely The Pips are Equal: " + edge1;
        }

    }
}
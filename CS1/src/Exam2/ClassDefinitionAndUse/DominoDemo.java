package Exam2.ClassDefinitionAndUse;

public class DominoDemo {
    public static void main(String[] args) {
        Domino dora = new Domino(2,5);
        Domino dirk = new Domino(0,4);
        System.out.println("dora =" + dora.toString());
        System.out.println("dirk =" + dirk.toString());
        System.out.println("max dots on dora =" + dora.max());
        System.out.println("max dots on dirk =" + dirk.max());
        dora.display();
        dirk.display();
    }
}

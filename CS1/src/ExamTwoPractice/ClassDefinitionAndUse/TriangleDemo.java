package ExamTwoPractice.ClassDefinitionAndUse;

public class TriangleDemo {

    public static void main(String[] args) {

    Triangle triangle = new Triangle(5, 5,6);
    Triangle triangle2 = new Triangle(5);

    System.out.println(triangle.perimeter());
    System.out.println(triangle2.perimeter());
    }


}

package ExamTwoPractice;

public class Arrays {
    public static void main(String[] args) {
        //Part A

        double[] numbers = {-1.0, -2.0, -3.0, -4.0, -5.0, 1.0, 2.0, 3.0, 4.0, 5.0};
        System.out.println(numbers.length);

        // Part B

        double first = numbers[0];

        // Part C

        double last = numbers[numbers.length - 1];

        // Part D ( in 3 Examples)
        System.out.println("PART D: ");
            // For Each Loop Example
            for (double numberElement : numbers)
                if (numberElement > 0) {
                    System.out.println("For Each Loop: " + numberElement);
                }

            // While Loop
            int i = 0;
            while(i < numbers.length) {
                if (numbers[i] > 0) {
                    System.out.println("While Loop: " + numbers[i]);
                    i++;
                }
                else{
                    // We want nothing printed here
                    // System.out.println("While Loop: Negative Number Read: " +numbers[i]);
                    i++; // But we still have to increment the number
                }
            }

            // Regular For Loop
            for(int j = 0; j < numbers.length; j++) {
                if(numbers[j] > 0) {
                    System.out.println("For Loop " + numbers[j]);
                }
            }

        }

        //



}


package ExamTwoPractice;

public class ForToWhile {

    public static void main(String[] args) {
        String[] words = {"TestWord1", "TestWord2"};

        for (int x = words.length - 1; x >= 0; x = x - 1) {
            String word = words[x];
            System.out.println(word);
        }

        // Conversion to while loop

        int x = words.length-1;
        while(x >=0) {
            String word = words[x];
            System.out.println(word);
            x = x - 1;
        }
    }
}

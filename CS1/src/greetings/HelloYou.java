package greetings;
import javax.swing.*;
/*
 * Lab 1 | By Miguel Cruz
 */
public class HelloYou {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null,"Who are you?");
        System.out.println("Hello, " + name +"!");

    }
}

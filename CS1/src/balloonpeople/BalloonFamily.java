package balloonpeople;

import painter.SPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;

public class BalloonFamily {
    private ArrayList<BalloonPerson> people;
    public BalloonFamily(int numberOfPeople) {
        this.people = new ArrayList<>(numberOfPeople);
        for (int i = 0; i < numberOfPeople; i++) {
            String name = getString("What is the Name of Family Member " + (i + 1));
            int age = getNumber("Age of Family Member " + (i + 1));
            double height = getNumberDouble("Height of Family Member " + (i + 1));
            people.add(new BalloonPerson(name, age, height));
        }
    }

    public String toString() {
        StringBuilder returnString = new StringBuilder();

        for (int i = 0; i < people.size(); i++) {
            returnString.append(people.get(i));
        }
        return returnString.toString();
    }

    public void paint(SPainter painter) {
        //Starting Position
        int startingX = 200;
        int startingY = 300;
        painter.moveTo(new Point2D.Double(startingX, startingX));
        // Padding
        int extraSpacing = 300;
        for (int i = 0; i < people.size(); i++) {
            people.get(i).paint(painter);
            painter.moveTo(new Point2D.Double(people.get(i).RightEdge() + extraSpacing, startingY));
            if (people.get(i).isAtEdge(painter)) {
                painter.wash();
                painter.moveToCenter();
                painter.setFontSize(25);
                painter.setColor(Color.red);
                painter.draw("Error: Your picture is too big, try adding less family");
                painter.mbk(30);
                painter.draw("Auto-shrink might be added soon");
            }

        }
    }

    private int getNumber(String prompt) {
        String nss = JOptionPane.showInputDialog(null, prompt + "?");
        Scanner scanner = new Scanner(nss);
        return scanner.nextInt();
    }

    private double getNumberDouble(String prompt) {
        String nss = JOptionPane.showInputDialog(null, prompt + "?");
        Scanner scanner = new Scanner(nss);
        return scanner.nextDouble();
    }

    private String getString(String prompt) {
        String nss = JOptionPane.showInputDialog(null, prompt + "?");
        Scanner scanner = new Scanner(nss);
        return scanner.next();
    }


}
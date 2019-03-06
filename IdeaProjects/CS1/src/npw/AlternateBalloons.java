/*
 * Program that paints 100 red, yellow and orange balloons in a blue sky.
 * It will feature commands.
 */
package npw;

import painter.SPainter;
import shapes.SCircle;
import shapes.SSquare;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AlternateBalloons {
    // REQUIRED INFRASTRUCTURE
    public AlternateBalloons() {
        paintTheImage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AlternateBalloons();
            }
        });
    }

    // THE PAINTER DOING ITS THING
    private void paintTheImage() {
        SPainter painter = new SPainter("Balloons", 600, 600);
        paintSky(painter); // ask IntelliJ to generate the stub
        int nrOfBalloons = 300;
        paintBalloons(painter, nrOfBalloons); // ask IntelliJ to generate the stub
    }

    private void paintSky(SPainter painter) {
        painter.setColor(Color.BLUE);
        SSquare sky = new SSquare(2000);
        painter.paint(sky);
    }

    private void paintBalloons(SPainter painter, int nrOfBalloons) {
        int i = 1;
        while (i <= nrOfBalloons) {
            paintOneBalloon(painter); // ask IntelliJ to generate the stub
            i = i + 1;
        }
    }

    private void paintOneBalloon(SPainter painter) {
        Random rgen = new Random();
        Color $C9D5FF = new Color(201,213 ,255);
        Color $E817EF = new Color(232,23 ,94);
        Color $6FFF49 = new Color(111, 255, 73);
        Color $53C6FF = new Color(83, 198,255);
        Color $FF8321 = new Color(255, 131, 33);
        Color $5500FF = new Color(85, 0,255);
        Color $FFD5FB = new Color(255,213 , 251);


        int rn = rgen.nextInt(6);
        if (rn == 0) {
            painter.setColor($FF8321);
        } else if (rn == 1) {
            painter.setColor($5500FF);
        }
        else if (rn == 2) {
            painter.setColor($C9D5FF);
        }
        else if (rn == 3) {
            painter.setColor($E817EF);
        }
        else if (rn == 4) {
            painter.setColor($6FFF49);
        }
        else if (rn == 5) {
            painter.setColor($53C6FF);
        }
        else {
            painter.setColor($FFD5FB);
        }

        painter.move();
        int balloonRadius = 30;
        SCircle balloon = new SCircle(balloonRadius);
        painter.paint(balloon);
        painter.setColor(Color.BLACK);
        painter.draw(balloon);
    }
}

// TODO: 2/20/2019  DONE
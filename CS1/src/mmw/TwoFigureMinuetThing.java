/*
 * Ten note line created by joining two JSB minuet figures.
 */
package mmw;
import composer.SComposer;
import note.SNote;
import java.util.concurrent.TimeUnit;

public class TwoFigureMinuetThing {
    public static void main(String[] args) throws InterruptedException {
        SComposer sc = new SComposer();
        SNote note = new SNote();
        sc.text();
        sc.mms_35_JSB_M10();
        sc.mms_35_JSB_M13();

        TimeUnit.SECONDS.sleep(2);
        System.out.println("Time To Recreate Using SNote");
        note.text();
        //M10
        note.play();
        note.lp(2); note.s2();note.play();
        note.rp(); note.play();
        note.rp(); note.play();
        note.rp(); note.play();
        //M13
        note.lp(); note.play();
        note.lp(); note.play();
        note.lp(); note.play();
        note.rp(); note.play();
        note.rp();
        note.x2(); note.play();

    }
}
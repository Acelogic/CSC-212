/*
 * A sequence of simple modular melodic sequences.
 * Modified By Miguel Cruz | Lab 2
 */
package mmw;
import composer.SComposer;
public class Melody {
    public static void main(String[] args) {
        SComposer c = new SComposer();
        c.text();
        c.mms5();
        c.rp(); c.mms5(); c.lp();
        c.lp(); c.mms5(); c.rp();
        c.mms5();
        c.mms7();
        c.rp(); c.mms8(); c.lp();
        c.lp(); c.mms7(); c.rp();
        c.mms8();
        c.untext();

    }
}
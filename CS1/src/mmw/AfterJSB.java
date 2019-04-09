package mmw;

import composer.SComposer;
import note.SNote;
public class AfterJSB {
    public static void main(String[] args) {
        SComposer customJSB = new SComposer();
        SNote note = new SNote();
        customJSB.text();
        note.text();
        customJSB.mms_35_JSB_M12();
        customJSB.mms_35_JSB_M13();
        customJSB.mms_35_JSB_M10();
        customJSB.mms_35_JSB_M11();
        customJSB.mms_35_JSB_M9();
        customJSB.mms_35_JSB_M10();
        customJSB.mms_35_JSB_M11();
        customJSB.mms_35_JSB_M12();
        note.x5(); note.play();
    }


}

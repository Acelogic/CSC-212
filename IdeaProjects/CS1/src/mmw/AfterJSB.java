package mmw;

import composer.SComposer;
import note.SNote;
public class AfterJSB {
    public static void main(String[] args) {
        SComposer afterJSBPlayer = new SComposer();
        SNote note = new SNote();
        afterJSBPlayer.text();
        note.text();
        afterJSBPlayer.mms_35_JSB_M12();
        afterJSBPlayer.mms_35_JSB_M13();
        afterJSBPlayer.mms_35_JSB_M10();
        afterJSBPlayer.mms_35_JSB_M11();
        afterJSBPlayer.mms_35_JSB_M9();
        afterJSBPlayer.mms_35_JSB_M10();
        afterJSBPlayer.mms_35_JSB_M11();
        afterJSBPlayer.mms_35_JSB_M12();
        note.x5(); note.play();
    }


}

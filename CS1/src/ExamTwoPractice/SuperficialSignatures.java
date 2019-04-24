package ExamTwoPractice;

import painter.SPainter;
import shapes.SCircle;

import java.awt.*;
import java.util.ArrayList;

public class SuperficialSignatures {

    private void paintConcentricDots(SPainter painter, SCircle dot, int sf, ArrayList<Color> colors) {
        int ccx = 0; // current color index
        while (dot.radius() > 0) {
            painter.setColor(colors.get(ccx));
            painter.paint(dot);
            ccx = ccx + 1;
            if (ccx == colors.size()) {
                ccx = 0;
            }

        }
    }
}

        /* Part A
        int ccx = 0;

        int ccx = $int$
                                                        */
        /* Part B
        while(dot.radius() > 0)

        while($JFramelessPainter$.radius > $int$)
                                                        */
        /* Part C
        painter.setColor(colors.get(ccx));

        $JFramelessPainter$.setColor($ArrayList$.get($int$));
                                                        */
        /* Part D
        painter.paint(dot);

        $JFramelessPainter$.paint($SCircle$);
                                                        */
        /* Part E
        dot.shrink(sf);

        $SCircle$.shrink($int$);                        */

        /* Part F

        if(ccx == colors.size()) { ccx = 0; }

        if(ccx == $ArrayList$.size()){ ccx = $int$;}    */
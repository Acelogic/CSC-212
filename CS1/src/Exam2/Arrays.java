package Exam2;

import shapes.SRectangle;

public class Arrays {
    public static void main(String[] args) {
        SRectangle[] rect = {new SRectangle(1,1),
                             new SRectangle(1,1),
                             new SRectangle(1,1)};

        //Part A
        SRectangle first = rect[0];

        //Part B
        SRectangle last = rect[rect.length -1];

        //Part C
        System.out.println(rect[1].diagonal());

        //Part D
        int i = 0;
        while( i < rect.length -1) {
            rect[i].expand(10,10);
            i = i+1;
        }














    }
}

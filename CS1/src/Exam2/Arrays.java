package Exam2;

import shapes.SRectangle;

public class Arrays {
    public static void main(String[] args) {
        SRectangle[] rects = {new SRectangle(1,1),
                             new SRectangle(1,1),
                             new SRectangle(1,1)};

        //Part A
        SRectangle first = rects[0];

        //Part B
        SRectangle last = rects[rects.length -1];

        //Part C
        System.out.println(rects[1].diagonal());

        //Part D
        int i = 0;
        while( i < rects.length) {
            rects[i].expand(10,10);
            i = i+1;
        }















    }
}

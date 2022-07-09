package com.stulsoft.pjava.basics.manipulation;

/**
 * @author Yuriy Stul
 **/
public class LongAdd {
    public static void main(String[] args) {
        Long l1 = 1L;
        Long l2 = 2L;

        l1 += l2;
        System.out.printf("l1=%d%n", l1);
    }
}

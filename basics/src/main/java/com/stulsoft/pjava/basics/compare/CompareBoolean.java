/*
 * Copyright (c) 2022 StulSoft
 */

package com.stulsoft.pjava.basics.compare;

public class CompareBoolean {
    public static void main(String[] args) {
        System.out.println("==>main");

        Boolean b1 = null;
        System.out.printf("Boolean.TRUE == %b is %b%n", b1, Boolean.TRUE == b1);
        b1 = true;
        System.out.printf("Boolean.TRUE == %b is %b%n", b1, Boolean.TRUE == b1);
        b1 = false;
        System.out.printf("Boolean.TRUE == %b is %b%n", b1, Boolean.TRUE == b1);
        b1 = Boolean.valueOf(true);
        System.out.printf("Boolean.TRUE == %b is %b%n", b1, Boolean.TRUE == b1);

        Boolean b2 = Boolean.valueOf(true);
        System.out.printf("%b == %b is %b%n", b1, b2, b1 == b2);

        Boolean bb1, bb2;
        bb1 = Boolean.valueOf("false");
        bb2 = Boolean.valueOf("false");
        System.out.printf("%b == %b is %b%n", bb1, bb2, bb1 == bb2);
    }
}

/*
 * Copyright (c) 2022 StulSoft
 */

package com.stulsoft.pjava.basics.compare;

public class CompareEnum {
    enum E1{
        good, bad
    }
    public static void main(String[] args) {
        var good = E1.good;
        var bad = E1.bad;

        System.out.printf("E1.good == good is %b %n", E1.good == good);
        System.out.printf("E1.good == null is %b %n", E1.good == null);
    }
}

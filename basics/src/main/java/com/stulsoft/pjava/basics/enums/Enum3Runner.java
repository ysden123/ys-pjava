/*
 * Copyright (c) 2020. Yuriy Stul
 */

/*
   Created by Yuriy Stul 2018
*/
package com.stulsoft.pjava.basics.enums;

/**
 * @author Yuriy Stul
 */
public class Enum3Runner {
    public static void main(String[] args) {
        Enum3 en = Enum3.Tag1;
        System.out.printf("en.name()=%s%n", en.name());

        en = Enum3.TagOneTwoThree;
        System.out.printf("en.name()=%s%n", en.name());
    }
}

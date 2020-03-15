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
public class Enum2Runner {
    public static void main(String[] args) {
        Enum2 en = Enum2.TAG_1;
        System.out.printf("en.name()=%s%n", en.name());

        en = Enum2.TAG_ONE_TWO_THREE;
        System.out.printf("en.name()=%s%n", en.name());
    }
}

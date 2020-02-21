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
public class Enum1Runner {
    public static void main(String[] args) {
        Enum1 comp1 = Enum1.Company;
        System.out.println(comp1.ordinal());
        Enum1 comp2 = Enum1.Personal;
        System.out.println(comp2.ordinal());
    }
}

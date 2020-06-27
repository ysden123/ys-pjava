/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.interfaces;

/**
 * @author Yuriy Stul
 */
public class InterfaceWithStaticMethodsUsage {
    public static void main(String[] args) {
        System.out.printf("%s%n", InterfaceWithStaticMethods.intToString(123));

        System.out.printf("%s%n", InterfaceWithStaticMethods.lowCase("ABC"));
    }
}

/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.pjava.function;

/**
 * Playing with static generic methods
 *
 * @author Yuriy Stul
 */
public class StaticGenericMethods {
    /**
     * Void function with generic parameter
     *
     * @param t   parameter
     * @param <T> parameter type
     */
    private static <T> void m1(T t) {
        System.out.println("==>m1");
        System.out.println(t);
        System.out.println("<==m1");
    }

    /**
     * Void function with generic parameter
     *
     * @param t   parameter
     * @param <T> parameter type
     */
    private static <T extends Class1> void m2(T t) {
        System.out.println("==>m1");
        System.out.println("t.getName(): " + t.getName());
        System.out.println("<==m1");
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        Integer i = 1;
        StaticGenericMethods.m1(i);

        // ERROR: StaticGenericMethods.m2(i);

        Class1 c1 = new Class1();
        StaticGenericMethods.m2(c1);

        Class2 c2 = new Class2();
        StaticGenericMethods.m2(c2);
        System.out.println("<==main");
    }
}

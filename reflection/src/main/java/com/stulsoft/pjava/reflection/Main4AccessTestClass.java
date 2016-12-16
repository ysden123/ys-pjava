/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.pjava.reflection;

import java.lang.reflect.*;

/**
 * Demonstrates access to private methods and members.
 * Created by Yuriy Stul on 11/10/2016.
 */
public class Main4AccessTestClass {

    private static void test1() {
        System.out.println("==>test1");
        AccessTestClass t = new AccessTestClass();
        try {
            Field mi = AccessTestClass.class.getDeclaredField("mi");
            mi.setAccessible(true);
            Object valueOfMi = mi.get(t);
            System.out.println(String.format("valueOfMi is instance of %s", valueOfMi.getClass().getName()));
            System.out.println(String.format("valueOfMi has value %s", valueOfMi));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("<==test1");
    }

    private static void test2() {
        System.out.println("==>test2");
        AccessTestClass t = new AccessTestClass();
        try {
            Method foo = AccessTestClass.class.getDeclaredMethod("foo");
            foo.setAccessible(true);
            foo.invoke(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("<==test2");

    }

    public static void main(String args[]) {
        System.out.println("==>main");
        test1();
        test2();
        System.out.println("<==main");
    }
}

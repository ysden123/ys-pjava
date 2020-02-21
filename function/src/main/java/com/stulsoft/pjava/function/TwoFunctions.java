/*
 * Copyright (c) 2020. Yuriy Stul
 */
package com.stulsoft.pjava.function;

import java.util.function.Function;

/**
 * Two functions for one method.
 * <p>
 * Variant with functions consists of 4 methods, including function definitions.
 * <p>
 * Variant with methods consists of 5 methods.
 *
 * @author Yuriy Stul
 */
public class TwoFunctions {
    ///////////////////////////////////////////
    // With functions
    ///////////////////////////////////////////
    /**
     * 1
     */
    private Function<String, Integer> f1 = x -> {
        System.out.println("==>f1");
        return x.length();
    };

    /**
     * 2
     */
    private Function<String, Integer> f2 = x -> {
        System.out.println("==>f2");
        return x.hashCode();
    };

    /**
     * 3
     *
     * @param f a function
     */
    private void testF(Function<String, Integer> f) {
        final String s = "12345";
        System.out.println(f.apply(s));
    }

    /**
     * 4
     */
    private void runTestForF() {
        testF(f1);
        testF(f2);
    }


    /////////////////////////////////////////////////////////////////
    // With methods
    /////////////////////////////////////////////////////////////////

    /**
     * 1
     *
     * @param x input string
     * @return length of x
     */
    private Integer m1(final String x) {
        System.out.println("==>m1");
        return x.length();
    }

    /**
     * 2
     *
     * @param x input string
     * @return hascode of x
     */
    private Integer m2(final String x) {
        System.out.println("==>m2");
        return x.hashCode();
    }

    /**
     * 3
     */
    private void testM1() {
        final String s = "12345";
        System.out.println(m1(s));
    }

    /**
     * 4
     */
    private void testM2() {
        final String s = "12345";
        System.out.println(m2(s));
    }

    /**
     * 5
     */
    private void runTestForM() {
        testM1();
        testM2();
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        TwoFunctions twoFunctions = new TwoFunctions();
        twoFunctions.runTestForF();
        twoFunctions.runTestForM();
        System.out.println("<==main");
    }

}

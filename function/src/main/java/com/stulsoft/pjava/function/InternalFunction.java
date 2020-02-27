/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.function;

import java.util.function.Function;

/**
 * Demonstrates the use internally defined function
 *
 * @author Yuriy Stul
 */
public class InternalFunction {
    /**
     * Calls a function
     *
     * @param f the function to call
     */
    private static void testF1(Function<Integer, String> f) {
        System.out.println("==>testF1");
        System.out.println(f.apply(123));
        System.out.println("<==testF1");
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        // Function declaration
        Function<Integer, String> f1;

        // Function definition
        f1 = x -> String.format("The value is %d", x);
        testF1(f1);

        // Function definition
        f1 = x -> String.format("The value is %d", x * 2);
        testF1(f1);

        // Function definition
        f1 = x -> String.format("The value is %d", x * 10);
        System.out.println(f1.apply(17));

        // Function declaration
        Function<Integer, String> f2;

        // Function definition
        f2 = x -> {
            double y = Math.pow(1.0 * x, 2.0);
            return String.format("x in power of 2.0 is %f", y);
        };
        System.out.println(f2.apply(3));

        // Function definition
        f2 = x -> {
            double y = Math.pow(1.0 * x, 3.0);
            return String.format("x in power of 3.0 is %f", y);
        };
        System.out.println(f2.apply(3));

        System.out.println("<==main");
    }
}

/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.function;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Usage apply
 *
 * @author Yuriy Stul
 */
public class ApplyFunction {

    /**
     * Returns length of string
     */
    private static final Function<String, Integer> f1 = String::length;

    /**
     * Throws exception if input string is not empty; otherwise return integer 123
     */
    private static final Function<String, Integer> f2 = x -> {
        if (x.length() > 1)
            throw new RuntimeException("Error with " + x);
        else return 123;
    };

    /**
     * Just prints input string plus "inside f3" word.
     */
    private static final Consumer<String> f3 = x -> System.out.println(x + " inside f3");

    /**
     * Just prints input string plus "inside f4" word.
     */
    private static final Consumer<String> f4 = x -> System.out.println(x + " inside f4");

    private static final Function<String, String> f5 = x -> x + " inside f5";

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        int r = ApplyFunction.f1.apply("1234567");
        System.out.println(r);

        try {
            r = ApplyFunction.f2.apply("long text");
            System.out.println(r);
        } catch (RuntimeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        f3.accept("The test!");

        // Call f3 with "Word 1" as argument, then call f4 with "Word 1" as argument
        f3.andThen(f4).accept("Word 1");

        // Call f4 with "Word 2" as argument, then call f3 with "Word 2" as argument
        f4.andThen(f3).accept("Word 2");

        String s = f5.andThen(f5).apply("Word 3");
        System.out.println(s);
    }
}

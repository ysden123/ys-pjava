/*
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */
package com.stulsoft.pjava.function;

import java.util.function.Function;

/**
 * Function factory.
 * <p>
 * Demonstrates how to return a function.
 *
 * @author Yuriy Stul
 */
public class ReturnFunction {

    /**
     * Function factory: returns a <i>function</i> according to value of <i>s</i> parameter.
     *
     * @param s specifies the function (either 'suffix' or 'prefix')
     * @return the <i>function</i> according to value of <i>s</i> parameter.
     */
    private static Function<String, String> factory(final String s) {

        // Function for 'suffix'
        Function<String, String> f1 = x -> x + "_suffix";

        // Function for 'prefix'
        Function<String, String> f2 = x -> "prefix_" + x;

        switch (s.toLowerCase()) {
            case "suffix":
                return f1;
            case "prefix":
                return f2;
            default:
                throw new IllegalArgumentException("Unsupported " + s);
        }
    }

    public static void main(String[] args) {
        String s = "123";
        System.out.println("Prefix: " + ReturnFunction.factory("prefix").apply(s));
        System.out.println("Suffix: " + ReturnFunction.factory("suffix").apply(s));
    }
}

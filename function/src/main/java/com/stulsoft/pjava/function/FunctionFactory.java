/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.function;

import java.util.function.Consumer;

/**
 * Demonstrates the usage of function as return value.
 *
 * @author Yuriy Stul
 */
public class FunctionFactory {

    public static void main(String[] args) {
        System.out.println("==>main");
        Consumer<Integer> f;

        FunctionFactory ff = new FunctionFactory();
        f = ff.getFunction(3);
        f.accept(10);

        f = ff.getFunction(30);
        f.accept(10);

        System.out.println("<==main");
    }

    /**
     * Returns a function depending on input argument
     *
     * @param i input argument
     * @return the function depending on input argument
     */
    private Consumer<Integer> getFunction(int i) {
        Consumer<Integer> f;
        if (i < 5) {
            f = x -> System.out.println("Result is " + (x * 15));
        } else {
            f = x -> System.out.println("Result is " + (x + 15));
        }

        return f;
    }
}

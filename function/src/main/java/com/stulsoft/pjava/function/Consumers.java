/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.function;

/**
 * Demonstrates usage of consumers
 *
 * @author Yuriy Stul
 */
public class Consumers {
    private final int base;

    /**
     * Initializes a new instance of the Consumers class
     *
     * @param base some int value
     */
    private Consumers(int base) {
        this.base = base;
    }

    /**
     * Consumes a string
     *
     * @param line argument
     */
    private static void c1(String line) {
        System.out.println(line);
    }

    /**
     * Consumes a string
     *
     * @param line argument
     */
    private void c2(String line) {
        System.out.printf("%s %d\n", line, base);
    }

    public static void main(String[] args) {
        System.out.println("==>main");

        // Calls static method/function
        Executor.execute(Consumers::c1);    // Same: Executor.execute(s -> Consumers.c1(s));

        Consumers cs = new Consumers(17);
        // Calls instance method/function
        Executor.execute(cs::c2);           // Same: Executor.execute(s -> cs.c2(s));

        System.out.println("<==main");
    }
}

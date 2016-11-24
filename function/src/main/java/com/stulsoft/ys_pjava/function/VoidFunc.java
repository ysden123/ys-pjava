/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.ys_pjava.function;

import java.util.Random;

/**
 * Demonstrates usage function without argument.
 * <p>
 * Created by Yuriy Stul on 11/24/2016.
 */
public class VoidFunc {
    private static void foo() {
        System.out.println("==>foo");
        f1(() -> System.out.println("In the lambda"));
        System.out.println("<==foo");
    }

    /**
     * Calls a function f without argument.
     *
     * @param f the function without argument; the function doesn't return a result (type of void)
     */
    private static void f1(Runnable f) {
        System.out.println("==>f1");
        f.run();
        System.out.println("<==f1");
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        foo();

        f1(() -> {
            int i = (new Random()).nextInt();
            System.out.printf("Random i = %d\n", i);
        });
        
        f1(() -> {
            int i = (new Random()).nextInt();
            System.out.printf("Random i = %d\n", i);
        });
        System.out.println("<==main");
    }
}

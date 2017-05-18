/*
 * Copyright (c) 2017, William Hill Online. All rights reserved
 */
package com.stulsoft.pjava.basics.optional;

import java.util.Optional;

/**
 * Playing with Optional
 *
 * @author Yuriy Stul.
 */
public class POptional2 {
    public static void main(String[] args) {
        System.out.println("start");
        testf1();
        System.out.println("finish");
    }

    private static Optional<Integer> f1(boolean tofail) {
        return tofail ? Optional.empty() : Optional.of(123);
    }

    private static void testf1() {
        System.out.println("==>testf1");
        Optional<Integer> r = f1(false);
        r.ifPresent(i -> System.out.printf("(1) Result is %d\n", i));
        boolean isPresent = r.isPresent();
        System.out.printf("(1.1) isPresent is %s\n", isPresent);


        r = f1(true);
        r.ifPresent(i -> System.out.printf("(2) Result is %d\n", i));
        isPresent = r.isPresent();
        System.out.printf("(2.1) isPresent is %s\n", isPresent);

        System.out.println("<==testf1");
    }
}

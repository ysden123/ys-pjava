/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.basics.stream;

import java.util.stream.Stream;

/**
 * Usage the <i>reduce</i>
 *
 * @author Yuriy Stul
 */
class ReduceExamples {

    /**
     * Usage of reduce with accumulator
     */
    private static void testReduce1() {
        System.out.println("==>testReduce1");
        int sum = Stream.of(1, 2, 3, 4, 5)
                .reduce((v1, v2) -> v1 + v2)
                .orElse(-1);
        System.out.println("(1) sum = " + sum);

        sum = Stream.of(1, 2, 3, 4, 5)
                .filter(v -> false)
                .reduce((v1, v2) -> v1 + v2)
                .orElse(-1);
        System.out.println("(2) sum = " + sum);
        System.out.println("<==testReduce1");
    }

    /**
     * Usage of reduce with identity and accumulator
     */
    private static void testReduce2() {
        System.out.println("==>testReduce2");
        int sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(25, // initial value
                        (v1, v2) -> v1 + v2);
        System.out.println("(1) sum = " + sum);

        sum = Stream.of(1, 2, 3, 4, 5)
                .filter(i -> false)
                .reduce(25, // initial value
                        (v1, v2) -> v1 + v2);
        System.out.println("(2) sum = " + sum);

        System.out.println("<==testReduce2");
    }

    /**
     * Usage of reduce with identity, accumulator, and combiner
     * <p>
     * Gives the same result as testReduce2. It is useful in parallel computations.
     */
    private static void testReduce3() {
        System.out.println("==>testReduce3");
        int sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(25,
                        (v1, v2) -> v1 + v2,
                        (v1, v2) -> v1 + v2);
        System.out.println("(1) sum = " + sum);

        sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(25,
                        (v1, v2) -> v1 + v2,
                        Integer::sum);
        System.out.println("(2) sum = " + sum);
        System.out.println("<==testReduce3");
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        testReduce1();
        testReduce2();
        testReduce3();
        System.out.println("<==main");
    }
}

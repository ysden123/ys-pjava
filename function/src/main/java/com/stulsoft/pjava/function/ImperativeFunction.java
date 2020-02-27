/*
 * Copyright (c) 2020. Yuriy Stul
 */
package com.stulsoft.pjava.function;

import java.util.stream.IntStream;

import org.apache.commons.lang3.time.StopWatch;

import java.util.stream.Collectors;

/**
 * Demonstrates difference between imperative and functional approach.
 *
 * @author Yuriy Stul
 */
public class ImperativeFunction {
    /**
     * Imperative
     */
    private static void imperativeTest() {
        System.out.println("==>imperativeTest");
        StopWatch watch = new StopWatch();
        watch.start();
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 9, 10};

        int sum = 0;
        for (int j = 0; j < array.length; j++) {
            for (int k = j + 1; k < array.length; k++) {
                if (k != j && array[k] == array[j]) {
                    sum = sum + array[k];
                    System.out.println("Duplicate found: " + array[k] + " " + "Sum of the duplicate value is " + sum);
                }
            }
        }
        watch.stop();
        System.out.println("Duration: " + watch.toString());
        System.out.println("<==imperativeTest");
    }

    /**
     * Functional
     */
    private static void functionalTest() {
        System.out.println("==>functionalTest");
        StopWatch watch = new StopWatch();
        watch.start();
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 9, 10};

        IntStream.of(array).boxed().collect(Collectors.groupingBy(i -> i)).entrySet().stream().filter(e -> e.getValue().size() > 1).forEach(e ->
                System.out.println("Duplicates found for : " + e.getKey() + " their sum being : " + e.getValue().stream().mapToInt(i -> i).sum())
        );
        watch.stop();
        System.out.println("Duration: " + watch.toString());
        System.out.println("<==functionalTest");
    }

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        imperativeTest();
        functionalTest();
    }
}

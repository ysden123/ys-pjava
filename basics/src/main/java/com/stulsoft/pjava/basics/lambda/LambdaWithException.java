/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pjava.basics.lambda;

import java.util.Arrays;

/**
 * @author Yuriy Stul
 */
public class LambdaWithException {
    public static void main(String[] args) {
        System.out.println("==>main");
        test1();
        test2();
    }

    private static void test1() {
        System.out.println("==>test1");

        var array = new int[]{1, 2, 3};

        try {
            Arrays.stream(array).forEach(item -> {
                if (item == 2)
                    throw new RuntimeException("It is 2");
                else
                    System.out.printf("item=%d%n", item);
            });
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void test2() {
        System.out.println("==>test1");

        var array = new int[]{1, 2, 3};

        Arrays.stream(array).forEach(item -> {
            try {
                if (item == 2)
                    throw new RuntimeException("It is 2");
                else
                    System.out.printf("item=%d%n", item);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        });
    }
}

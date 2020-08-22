/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stullsoft.pjava.java14;

/**
 * Switch Expressions
 *
 * @author Yuriy Stul
 */
public class SwitchEx01 {
    public static void main(String[] args) {
        System.out.println("==>main");
        System.out.printf("1 -> %s%n", test1(1));
        System.out.printf("2 -> %s%n", test1(2));
        System.out.printf("25 -> %s%n", test1(25));

        System.out.printf("1 -> %s%n", test11(1));
        System.out.printf("2 -> %s%n", test11(2));

        test2(1);
        test2(2);

        test3(1);
        test3(2);
        System.out.println("<==main");
    }

    private static String test1(int key) {
        System.out.println("==>test1");
        return switch (key) {
            case 1 -> "a";
            case 2 -> "b";
            default -> "none";
        };
    }

    private static String test11(int key) {
        System.out.println("==>test11");
        return switch (key) {
            case 1 -> {
                System.out.println("P 001");
                yield  "a";
            }
            case 2 -> {
                System.out.println("P 002");
                yield  "b";
            }
            default -> "none";
        };
    }

    private static void test2(int key) {
        System.out.println("==>test2");
        switch (key) {
            case 1 -> System.out.println("111");
            case 2 -> System.out.println("222");
        }
    }

    private static void test3(int key) {
        System.out.println("==>test3");
        switch (key) {
            case 1:
                System.out.println("111");
                break;
            case 2:
                System.out.println("222");
                break;
        }
    }
}

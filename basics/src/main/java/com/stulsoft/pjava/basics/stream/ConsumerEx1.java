/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.stream;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Consumer as function
 *
 * @author Yuriy Stul
 */
public class ConsumerEx1 {
    private static void test1() {
        System.out.println("==>test1");
        final int[] totalLength = new int[]{0};
        String[] arr = new String[]{"1111", "2222", "33333"};
        Consumer<String> consumer = s -> {
            System.out.println(s);
            totalLength[0] += s.length();
        };

        Arrays.stream(arr).forEach(consumer);
        System.out.printf("Total length is %d%n", totalLength[0]);
        System.out.println("<==test1");
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        test1();
        System.out.println("<==main");
    }
}

/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pjava.basics.stream;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Difference in performance between stream and iterator.
 *
 * @author Yuriy Stul
 */
public class StreamVsIterator {
    public static void main(String[] args) {
        test2(50);
        test1(50);
        test2(10000);
        test1(10000);
    }

    private static void test1(int n) {
        var list = generateList(n);
        var start = System.currentTimeMillis();
        var sum = list.stream().mapToLong(i -> i).sum();
        System.out.printf("test1, n=%d, stream took %dms. sum=%d%n",n, System.currentTimeMillis() - start, sum);
    }

    private static void test2(int n) {
        var list = generateList(n);
        var start = System.currentTimeMillis();
        var iterator = list.iterator();
        var sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        System.out.printf("test2, n=%d, iterator took %dms. sum=%d%n", n, System.currentTimeMillis() - start, sum);
    }

    private static Collection<Integer> generateList(int n) {
        Collection<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            list.add(i);
        }
        return list;
    }
}

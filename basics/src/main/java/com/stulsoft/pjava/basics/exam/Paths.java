/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pjava.basics.exam;

/**
 * @author Yuriy Stul
 */
public class Paths {
    public static void main(String[] args) {
        var start = System.currentTimeMillis();
        test(0, 0);
        test(1, 1);
        test(2, 3);
        test(20, 11);
        System.out.printf("Completed in %,d ms%n", System.currentTimeMillis() - start);
    }

    private static void test(int i, int j) {
        var p = paths(i, j);
        System.out.printf("i=%d, j=%d, path=%,d%n", i, j, p);
    }

    private static int paths(int i, int j) {
        if (i < 1 || j < 1)
            return 0;
        if (i == 1 && j == 1)
            return 1;
        return paths(i - 1, j) + paths(i, j - 1);
    }
}

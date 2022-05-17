/*
 * Copyright (c) 2022 StulSoft
 */

package com.stulsoft.pjava.basics.records;

import java.util.concurrent.TimeUnit;

public class Performance {
    private static final String TEXT = "g hg g g g j";
    private static final String TEXT2 = "fdfdfdgfdfg";

    public static void main(String[] args) {
        Performance performance = new Performance();

        int n = 100_000_000;
        for(int i =1; i <= 10; ++i) {
            performance.testInBlock(n);
            performance.testStatic(n);
        }
    }
    private void testInBlock(int n) {
        System.out.println("==>testInBlock");

        long start = System.nanoTime();
        for (int i = 1; i <= n; ++n) {
            boolean result = "example text".equals(TEXT2);
            int dif = result? 1 : 2;
        }
        long finish = System.nanoTime();
        showDuration(start, finish);
    }
    private void testStatic(int n) {
        System.out.println("==>testStatic");

        long start = System.nanoTime();
        for (int i = 1; i <= n; ++n) {
            boolean result = TEXT.equals(TEXT2);
            int dif = result? 1 : 2;
        }
        long finish = System.nanoTime();
        showDuration(start, finish);
    }

    private void showDuration(long start, long finish){
        long difInNano=finish-start;
        long difInMs = TimeUnit.NANOSECONDS.toMillis(difInNano);
        System.out.printf("Duration in nano=%d, in millis=%d%n", difInNano, difInMs);
    }
}

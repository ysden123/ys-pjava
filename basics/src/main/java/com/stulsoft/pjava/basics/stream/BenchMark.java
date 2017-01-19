/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.basics.stream;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Yuriy Stul
 */
class BenchMark {
    //    private static List<Integer> data;
    private static LinkedList<Integer> data;

    private static void generateData(long n) {
        System.out.println("==>generateData");
        Random r = new Random();
//        data = new ArrayList<>();
        data = new LinkedList<>();
        for (long i = 1; i <= n; ++i)
            data.add(r.nextInt());
        System.out.println("<==generateData");
    }

    private static void getMaxWithFor() {
        System.out.println("==>getMaxWithFor");
        int max = Integer.MIN_VALUE;
        long start = System.nanoTime();
        for (int i = 0; i < data.size(); ++i) {
            max = Integer.max(max, data.get(i));
        }
        long end = System.nanoTime();
        System.out.printf("max = %d, dDuration: %d\n", max, TimeUnit.NANOSECONDS.toMillis(end - start));
        System.out.println("<==getMaxWithFor");
    }

    private static void getMaxWith_forEach() {
        System.out.println("==>getMaxWith_forEach");
        int[] max = {Integer.MIN_VALUE};
        long start = System.nanoTime();
        data.forEach(i -> max[0] = Integer.max(max[0], i));
        long end = System.nanoTime();
        System.out.printf("max = %d, dDuration: %d\n", max[0], TimeUnit.NANOSECONDS.toMillis(end - start));
        System.out.println("<==getMaxWith_forEach");
    }

    private static void getMaxWithStream_max() {
        System.out.println("==>getMaxWithStream_max");
        long start = System.nanoTime();
        Optional<Integer> maxOpt = data.stream().max((a, b) -> {
            if (a < b) return -1;
            else if (a.equals(b)) return 0;
            else return 1;
        });
        int max = maxOpt.isPresent() ? maxOpt.get() : -1;
        long end = System.nanoTime();
        System.out.printf("max = %d, Duration: %d\n", max, TimeUnit.NANOSECONDS.toMillis(end - start));
        System.out.println("<==getMaxWithStream_max");
    }

    private static void getMaxWithStream_reduce1() {
        System.out.println("==>getMaxWithStream_reduce1");
        long start = System.nanoTime();
        int max = data.stream()
                .reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        long end = System.nanoTime();
        System.out.printf("max = %d, Duration: %d\n", max, TimeUnit.NANOSECONDS.toMillis(end - start));
        System.out.println("<==getMaxWithStream_reduce1");
    }

    private static void getMaxWithStream_reduce2() {
        System.out.println("==>getMaxWithStream_reduce2");
        long start = System.nanoTime();
        int max = data.stream()
                .reduce(Integer.MIN_VALUE, Integer::max);
        long end = System.nanoTime();
        System.out.printf("max = %d, Duration: %d\n", max, TimeUnit.NANOSECONDS.toMillis(end - start));
        System.out.println("<==getMaxWithStream_reduce2");

    }

    public static void main(String[] args) {
        System.out.println("==>main");
        generateData(100000);
        getMaxWithFor();
        getMaxWith_forEach();
        getMaxWithStream_max();
        getMaxWithStream_reduce1();
        getMaxWithStream_reduce2();
        System.out.println("<==main");
    }
}

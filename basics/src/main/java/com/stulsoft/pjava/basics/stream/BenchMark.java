/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.basics.stream;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Checking stream benchmark
 *
 * @author Yuriy Stul
 */
class BenchMark {
    private static List<Integer> listData;
    private static LinkedList<Integer> linkedLististData;

    private static void generateListData(long n) {
        Random r = new Random();
        listData = new ArrayList<>();
        for (long i = 1; i <= n; ++i)
            listData.add(r.nextInt());
    }

    private static void generateLinkedListData() {
        linkedLististData = new LinkedList<>(listData);
    }

    /**
     * Simple classic "for" loop statement
     *
     * @param data collection
     * @return [max, duration]
     */
    private static AbstractMap.SimpleEntry<Integer, Long> getMaxWithFor(List<Integer> data) {
        int max = Integer.MIN_VALUE;
        long start = System.nanoTime();
        for (int i = 0; i < data.size(); ++i) {
            max = Integer.max(max, data.get(i));
        }
        long end = System.nanoTime();
        return new AbstractMap.SimpleEntry<>(max, TimeUnit.NANOSECONDS.toMillis(end - start));
    }

    /**
     * Simple "forEach" loop statement
     *
     * @param data collection
     * @return [max, duration]
     */
    private static AbstractMap.SimpleEntry<Integer, Long> getMaxWith_forEach(List<Integer> data) {
        int[] max = {Integer.MIN_VALUE};
        long start = System.nanoTime();
        data.forEach(i -> max[0] = Integer.max(max[0], i));
        long end = System.nanoTime();
        return new AbstractMap.SimpleEntry<>(max[0], TimeUnit.NANOSECONDS.toMillis(end - start));
    }

    /**
     * Stream: max with comparator
     *
     * @param data collection
     * @return [max, duration]
     */
    private static AbstractMap.SimpleEntry<Integer, Long> getMaxWithStream_max(List<Integer> data) {
        long start = System.nanoTime();
        Optional<Integer> maxOpt = data.stream().max((a, b) -> {
            if (a < b) return -1;
            else if (a.equals(b)) return 0;
            else return 1;
        });
        int max = maxOpt.isPresent() ? maxOpt.get() : -1;
        long end = System.nanoTime();
        return new AbstractMap.SimpleEntry<>(max, TimeUnit.NANOSECONDS.toMillis(end - start));
    }

    /**
     * Stream: reduce with compare lambda expression
     *
     * @param data collection
     * @return [max, duration]
     */
    private static AbstractMap.SimpleEntry<Integer, Long> getMaxWithStream_reduce1(List<Integer> data) {
        long start = System.nanoTime();
        int max = data.stream()
                .reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        long end = System.nanoTime();
        return new AbstractMap.SimpleEntry<>(max, TimeUnit.NANOSECONDS.toMillis(end - start));
    }

    /**
     * Stream: reduce with reference om compare function (method)
     *
     * @param data collection
     * @return [max, duration]
     */
    private static AbstractMap.SimpleEntry<Integer, Long> getMaxWithStream_reduce2(List<Integer> data) {
        long start = System.nanoTime();
        int max = data.stream()
                .reduce(Integer.MIN_VALUE, Integer::max);
        long end = System.nanoTime();
        return new AbstractMap.SimpleEntry<>(max, TimeUnit.NANOSECONDS.toMillis(end - start));
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        generateListData(100000);
        generateLinkedListData();

        AbstractMap.SimpleEntry<Integer, Long> result;
        System.out.printf("Collection\tMethod\tMax\tDuration\n");

        String list = "List";
        result = getMaxWithFor(listData);
        System.out.printf("%s\tfor\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWith_forEach(listData);
        System.out.printf("%s\tforEach\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStream_max(listData);
        System.out.printf("%s\tStream max\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStream_reduce1(listData);
        System.out.printf("%s\tStream reduce1\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStream_reduce2(listData);
        System.out.printf("%s\tStream reduce2\t%d\t%d\n", list, result.getKey(), result.getValue());

        list = "LinkedList";
        result = getMaxWithFor(linkedLististData);
        System.out.printf("%s\tfor\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWith_forEach(linkedLististData);
        System.out.printf("%s\tforEach\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStream_max(linkedLististData);
        System.out.printf("%s\tStream max\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStream_reduce1(linkedLististData);
        System.out.printf("%s\tStream reduce1\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStream_reduce2(linkedLististData);
        System.out.printf("%s\tStream reduce2\t%d\t%d\n", list, result.getKey(), result.getValue());

        System.out.println("<==main");
    }
}

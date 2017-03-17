/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.basics.stream;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Checking stream benchmark
 *
 * @author Yuriy Stul
 */
class BenchMark {
    private static List<Integer> listData;
    private static LinkedList<Integer> linkedListData;

    private static void generateListData(int n) {
        Random r = new Random();
        Stream.Builder<Integer> b = Stream.builder();
        IntStream.range(0, n)
                .forEach(i -> b.accept(r.nextInt()));
        listData = b.build().collect(Collectors.toList());
    }

    private static void generateLinkedListData() {
        linkedListData = new LinkedList<>(listData);
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
     * Classic Iterator
     *
     * @param data collection
     * @return [max, duration]
     */
    private static AbstractMap.SimpleEntry<Integer, Long> getMaxWithIterator(List<Integer> data) {
        int max = Integer.MIN_VALUE;
        long start = System.nanoTime();
        Iterator<Integer> iterator = data.iterator();
        while (iterator.hasNext()) {
            max = Integer.max(max, iterator.next());
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
        Optional<Integer> maxOpt = data
                .stream()
                .max((a, b) -> {
                    if (a < b) return -1;
                    else if (a.equals(b)) return 0;
                    else return 1;
                });
        int max = maxOpt
                .isPresent() ? maxOpt.get() : -1;
        long end = System.nanoTime();
        return new AbstractMap
                .SimpleEntry<>(max, TimeUnit.NANOSECONDS.toMillis(end - start));
    }

    /**
     * Stream: max with comparator with parallel
     *
     * @param data collection
     * @return [max, duration]
     */
    private static AbstractMap.SimpleEntry<Integer, Long> getMaxWithStreamParallel_max(List<Integer> data) {
        long start = System.nanoTime();
        Optional<Integer> maxOpt = data.stream().parallel().max((a, b) -> {
            if (a < b) return -1;
            else if (a.equals(b)) return 0;
            else return 1;
        });
        int max = maxOpt.isPresent() ? maxOpt.get() : -1;
        long end = System.nanoTime();
        return new AbstractMap.SimpleEntry<>(max, TimeUnit.NANOSECONDS.toMillis(end - start));
    }

    /**
     * Stream: reduce with compare lambda expression with parallel
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
     * Stream: reduce with compare lambda expression with parallel
     *
     * @param data collection
     * @return [max, duration]
     */
    private static AbstractMap.SimpleEntry<Integer, Long> getMaxWithStreamParallel_reduce1(List<Integer> data) {
        long start = System.nanoTime();
        int max = data.stream()
                .parallel()
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

    /**
     * Stream: reduce with reference om compare function (method) with parallel
     *
     * @param data collection
     * @return [max, duration]
     */
    private static AbstractMap.SimpleEntry<Integer, Long> getMaxWithStreamParallel_reduce2(List<Integer> data) {
        long start = System.nanoTime();
        int max = data.stream()
                .parallel()
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

        result = getMaxWithIterator(listData);
        System.out.printf("%s\titerator\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWith_forEach(listData);
        System.out.printf("%s\tforEach\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStream_max(listData);
        System.out.printf("%s\tStream max\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStreamParallel_max(listData);
        System.out.printf("%s\tStream max with parallel\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStream_reduce1(listData);
        System.out.printf("%s\tStream reduce1\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStreamParallel_reduce1(listData);
        System.out.printf("%s\tStream reduce1 with parallel\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStream_reduce2(listData);
        System.out.printf("%s\tStream reduce2\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStreamParallel_reduce2(listData);
        System.out.printf("%s\tStream reduce2 with parallel\t%d\t%d\n", list, result.getKey(), result.getValue());

        list = "LinkedList";
        result = getMaxWithFor(linkedListData);
        System.out.printf("%s\tfor\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithIterator(listData);
        System.out.printf("%s\titerator\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWith_forEach(linkedListData);
        System.out.printf("%s\tforEach\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStream_max(linkedListData);
        System.out.printf("%s\tStream max\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStreamParallel_max(linkedListData);
        System.out.printf("%s\tStream max parallel\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStream_reduce1(linkedListData);
        System.out.printf("%s\tStream reduce1\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStreamParallel_reduce1(linkedListData);
        System.out.printf("%s\tStream reduce1 with parallel\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStream_reduce2(linkedListData);
        System.out.printf("%s\tStream reduce2\t%d\t%d\n", list, result.getKey(), result.getValue());

        result = getMaxWithStreamParallel_reduce2(linkedListData);
        System.out.printf("%s\tStream reduce2 with parallel\t%d\t%d\n", list, result.getKey(), result.getValue());

        System.out.println("<==main");
    }
}

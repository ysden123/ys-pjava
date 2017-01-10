/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.basics.stream;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Demonstrates construction maps of lists
 *
 * @author Yuriy Stul
 */
public class MapBuilder {
    /**
     * Builds a map of lists from two ranges
     */
    private static void buildMapOfLists1() {
        System.out.println("==>buildMapOfLists1");
        Map<Long, List<String>> map = LongStream
                .range(1, 4)
                .mapToObj(key ->
                        new SimpleEntry<>(key,
                                LongStream
                                        .range(1, 1)
                                        .mapToObj(i -> String.format("stream text %d%d", key, i))
                                        .collect(Collectors.toList()))

                ).collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
        map.entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
        System.out.println("<==buildMapOfLists1");
    }

    private static List<String> getList(long key, long n) {
        return LongStream
                .range(1, n + 1)
                .mapToObj(i -> String.format("function text %d%d", key, i))
                .collect(Collectors.toList());
    }

    /**
     * Builds a map of lists from range and a method to build list
     */
    private static void buildMapOfLists2() {
        System.out.println("==>buildMapOfLists2");
        Map<Long, List<String>> map = LongStream
                .range(1, 4)
                .mapToObj(key -> {
                    List<String> list = getList(key, key + 1);
                    return new SimpleEntry<>(key, list);
                })
                .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
        map.entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
        System.out.println("<==buildMapOfLists2");
    }

    /**
     * Builds a map of lists from two ranges, using AtomicLong
     */
    private static void buildMapOfLists3() {
        System.out.println("==>buildMapOfLists3");
        Map<Long, List<AtomicLong>> map = LongStream
                .range(1, 4)
                .mapToObj(key ->
                        new SimpleEntry<>(key,
                                LongStream
                                        .range(1, 3)
                                        .mapToObj(AtomicLong::new)
                                        .collect(Collectors.toList())
                        )
                ).collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
        map.entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
        System.out.println("<==buildMapOfLists3");
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        buildMapOfLists1();
        buildMapOfLists2();
        buildMapOfLists3();
        System.out.println("<==main");
    }
}

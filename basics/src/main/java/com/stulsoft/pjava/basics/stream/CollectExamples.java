/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.basics.stream;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Usage the collectors
 *
 * @author Yuriy Stul
 */
public class CollectExamples {
    /**
     * Usage toMap(keyMapper, valueMapper) with anonymous key- and value- mappers.
     */
    private static void toMap2() {
        System.out.println("==>toMap2");

        Map<Integer, String> map = Stream.of(1, 2, 3)
                .collect(Collectors.toMap(i -> i * 3, i -> String.format("Hello %d", i)));
        map.entrySet()
                .forEach(System.out::println);
        System.out.println("<==toMap2");
    }

    /**
     * Usage toMap(keyMapper, valueMapper) with key- and value- mappers as functions.
     */
    private static void toMap2f() {
        System.out.println("==>toMap2f");
        String someText = "Hello func";
        Function<Integer, Integer> keyMapper = i -> i * 13;
        Function<Integer, String> valueMapper = i -> String.format("%s %d", someText, i);

        Map<Integer, String> map = Stream.of(1, 2, 3)
                .collect(Collectors.toMap(keyMapper, valueMapper));
        map.entrySet()
                .forEach(System.out::println);
        System.out.println("<==toMap2f");
    }

    /**
     * Usage toMap(keyMapper, valueMapper, mergeFunction) with key-, value- mappers and merge function.
     */
    private static void toMap3() {
        System.out.println("==>toMap3");
        AtomicInteger j = new AtomicInteger(1);

        /*
        If two keys are equal, then merge function will be used to merge two value
         */
        Map<Integer, String> map = Stream.of(1, 2, 2, 3, 2, 4)
                .collect(Collectors.toMap(i -> i * 3,   // keyMapper
                        i -> String.format("A text three %d", j.getAndIncrement()),   // valueMapper
                        (n1, n2) -> n1 + " AND " + n2)  // mergeFunction
                );
        map.entrySet()
                .forEach(System.out::println);
        System.out.println("<==toMap3");
    }

    /**
     * Usage toMap(keyMapper, valueMapper, mergeFunction, mapSupplier) with key-, value- mappers, merge function,
     * and map supplier.
     */
    private static void toMap4() {
        System.out.println("==>toMap4");
        AtomicInteger j = new AtomicInteger(1);

        Map<Integer, String> map = Stream.of(1, 2, 2, 3, 2, 4)
                .collect(Collectors.toMap(i -> i * 4,   // keyMapper
                        i -> String.format("A text four %d", j.getAndIncrement()),   // valueMapper
                        (n1, n2) -> n1 + " AND " + n2,  // mergeFunction
                        TreeMap::new                    // mapSupplier
                ));
        map.entrySet()
                .forEach(System.out::println);
        System.out.println("<==toMap4");
    }

    // todo toMap4 - mapSupplier
    public static void main(String[] args) {
        System.out.println("==>main");
        toMap2();
        toMap2f();
        toMap3();
        toMap4();
        System.out.println("<==main");
    }
}

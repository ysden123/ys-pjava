/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.basics.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Usage Stream.Builder
 *
 * @author Yuriy Stul
 */
class StreamBuilder {
    /**
     * Usage accept
     */
    private static void builderAccept() {
        System.out.println("==>builderAccept");
        Stream.Builder<String> b = Stream.builder();
        b.accept("a1");
        b.accept("a2");
        b.accept("a3");
        b.accept("a4");

        Stream<String> s = b.build();
        s.forEach(System.out::println);
        System.out.println("<==builderAccept");
    }

    /**
     * Usage add
     */
    private static void builderAdd() {
        System.out.println("==>builderAdd");
        Stream.Builder<String> b = Stream.builder();
        b.add("a1")
                .add("a2")
                .add("a3")
                .add("a4");

        Stream<String> s = b.build();
        s.forEach(System.out::println);
        System.out.println("<==builderAdd");
    }

    /**
     * Create a list from stream using stream builder.
     */
    private static void buildList() {
        System.out.println("==>buildList");
        Stream.Builder<String> b = Stream.builder();
        for (int i = 1; i <= 10; ++i) {
            b.accept(String.format("a %d", i));
        }

        List<String> l = b.build().collect(Collectors.toList());
        System.out.println(l);
        System.out.println("<==buildList");

    }

    public static void main(String[] args) {
        System.out.println("==>main");
        builderAccept();
        builderAdd();
        buildList();
        System.out.println("<==main");
    }
}

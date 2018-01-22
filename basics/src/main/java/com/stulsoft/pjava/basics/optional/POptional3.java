/*
 * Copyright (c) 2018, William Hill Online. All rights reserved
 */
package com.stulsoft.pjava.basics.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Playing with Optional, Stream, map and flatMap
 *
 * @author Yuriy Stul.
 */
public class POptional3 {
    public static void main(String[] args) {
        System.out.println("==>main");
        test1();
        test2();
        System.out.println("<==main");
    }

    private static void test1() {
        System.out.println("==>test1");
        Optional<String> o1 = Optional.of("text 1");
        System.out.println("o1.map(o -> String::length): " + o1.map(String::length));
        System.out.println("o1.flatMap(o -> Optional.of(o.length())): " + o1.flatMap(o -> Optional.of(o.length())));
        System.out.println("<==test1");
    }

    private static void test2() {
        System.out.println("==>test2");
        List<Optional<String>> l = Arrays.asList(Optional.of("123"), Optional.empty(), Optional.of("123456"));
        System.out.println(l.stream().filter(Optional::isPresent).map(i -> i.get().length()).collect(Collectors.toList()));
        System.out.println(l.stream().filter(Optional::isPresent)
                .flatMap(i -> Stream.of(Integer.parseInt(i.get()), i.get().length())).collect(Collectors.toList()));
        System.out.println("<==test2");
    }
}

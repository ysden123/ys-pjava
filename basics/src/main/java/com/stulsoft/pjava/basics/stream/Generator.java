/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.basics.stream;

import java.util.Random;
import java.util.stream.Stream;

/**
 * Usage Stream generate
 *
 * @author Yuriy Stul
 */
class Generator {
    public static void main(String[] args) {
        System.out.println("==>main");
        Random r = new Random();
        Stream.generate(() -> String.format("text %d", r.nextInt()))
                .limit(10)
                .forEach(System.out::println);
        System.out.println("<==main");
    }
}

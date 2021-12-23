/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pjava.basics.records;

import java.util.Arrays;
import java.util.List;

/**
 * @author Yuriy Stul
 * @see <a href="https://dev.java/learn/using-record-to-model-immutable-data/#serialization?source=:em:nw:mt::::RC_WWMK200429P00043C0049:NSL400209605">Original code is here</a>
 */
public record State(String name, String capitalCity, List<String> cities) {
    public State {
        // List.copyOf returns an unmodifiable copy,
        // so the list assigned to `cities` can't change anymore
        cities = List.copyOf(cities);
    }

    public State(String name, String capitalCity) {
        this(name, capitalCity, List.of());
    }

    public State(String name, String capitalCity, String... cities) {
        this(name, capitalCity, List.of(cities));
    }

    public static void main(String[] args) {
        System.out.println("==>main");

        var state1 = new State("state1", "capital 1", Arrays.asList("city1", "city2"));
        System.out.printf("state1=%s%n", state1);

        var state2 = new State("state2", "capital 2");
        System.out.printf("state2=%s%n", state2);

        var state3 = new State("state3", "capital 3", "city31", "city32");
        System.out.printf("state3=%s%n", state3);

    }
}

/*
 * Copyright (c) 2022 StulSoft
 */

package com.stulsoft.pjava.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class AccessToLocalData {

    public static void main(String[] args) {
        AccessToLocalData accessToLocalData = new AccessToLocalData();
        accessToLocalData.someMethod1();
        accessToLocalData.someMethod2();
        accessToLocalData.someMethod3();
    }

    private void someMethod1() {
        System.out.printf("==>someMethod1%n");

        List<Integer> someValues = Arrays.asList(1, null, 5, 10);
        Function<Integer, Integer> f = someValues::get;

        Integer i1 = f.apply(0);
        Integer i2 = f.apply(1);
        Integer i3 = f.apply(2);

        System.out.printf("i1=%d, i2=%d, i3=%d%n", i1, i2, i3);
    }

    private void someMethod2() {
        System.out.printf("==>someMethod2%n");

        List<Integer> someValues = Arrays.asList(1, null, 5, 10);
        Function<Integer, Integer> f = i -> {
            Integer value = someValues.get(i);
            return value == null ? 0 : value;
        };

        Integer i1 = f.apply(0);
        Integer i2 = f.apply(1);
        Integer i3 = f.apply(2);

        System.out.printf("i1=%d, i2=%d, i3=%d%n", i1, i2, i3);
    }

    private void someMethod3() {
        System.out.printf("==>someMethod3%n");
        List<Integer> someValues = Arrays.asList(1, 3, 5, 10);
        System.out.printf("==>someValues: %s%n", someValues);

        Consumer<Integer> c = i -> someValues.set(i, someValues.get(i) + 100);

        for (int i = 0; i < 4; ++i){
            c.accept(i);
        }
        System.out.printf("==>someValues: %s%n", someValues);
    }
}

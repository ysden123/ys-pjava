/*
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */
package com.stulsoft.pjava.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Playing with Currying in Java.
 *
 * @author Yuriy Stul
 * @see <a href="https://gist.github.com/timyates/7674005">Curriyng: original example</a>
 */
public class Currying {
    private void currying() {
        System.out.println("==>currying");
        // Create a function that adds 2 integers
        BiFunction<Integer, Integer, Integer> adder = (a, b) -> a + b;

        // And a function that takes an integer and returns a function
        Function<Integer, Function<Integer, Integer>> currier = a -> b -> adder.apply(a, b);

        // Call apply 4 to currier (to get a function back)
        Function<Integer, Integer> curried = currier.apply(4);

        // Results
        System.out.printf("Curry : %d\n", curried.apply(3)); // ( 4 + 3 )
        System.out.printf("Curry : %d\n", curried.apply(4)); // ( 4 + 4 )
        System.out.printf("Curry : %d\n", curried.apply(5)); // ( 4 + 5 )
        System.out.println("<==currying");
    }

    private void composition() {
        System.out.println("==>composition");
        // A function that adds 3
        Function<Integer, Integer> add3 = (a) -> a + 3;

        // And a function that multiplies by 2
        Function<Integer, Integer> times2 = (a) -> a * 2;

        // Compose add with times
        Function<Integer, Integer> composedA = add3.compose(times2);

        // And compose times with add
        Function<Integer, Integer> composedB = times2.compose(add3);

        // Results
        System.out.printf("Times then add: %d\n", composedA.apply(6)); // ( 6 * 2 ) + 3
        System.out.printf("Add then times: %d\n", composedB.apply(6)); // ( 6 + 3 ) * 2
        System.out.println("<==composition");
    }

    public static void main(String[] args) {
        new Currying().currying();
        new Currying().composition();
    }
}

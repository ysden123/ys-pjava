/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.function;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Demonstrates the use internally defined function
 *
 * @author Yuriy Stul
 */
public class InternalFunction2 {

    public static void main(String[] args) {
        System.out.println("==>main");

        // Definition of function
        Consumer<Optional<String>> f1 = o -> {
            String toOutput = String.format("Result is %s", (o.isPresent() ? o.get() : "null"));
            System.out.println(toOutput);
        };

        Optional<String> result;

        result = Optional.empty();
        // Usage the function
        f1.accept(result);

        result = Optional.of("some result");
        // Usage the function
        f1.accept(result);

        System.out.println("<==main");
    }
}

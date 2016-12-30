/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.pjava.basics.optional;

import java.util.Optional;

/**
 * Playing with Optional
 *
 * @author Yuriy Stul
 */
class POptional {
    private static final boolean TO_SUCCESS = false;
    private static final boolean TO_FAIL = true;

    private static Optional<String> f1(final boolean toFail) {
        System.out.println("==>f1");
        System.out.println("<==f1");
        if (toFail) {
            return Optional.empty();
        } else {
            return Optional.of("A result");
        }
    }

    private static void showResult(Optional<String> result, boolean toFail) {
        System.out.printf("toFail is %s, result is %s\n", toFail, result);
        result.ifPresent(s -> System.out.printf("Result value is \"%s\"\n", s));
    }

    private static void showFlatMapResult(Optional<Integer> lengthOpt) {
        if (lengthOpt.isPresent()) {
            System.out.printf("flatMap: length is %d\n", lengthOpt.get());
        } else {
            System.out.println("flatMap: length is undefined");
        }
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        Optional<String> result;

        result = POptional.f1(TO_SUCCESS);
        showResult(result, TO_SUCCESS);

        result = POptional.f1(TO_FAIL);
        showResult(result, TO_FAIL);

        // Usage of filter
        result = POptional.f1(TO_SUCCESS);
        String textResult = result.filter(s -> s.contains("result")).isPresent() ? "Success" : "Filure";
        System.out.printf("filter: textResult is %s\n", textResult);

        // Usage of flatMap
        result = POptional.f1(TO_SUCCESS);
        Optional<Integer> lengthOpt = result.flatMap(s -> Optional.of(s.length()));
        showFlatMapResult(lengthOpt);

        result = POptional.f1(TO_FAIL);
        lengthOpt = result.flatMap(s -> Optional.of(s.length()));
        showFlatMapResult(lengthOpt);

        // Usage of map
        result = POptional.f1(TO_SUCCESS);
        Optional<Integer> lengthObj = result.map(s -> s.length());
        System.out.printf("map: lengthObj is %s\n", lengthObj.isPresent() ? lengthObj.get() : "null");

        result = POptional.f1(TO_FAIL);
        lengthObj = result.map(s -> s.length());
        System.out.printf("map: lengthObj is %s\n", lengthObj.isPresent() ? lengthObj.get() : "null");

        System.out.println("<==main");
    }
}

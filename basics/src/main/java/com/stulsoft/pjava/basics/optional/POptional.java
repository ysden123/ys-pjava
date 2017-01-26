/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.pjava.basics.optional;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Playing with Optional
 *
 * @author Yuriy Stul
 */
class POptional {
    private static final boolean TO_SUCCESS = false;
    private static final boolean TO_FAIL = true;

    /**
     * Some process that returns a string or empty
     *
     * @param toFail either to fail or success
     * @return string or empty
     */
    private static Optional<String> f1(final boolean toFail) {
        System.out.println("==>f1");
        System.out.println("<==f1");
        if (toFail) {
            return Optional.empty();
        } else {
            return Optional.of("A result");
        }
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        Optional<String> result;

        BiConsumer<Optional<String>, Boolean> showResult = (r, b) -> {
            System.out.printf("toFail is %s, result is %s\n", b, r);
            r.ifPresent(s -> System.out.printf("Result value is \"%s\"\n", s));
        };

        Consumer<Optional<Integer>> showFlatMapResult = lengthOpt -> {
            if (lengthOpt.isPresent()) {
                System.out.printf("flatMap: length is %d\n", lengthOpt.get());
            } else {
                System.out.println("flatMap: length is undefined");
            }
        };

        result = POptional.f1(TO_SUCCESS);
        showResult.accept(result, TO_SUCCESS);

        result = POptional.f1(TO_FAIL);
        showResult.accept(result, TO_SUCCESS);

        // Usage of filter
        result = POptional.f1(TO_SUCCESS);
        String textResult = result.filter(s -> s.contains("result")).isPresent() ? "Success" : "Failure";
        System.out.printf("filter: textResult is %s\n", textResult);

        // Usage of flatMap
        result = POptional.f1(TO_SUCCESS);
        Optional<Integer> lengthOpt = result.flatMap(s -> Optional.of(s.length()));
        showFlatMapResult.accept(lengthOpt);

        result = POptional.f1(TO_FAIL);
        lengthOpt = result.flatMap(s -> Optional.of(s.length()));
        showFlatMapResult.accept(lengthOpt);

        // Usage of map
        result = POptional.f1(TO_SUCCESS);
        Optional<Integer> lengthObj = result.map(String::length);
        System.out.printf("map: lengthObj is %s\n", lengthObj.isPresent() ? lengthObj.get() : "null");

        result = POptional.f1(TO_FAIL);
        lengthObj = result.map(String::length);
        System.out.printf("map: lengthObj is %s\n", lengthObj.isPresent() ? lengthObj.get() : "null");

        result = POptional.f1(TO_SUCCESS);
        int lA[] = {-1};
        result.ifPresent(s -> lA[0] = s.length());
        System.out.printf("ifPresent: lA[0] is %d\n", lA[0]);

        result = POptional.f1(TO_FAIL);
        lA[0] = -1;
        result.ifPresent(s -> lA[0] = s.length());
        System.out.printf("ifPresent: lA[0] is %d\n", lA[0]);

        System.out.println("<==main");
    }
}

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

    public static void main(String[] args) {
        System.out.println("==>main");
        Optional<String> result;

        result = POptional.f1(TO_SUCCESS);
        showResult(result, TO_SUCCESS);

        result = POptional.f1(TO_FAIL);
        showResult(result, TO_FAIL);

        // Using filter
        result = POptional.f1(TO_SUCCESS);
        String textResult= result.filter(s -> s.contains("result")).isPresent()? "Success": "Filure";
        System.out.printf("filter: textResult is %s\n", textResult);

        System.out.println("<==main");
    }
}

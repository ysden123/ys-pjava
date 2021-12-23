/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pjava.basics.predicates;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author Yuriy Stul
 * @see <a href="https://dev.java/learn/combining-lambda-expressions/#creating-predicates-with-factory-methods?source=:em:nw:mt::::RC_WWMK200429P00043C0049:NSL400209605">Original article</a>
 */
public class CombinedPredicates {
    static Predicate<String> predicate1 = s -> (s != null) && !s.isEmpty() && s.length() < 5;

    static Predicate<String> nonNull = Objects::nonNull;
    static Predicate<String> nonEmpty = s -> !s.isEmpty();
    static Predicate<String> shorterThan5 = s -> s.length() < 5;
    static Predicate<String> predicate2 = nonNull.and(nonEmpty).and(shorterThan5);

    private static void test(Predicate<String> predicate, String s) {
        System.out.println("==>test");
        System.out.printf("%s is match to predicate = %s%n", s, predicate.test(s));
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        String s1 = "1234";
        test(predicate1, s1);
        test(predicate2, s1);

        String s2 = "1234567";
        test(predicate1, s2);
        test(predicate2, s2);

        String s3 = null;
        test(predicate1, s3);
        test(predicate2, s3);
    }
}

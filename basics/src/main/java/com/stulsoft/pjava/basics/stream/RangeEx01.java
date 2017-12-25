/*
 * Copyright (c) 2017, William Hill Online. All rights reserved
 */
package com.stulsoft.pjava.basics.stream;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Yuriy Stul.
 */
public class RangeEx01 {
    private static int N = 100000;

    /**
     * Without parallel
     */
    private static Result test1() {
        System.out.println("==>test1");
        int result = 0;
        long start = System.nanoTime();
        OptionalInt resultOptional = IntStream.range(0, N).reduce((v1, v2) -> v1 - v2);
        if (resultOptional.isPresent()) {
            result = resultOptional.getAsInt();
        }
        long end = System.nanoTime();
        System.out.println("<==test1");
        return new Result(TimeUnit.NANOSECONDS.toMillis((end - start)), "Without parallel", result);
    }

    /**
     * With parallel
     */
    private static Result test2() {
        System.out.println("==>test2");
        int result = 0;
        System.out.println("With parallel");
        long start = System.nanoTime();
        OptionalInt resultOptional = IntStream.range(0, N).parallel().reduce((v1, v2) -> v1 - v2);
        if (resultOptional.isPresent()) {
            result = resultOptional.getAsInt();
        }
        long end = System.nanoTime();
        System.out.println("<==test2");
        return new Result(TimeUnit.NANOSECONDS.toMillis((end - start)), "With parallel", result);
    }

    /**
     * With parallel
     */
    private static Result test3() {
        System.out.println("==>test3");
        int result = 0;
        System.out.println("With parallel");
        long start = System.nanoTime();
        OptionalInt resultOptional = IntStream.range(0, N).parallel().reduce((v1, v2) -> {
//            System.out.format("v1=%d, v2=%d\n",v1,v2);
            return v1 - v2;
        });
        if (resultOptional.isPresent()) {
            result = resultOptional.getAsInt();
        }
        long end = System.nanoTime();
        System.out.println("<==test3");
        return new Result(TimeUnit.NANOSECONDS.toMillis((end - start)), "With parallel", result);
    }

    /**
     * With parallel and sum instead reduce
     */
    private static Result test4() {
        System.out.println("==>test4");
        long start = System.nanoTime();
        int result = -IntStream.range(0, N).parallel().sum();
        long end = System.nanoTime();
        System.out.println("<==test4");
        return new Result(TimeUnit.NANOSECONDS.toMillis((end - start)), "With parallel and sum instead reduce", result);
    }

    /**
     * With parallel and AtomicInteger
     */
    private static Result test5() {
        System.out.println("==>test5");
        long start = System.nanoTime();
        final AtomicInteger counter = new AtomicInteger();
        IntStream.range(0, N).parallel()
                .forEach(i -> counter.addAndGet(-i));
        long end = System.nanoTime();
        System.out.println("<==test5");
        return new Result(TimeUnit.NANOSECONDS.toMillis((end - start)), "With parallel and AtomicInteger", counter.intValue());
    }

    /**
     * Without parallel and sum instead reduce
     */
    private static Result test6() {
        System.out.println("==>test6");
        long start = System.nanoTime();
        int result = -IntStream.range(0, N).sum();
        long end = System.nanoTime();
        System.out.println("<==test6");
        return new Result(TimeUnit.NANOSECONDS.toMillis((end - start)), "Without parallel and sum instead reduce", result);
    }

    public static void main(String[] args) {
        System.out.println("==>main");

        List<Result> results = Stream.of(test1(),
                test2(),
                test3(),
                test4(),
                test5(),
                test6())
                .sorted(Comparator.comparingLong(Result::getDuration))
                .collect(Collectors.toList());

        System.out.println("\nCorrect results:");
        System.out.println("===============");
        results.stream().filter(r -> Integer.parseInt(r.getValue().toString()) != 0)
                .forEach(r -> System.out.format("%s, %s, %dms\n", r.getText(), r.getValue().toString(), r.getDuration()));

        System.out.println("\nWrong results:");
        System.out.println("==============");
        results.stream().filter(r -> Integer.parseInt(r.getValue().toString()) == 0)
                .forEach(r -> System.out.format("%s, %s, %dms\n", r.getText(), r.getValue().toString(), r.getDuration()));

        System.out.println("<==main");
    }
}

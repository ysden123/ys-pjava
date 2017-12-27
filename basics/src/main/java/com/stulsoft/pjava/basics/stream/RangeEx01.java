/*
 * Copyright (c) 2017, William Hill Online. All rights reserved
 */
package com.stulsoft.pjava.basics.stream;

import com.stulsoft.pjava.utils.BenchmarkMaster;
import com.stulsoft.pjava.utils.BenchmarkResult;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Playing with reduce for range (stream).
 * <p>
 * Using without parallel and with parallel.
 * <p>
 * Conclusion: if we want to use reduce with parallel the function in reduce should be associative.
 * For instance {@code (v1,v2)->v1 + v2} is good function (associative) and {@code (v1,v2)->v1 - v2} is bad function (non-associative)
 *
 * @author Yuriy Stul.
 */
public class RangeEx01 {
    private static int N = 100000;

    /**
     * Without parallel
     */
    private static AbstractMap.SimpleEntry<String, Integer> test1() {
        int result = 0;
        OptionalInt resultOptional = IntStream.range(0, N).reduce((v1, v2) -> v1 - v2);
        if (resultOptional.isPresent()) {
            result = resultOptional.getAsInt();
        }
        return new AbstractMap.SimpleEntry<>("Without parallel", result);
    }

    /**
     * With parallel
     */
    private static AbstractMap.SimpleEntry<String, Integer> test2() {
        int result = 0;
        OptionalInt resultOptional = IntStream.range(0, N).parallel().reduce((v1, v2) -> v1 - v2);
        if (resultOptional.isPresent()) {
            result = resultOptional.getAsInt();
        }
        return new AbstractMap.SimpleEntry<>("With parallel", result);
    }

    /**
     * With parallel and sum instead reduce
     */
    private static AbstractMap.SimpleEntry<String, Integer> test3() {
        int result = -IntStream.range(0, N).parallel().sum();
        return new AbstractMap.SimpleEntry<>("With parallel and sum instead reduce", result);
    }

    /**
     * With parallel and AtomicInteger
     */
    private static AbstractMap.SimpleEntry<String, Integer> test4() {
        final AtomicInteger counter = new AtomicInteger();
        IntStream.range(0, N).parallel()
                .forEach(i -> counter.addAndGet(-i));
        return new AbstractMap.SimpleEntry<>("With parallel and AtomicInteger", counter.intValue());
    }

    /**
     * Without parallel and sum instead reduce
     */
    private static AbstractMap.SimpleEntry<String, Integer> test5() {
        int result = -IntStream.range(0, N).sum();
        return new AbstractMap.SimpleEntry<>("Without parallel and sum instead reduce", result);
    }

    /**
     * With parallel and minus sum
     */
    private static AbstractMap.SimpleEntry<String, Integer> test6() {
        int result = 0;
        OptionalInt resultOptional = IntStream.range(0, N).parallel().reduce((v1, v2) -> v1 + v2);
        if (resultOptional.isPresent()) {
            result = -resultOptional.getAsInt();
        }
        return new AbstractMap.SimpleEntry<>("With parallel and minus sum", result);
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        Collection<BenchmarkResult> results =
                BenchmarkMaster.sortBenchmarkResultsByDurationAscending(BenchmarkMaster.execute(Arrays.asList(
                        RangeEx01::test1,
                        RangeEx01::test2,
                        RangeEx01::test3,
                        RangeEx01::test4,
                        RangeEx01::test5,
                        RangeEx01::test6), 50));

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

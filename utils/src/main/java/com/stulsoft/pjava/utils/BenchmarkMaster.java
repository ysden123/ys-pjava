/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.utils;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Yuriy Stul
 */
public final class BenchmarkMaster {
    private BenchmarkMaster() {
    }

    /**
     * Executes collection of functions and returns collection of benchmark results
     *
     * @param samples specifies collection of a functions to execute; the function returns
     *                {@code SimpleEntry<String,Object>} where key is a text description and value is a result
     * @param repeat  specifies how times to execute a sample
     * @return collection of benchmarks
     */
    public static Collection<BenchmarkResult> execute(Collection<Supplier<AbstractMap.SimpleEntry<String, ?>>> samples, int repeat) {
        if (samples == null) throw new IllegalArgumentException("samples could not be null");
        return samples.stream().map(sample -> {
            long totalDuration = 0;
            String text = null;
            Object value = null;
            for (int i = 0; i < repeat; ++i) {
                long start = System.nanoTime();
                AbstractMap.SimpleEntry<String, ?> sampleResult = sample.get();
                long end = System.nanoTime();
                totalDuration += (TimeUnit.NANOSECONDS.toMillis(end - start));
                text = sampleResult.getKey();
                value = sampleResult.getValue();
            }
            return new BenchmarkResult(totalDuration / repeat, text, value);
        }).collect(Collectors.toList());
    }

    public static Collection<BenchmarkResult> sortBenchmarkResultsByDurationAscending(Collection<BenchmarkResult> results) {
        if (results == null) throw new IllegalArgumentException("results could not be null");
        return sortBenchmarkResults(results, true);
    }

    public static Collection<BenchmarkResult> sortBenchmarkResultsByDurationDescending(Collection<BenchmarkResult> results) {
        if (results == null) throw new IllegalArgumentException("results could not be null");
        return sortBenchmarkResults(results, false);
    }

    private static Collection<BenchmarkResult> sortBenchmarkResults(Collection<BenchmarkResult> results, boolean isAscending) {
        return isAscending ? results.stream().sorted(Comparator.comparingLong(BenchmarkResult::getDuration)).collect(Collectors.toList()) :
                results.stream().sorted((r1, r2) -> Long.compare(r2.getDuration(), r1.getDuration())).collect(Collectors.toList());
    }
}

/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.utils;

import org.junit.Test;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @author Yuriy Stul
 */
public class BenchmarkMasterTest {

    private AbstractMap.SimpleEntry<String, Integer> test1() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignore) {
        }
        return new AbstractMap.SimpleEntry<>("test 1", 123);
    }

    private AbstractMap.SimpleEntry<String, Integer> test2() {
        try {
            Thread.sleep(110);
        } catch (InterruptedException ignore) {
        }
        return new AbstractMap.SimpleEntry<>("test 2", 1230);
    }

    private AbstractMap.SimpleEntry<String, Integer> test3() {
        try {
            Thread.sleep(120);
        } catch (InterruptedException ignore) {
        }
        return new AbstractMap.SimpleEntry<>("test 3", 12300);
    }

    @Test
    public void execute() {
        Collection<BenchmarkResult> results = BenchmarkMaster.execute(Arrays.asList(this::test1, this::test1), 10);
        assertNotNull(results);
        assertTrue(results.size() > 0);

        results.stream().findFirst().ifPresent(r -> {
            assertEquals("test 1", r.getText());
            assertEquals(123, r.getValue());
            long durationDif = Math.abs(r.getDuration() - 100);
            assertTrue(durationDif <= 8);   // Diff is no more than 8%
        });
    }

    @Test
    public void sortBenchmarkResultsByDurationAscending() {
        Collection<BenchmarkResult> results = BenchmarkMaster.sortBenchmarkResultsByDurationAscending(
                BenchmarkMaster.execute(Arrays.asList(this::test1, this::test2, this::test3), 10));
        assertNotNull(results);
        assertEquals(3, results.size());

        assertEquals("test 1", ((BenchmarkResult) results.toArray()[0]).getText());
        assertEquals("test 2", ((BenchmarkResult) results.toArray()[1]).getText());
        assertEquals("test 3", ((BenchmarkResult) results.toArray()[2]).getText());
    }

    @Test
    public void sortBenchmarkResultsByDurationDescending() {
        Collection<BenchmarkResult> results = BenchmarkMaster.sortBenchmarkResultsByDurationDescending(
                BenchmarkMaster.execute(Arrays.asList(this::test1, this::test2, this::test3), 10));
        assertNotNull(results);
        assertEquals(3, results.size());

        assertEquals("test 2", ((BenchmarkResult) results.toArray()[0]).getText());
        assertEquals("test 3", ((BenchmarkResult) results.toArray()[1]).getText());
        assertEquals("test 1", ((BenchmarkResult) results.toArray()[2]).getText());
    }
}
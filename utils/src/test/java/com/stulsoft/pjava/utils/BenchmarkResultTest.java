/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

/**
 * @author Yuriy Stul
 */
public class BenchmarkResultTest {
    @Test
    public void constructor() {
        BenchmarkResult br1 = new BenchmarkResult(1, "test", 123);
        assertNotNull(br1);
        BenchmarkResult br2 = new BenchmarkResult(1, "test", null);
        assertNotNull(br2);

        try {
            new BenchmarkResult(1, "", null);
            fail("empty text should be catched");
        } catch (IllegalArgumentException ignore) {
        }

        try {
            new BenchmarkResult(1, null, 123);
            fail("null as text should be catched");
        } catch (IllegalArgumentException ignore) {
        }
    }

    @Test
    public void getDuration() {
        BenchmarkResult br = new BenchmarkResult(1, "test", 123);
        assertEquals(1L, br.getDuration());
    }

    @Test
    public void getText() {
        BenchmarkResult br = new BenchmarkResult(1, "test", 123);
        assertEquals("test", br.getText());
    }

    @Test
    public void getValue() {
        BenchmarkResult br1 = new BenchmarkResult(1, "test", 123);
        assertEquals(123, br1.getValue());
        BenchmarkResult br2 = new BenchmarkResult(1, "test", Arrays.asList("1", "2", "3"));
        assertEquals(Arrays.asList("1", "2", "3"), br2.getValue());
    }

    @Test
    public void equals() {
        BenchmarkResult br1 = new BenchmarkResult(1, "test", 123);
        BenchmarkResult br2 = new BenchmarkResult(1, "test", 123);
        assertEquals(br1, br2);
    }

    @Test
    public void hashCodeTest() {
        BenchmarkResult br1 = new BenchmarkResult(1, "test", 123);
        BenchmarkResult br2 = new BenchmarkResult(1, "test", 123);
        assertEquals(br1.hashCode(), br2.hashCode());
    }

    @Test
    public void toStringTest() {
        BenchmarkResult br1 = new BenchmarkResult(1, "test", 123);
        assertEquals("test: value=123, duration=1", br1.toString());
        BenchmarkResult br2 = new BenchmarkResult(1, "test", null);
        assertEquals("test: value=null, duration=1", br2.toString());
    }
}
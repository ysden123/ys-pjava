/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Holds a bennchmark result.
 *
 * @author Yuriy Stul
 */
public class BenchmarkResult {
    private final long duration;
    private final String text;
    private final Object value;

    /**
     * Initializes a new instance of the BenchmarkResult class.
     *
     * @param duration duration in milliseconds
     * @param text     short description
     * @param value    a result value
     */
    public BenchmarkResult(final long duration, final String text, Object value) {
        if (StringUtils.isEmpty(text))
            throw new IllegalArgumentException("text could not be null or empty");
        this.duration = duration;
        this.text = text;
        this.value = value;
    }

    public long getDuration() {
        return duration;
    }

    public String getText() {
        return text;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BenchmarkResult)) return false;
        BenchmarkResult that = (BenchmarkResult) o;
        return getDuration() == that.getDuration() &&
                Objects.equals(getText(), that.getText()) &&
                Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDuration(), getText(), getValue());
    }

    @Override
    public String toString() {
        return text + ": value=" + value + ", duration=" + duration;
    }
}

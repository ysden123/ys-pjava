/*
 * Copyright (c) 2017, William Hill Online. All rights reserved
 */
package com.stulsoft.pjava.basics.stream;

/**
 * @author Yuriy Stul.
 */
public class Result{
    private final long duration;
    private final String text;
    private final Object value;

    Result(final long duration, final String text, final Object value) {
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
    public String toString() {
        return "Result{" +
                "text='" + text +
                "value='" + value.toString() +
                ", duration=" + duration + "\n" +
                "}";
    }
}

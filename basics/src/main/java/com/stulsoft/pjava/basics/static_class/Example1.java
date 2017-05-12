/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.basics.static_class;

/**
 * @author Yuriy Stul
 */
public class Example1 {
    private static Integer i1;

    static {
        i1 = 123;
    }

    public static Integer getI1() {
        return i1;
    }
}

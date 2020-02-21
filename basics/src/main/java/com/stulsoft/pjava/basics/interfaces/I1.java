/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.interfaces;

/**
 * @author Yuriy Stul.
 */
public interface I1 {
    int n = 123;
    default void foo1(){System.out.println("foo1");}
    void foo2();
}

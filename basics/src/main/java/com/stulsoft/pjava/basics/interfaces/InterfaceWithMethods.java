/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.interfaces;

/**
 * @author Yuriy Stul
 */
public interface InterfaceWithMethods {
    static int inc(int i) {
        return i + 1;
    }

    default int add(int i) {
        return i + 1;
    }

    int dec(int i);
}

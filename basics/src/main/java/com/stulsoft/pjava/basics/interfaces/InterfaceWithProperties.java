/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.interfaces;

/**
 * @author Yuriy Stul
 */
public interface InterfaceWithProperties {
    // ERROR: must be initiated int p1;
    int p2 = 123;

    int f(int i);
}

/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics;

import org.junit.Test;

/**
 * Not-right unit test.
 *
 * ForUnitTest constructor is called more than once.
 *
 * @author Yuriy Stul
 */
public class ForUnitTestTest {
    private ForUnitTest forUnitTest = new ForUnitTest();

    @Test
    public void foo_1() {
        forUnitTest.foo();
    }

    @Test
    public void foo_2() {
        forUnitTest.foo();
    }
}
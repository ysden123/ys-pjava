/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pjava.basics;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Right unit test.
 *
 * ForUnitTest constructor is called only once.
 *
 * @author Yuriy Stul
 */
public class ForUnitTest2Test {
    private static ForUnitTest forUnitTest;

    @BeforeClass
    public static void setUp() throws Exception {
        forUnitTest = new ForUnitTest();
    }

    @Test
    public void foo_1() {
        forUnitTest.foo();
    }

    @Test
    public void foo_2() {
        forUnitTest.foo();
    }
}
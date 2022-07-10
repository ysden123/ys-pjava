/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Right unit test.
 *
 * ForUnitTest constructor is called only once.
 *
 * @author Yuriy Stul
 */
public class ForUnitTest2Test {
    private static ForUnitTest forUnitTest;

    @BeforeAll
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
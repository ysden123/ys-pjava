/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yuriy Stul
 */
public class ForUnitTest {
    private static final Logger logger = LoggerFactory.getLogger(ForUnitTest.class);

    public ForUnitTest() {
        logger.info("==>ForUnitTest");
    }

    public void foo() {
        logger.info("==>foo");
    }
}

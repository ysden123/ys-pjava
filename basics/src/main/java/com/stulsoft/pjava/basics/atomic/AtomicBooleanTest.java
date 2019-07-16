/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.pjava.basics.atomic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Yuriy Stul
 */
public class AtomicBooleanTest {
    private static final Logger logger = LoggerFactory.getLogger(AtomicBooleanTest.class);

    private static void test1() {
        logger.info("==>test1");
        var ab = new AtomicBoolean(false);
        logger.info("(1)   {}", ab.compareAndSet(true, true));
        logger.info("(1.1) {}", ab.get());
        logger.info(" ");

        logger.info("(2)   {}", ab.compareAndSet(false, true));
        logger.info("(2.1) {}", ab.get());
        logger.info(" ");

        logger.info("(3)   {}", ab.compareAndSet(true, false));
        logger.info("(3.1) {}", ab.get());
        logger.info("<==test1");
    }

    public static void main(String[] args) {
        logger.info("==>main");
        test1();
        logger.info("<==main");
    }
}

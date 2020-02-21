/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

/**
 * Playing wit findFirst
 *
 * @author Yuriy Stul
 */
public class FindFirst1 {
    private static final Logger logger = LoggerFactory.getLogger(FindFirst1.class);

    public static void main(String[] args) {
        logger.info("==>main");
        f1();
        logger.info("<==main");
    }

    private static void f1() {
        logger.info("==>f1");
        var result = IntStream.rangeClosed(1, 10).filter(i -> i == 5).findFirst();
        logger.info("(1) result: {}", result);
        result.ifPresent(i -> logger.info("(2) result (int) = {}", i));
        logger.info("<==f1");
    }
}

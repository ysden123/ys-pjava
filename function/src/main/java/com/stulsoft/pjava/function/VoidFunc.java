/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Demonstrates usage function without argument.
 * <p>
 * Created by Yuriy Stul on 11/24/2016.
 */
public class VoidFunc {
    private static Logger logger = LoggerFactory.getLogger(VoidFunc.class);
    private static void foo() {
        logger.info("==>foo");
        f1(() -> logger.info("In the lambda"));
        logger.info("<==foo");
    }

    /**
     * Calls a function f without argument.
     *
     * @param f the function without argument; the function doesn't return a result (type of void)
     */
    private static void f1(Runnable f) {
        logger.info("==>f1");
        f.run();
        logger.info("<==f1");
    }

    public static void main(String[] args) {
        logger.info("==>main");
        foo();

        f1(() -> {
            int i = (new Random()).nextInt();
            logger.info("Random i = {}", i);
        });

        f1(() -> {
            int i = (new Random()).nextInt();
            logger.info("Random i = {}", i);
        });
        logger.info("<==main");
    }
}

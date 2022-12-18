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
        System.out.printf("in foo ThreadID=%d%n", Thread.currentThread().getId());
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
        System.out.printf("0 ThreadID=%d%n", Thread.currentThread().getId());
        foo();

        System.out.printf("1 ThreadID=%d%n", Thread.currentThread().getId());
        f1(() -> {
            System.out.printf("2 ThreadID=%d%n", Thread.currentThread().getId());
            int i = (new Random()).nextInt();
            logger.info("Random i = {}", i);
        });

        f1(() -> {
            System.out.printf("3 ThreadID=%d%n", Thread.currentThread().getId());
            int i = (new Random()).nextInt();
            logger.info("Random i = {}", i);
        });
        logger.info("<==main");
    }
}

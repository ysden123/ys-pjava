/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.concurrency.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * Usage acceptEither of the CompletableFuture class
 *
 * @author Yuriy Stul
 */
public class CFAcceptEither {
    private static Logger logger = LoggerFactory.getLogger(CFAcceptEither.class);

    /**
     * Most slow method
     *
     * @return a result
     */
    private static String f1() {
        logger.info("==>f1");
        try {
            Thread.sleep(500);
            logger.info("<==f1");
            return "done 1";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * This method has middle speed
     *
     * @return a result
     */
    private static String f2() {
        logger.info("==>f2");
        try {
            Thread.sleep(200);
            logger.info("<==f2");
            return "done 2";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Most fast method
     *
     * @return a result
     */
    private static String f3() {
        logger.info("==>f3");
        try {
            Thread.sleep(100);
            logger.info("<==f3");
            return "done 3";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Executes concurrently f1 and f2. f2 is faster than f1. The result will be from f2.
     */
    private static void acceptEitherExample1() {
        logger.info("==>acceptEitherExample1");
        CompletableFuture<String> r1 = CompletableFuture.supplyAsync(CFAcceptEither::f1);
        CompletableFuture<String> r2 = CompletableFuture.supplyAsync(CFAcceptEither::f2);
        r1.acceptEither(r2, s -> logger.info("Result is \"{}\"", s));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("<==acceptEitherExample1");
    }

    /**
     * Executes concurrently f3 and f2. f3 is faster than f2. The result will be from f3.
     */
    private static void acceptEitherExample2() {
        logger.info("==>acceptEitherExample2");
        CompletableFuture<String> r1 = CompletableFuture.supplyAsync(CFAcceptEither::f3);
        CompletableFuture<String> r2 = CompletableFuture.supplyAsync(CFAcceptEither::f2);
        r1.acceptEither(r2, s -> logger.info("Result is \"{}\"", s));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("<==acceptEitherExample2");
    }

    public static void main(String[] args) {
        logger.info("==>main");
        logger.info("f3 faster than f2 faster than f1");
        acceptEitherExample1();
        logger.info(" ");
        acceptEitherExample2();
        logger.info("<==main");
    }
}

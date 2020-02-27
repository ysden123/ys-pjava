/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.concurrency.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * Error handling in CompletableFuture with chain.
 *
 * @author Yuriy Stul
 */
public class ErrHandling2 {
    private static Logger logger = LoggerFactory.getLogger(ErrHandling2.class);

    /**
     * Long work with failure
     *
     * @return result
     */
    private static String doWork() {
        logger.info("==>doWork");
        try {
            Thread.sleep(500);
            throw new RuntimeException("Failed doWork");
//            return "ok";
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.info("<==doWork");
            return null;
        }
    }

    /**
     * Another long work
     *
     * @param r argument
     * @return result
     */
    private static Boolean sendNotification(final String r) {
        logger.info("==>sendNotification");
        logger.info("Value of r is {}", r);
        Boolean done;
        try {
            Thread.sleep(500);
            done = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            done = false;
        }
        logger.info("<==sendNotification");
        return done;
    }

    /**
     * Chain: a work and handle result.
     */
    private static void supplyAsyncWithThenAccept() {
        logger.info("==>supplyAsyncWithThenAccept");
        try {
            CompletableFuture.supplyAsync(ErrHandling2::doWork)
                    .thenAccept(r -> logger.info("Result is {}", r))
                    .exceptionally(t -> {
                        logger.error("Failure: {}", t.getMessage());
                        throw new RuntimeException(t.getMessage()); // Must return Void
                    });
        } catch (Exception e) {
            logger.error("Failure: {}", e.getMessage());
        }
        logger.info("<==supplyAsyncWithThenAccept");
    }

    /**
     * Chain: a work1, a work2, and handle result.
     */
    private static void supplyAsyncWithChain() {
        logger.info("==>supplyAsyncWithChain");

        CompletableFuture.supplyAsync(ErrHandling2::doWork)
                .thenApply(ErrHandling2::sendNotification)
                .thenAccept(r -> logger.info("Result is {}", r))
                .exceptionally(t -> {
                    logger.error("Failure: {}", t.getMessage());
                    throw new RuntimeException(t.getMessage()); // Must return Void
                });

        logger.info("<==supplyAsyncWithChain");
    }

    /**
     * Main entry point
     *
     * @param args arguments
     * @throws InterruptedException something went wrong
     */
    public static void main(String[] args) throws InterruptedException {
        logger.info("==>main");
        ErrHandling2.supplyAsyncWithThenAccept();
        ErrHandling2.supplyAsyncWithChain();
        Thread.sleep(5000);
        logger.info("<==main");
    }
}

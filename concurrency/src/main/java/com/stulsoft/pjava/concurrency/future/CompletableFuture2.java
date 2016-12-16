/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.pjava.concurrency.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * Playing with CompletableFuture2
 * <pre>
 * CompletableFuture
 *    supplyAsync
 *    thenApply
 *    thenAccept
 * </pre>
 * Created by Yuriy Stul on 12/14/2016.
 */
public class CompletableFuture2 {
    private static Logger logger = LoggerFactory.getLogger(CompletableFuture2.class);

    /**
     * Long work
     *
     * @return result
     */
    private static String doWork() {
        logger.info("==>doWork");
        try {
            Thread.sleep(500);
            logger.info("<==doWork");
            return "Done work";
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
        CompletableFuture.supplyAsync(CompletableFuture2::doWork)
                .thenAccept(r -> logger.info("Result is {}", r));
        logger.info("<==supplyAsyncWithThenAccept");
    }

    /**
     * Chain: a work1, a work2, and handle result.
     */
    private static void supplyAsyncWithChain() {
        logger.info("==>supplyAsyncWithChain");

        CompletableFuture.supplyAsync(CompletableFuture2::doWork)
                .thenApply(CompletableFuture2::sendNotification)
                .thenAccept(r -> logger.info("Result is {}", r));
        logger.info("<==supplyAsyncWithChain");
    }

    /**
     * Main netry point
     *
     * @param args arguments
     * @throws InterruptedException something went wrong
     */
    public static void main(String[] args) throws InterruptedException {
        logger.info("==>main");
        CompletableFuture2.supplyAsyncWithThenAccept();
        CompletableFuture2.supplyAsyncWithChain();
        Thread.sleep(5000);
        logger.info("<==main");
    }
}

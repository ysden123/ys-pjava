/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.pjava.concurrency.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * Playing with CompletableFuture.
 * <p>
 * <pre>
 *     CompletableFuture
 *      get
 *      delayed handling
 * </pre>
 * <p>
 * Created by Yuriy Stul on 12/14/2016.
 */
class CompletableFuture1 {
    private static Logger logger = LoggerFactory.getLogger(CompletableFuture1.class);

    /**
     * A long work
     *
     * @return Future with result
     */
    private static Future<String> doWork1() {
        CompletableFuture<String> future = new CompletableFuture<>();
        logger.info("==>doWork1");
        try {
            Thread.sleep(500);
            future.complete("done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("<==doWork1");
        return future;
    }

    /**
     * A long work
     *
     * @return Future with result
     */
    private static String doWork2() {
        logger.info("==>doWork2");
        String result = null;
        try {
            Thread.sleep(500);
            result = "done";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("<==doWork2");
        return result;
    }

    /**
     * Call a work asynchronously and get a result synchronously
     */
    private static void supplyAsync() {
        logger.info("==>supplyAsync");
        try {
            String result = CompletableFuture.supplyAsync(CompletableFuture1::doWork1)
                    .get(2, TimeUnit.SECONDS)
                    .get();
            logger.info("result is {}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("<==supplyAsync");
    }

    /**
     * Call a work asynchronously and get a result after a time
     */
    private static void delayedHandling() {
        logger.info("==>delayedHandling");

        logger.info("Start a work");
        CompletableFuture<String> result = CompletableFuture.supplyAsync(CompletableFuture1::doWork2);
        logger.debug("result.class is {}", result.getClass().getName());
        logger.info("Doing something...");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Getting result...");
        try {
            String value = result.get(2, TimeUnit.SECONDS);
            logger.debug("value.class is {}", value.getClass().getName());
            logger.info("result is {}", value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("<==delayedHandling");
    }

    /**
     * Maim entry point
     * @param args arguments
     * @throws InterruptedException something went wrong...
     */
    public static void main(String[] args) throws InterruptedException {
        logger.info("==>main");
        supplyAsync();
        delayedHandling();

        Thread.sleep(5000);
        logger.info("<==main");
    }
}

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
 * Future
 * <ul>
 * <li>get</li>
 * <li>callback</li>
 * </ul>
 * </p>
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
    private static CompletableFuture<String> doWork2() {
        CompletableFuture<String> future = new CompletableFuture<>();
        logger.info("==>doWork2");
        try {
            Thread.sleep(500);
            future.complete("done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("<==doWork2");
        return future;
    }

    /**
     * Call a work asynchronously and get a result
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

    private static void maxAsync(){
        logger.info("==>maxAsync");
        CompletableFuture result = CompletableFuture.supplyAsync(CompletableFuture1::doWork2);
        logger.debug("result.class is {}", result.getClass().getName());
        logger.info("Doing something...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Getting result");
        CompletableFuture<String> value = null;
        try {
            value = (CompletableFuture<String>)result.get(2, TimeUnit.SECONDS);
            logger.info("Result value is {}", value.get());
            logger.debug("value.class is {}", value.getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("<==maxAsync");
    }

    /**
     * Call a work asynchronously and get a result
     */
    private static void supplyAsyncWithCallback() {
        System.out.println("==>supplyAsyncWithCallback");
//        CompletableFuture.supplyAsync(CompletableFuture1::doWork1, )
//                .thenAccept(r -> {
//                    try {
//                        logger.info("thenAccept: result is {}", r.get());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                });
        logger.info("<==supplyAsyncWithCallback");
    }

//    private static void supplyAsyncWithCallback() {
//        System.out.println("==>supplyAsyncWithCallback");
//        CompletableFuture.supplyAsync(CompletableFuture1::doWork1)
//                .thenAccept(r -> {
//                    try {
//                        logger.info("thenAccept: result is {}", r.get());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                });
//        logger.info("<==supplyAsyncWithCallback");
//    }
//
    public static void main(String[] args) throws InterruptedException {
        logger.info("==>main");
        supplyAsync();
//        supplyAsyncWithCallback();
        maxAsync();

        Thread.sleep(5000);
        logger.info("<==main");
    }
}

/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.concurrency.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Yuriy Stul
 */
public class ThreadPoolEx4 {
    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolEx4.class);

    public static void main(String[] args) {
        logger.info("==>main");

        final Executor executor = Executors.newFixedThreadPool(2);
        final Executor executor2 = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 3; ++i) {
            var theI = i;
            executor.execute(() -> {
                try {
                    CompletableFuture.supplyAsync(
                            () -> {
                                logger.info("Start i={}", theI);
                                try {
                                    Thread.sleep(1000000);
                                } catch (Exception ex) {
                                    logger.error("(1) " + ex.getMessage());
                                }
                                logger.info("Finish i={}", theI);
                                return "Done";
                            },
                            executor2)
                            .get(2000, TimeUnit.MILLISECONDS);
                } catch (Exception ex) {
                    logger.error("(2) " + theI + " " + ex.getMessage());
                }
            });
        }
    }
}

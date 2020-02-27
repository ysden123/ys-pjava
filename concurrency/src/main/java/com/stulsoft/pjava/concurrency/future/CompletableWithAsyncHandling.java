/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.concurrency.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Demonstrates usage of CompletableFuture with handleAsync
 *
 * @author Yuriy Stul
 */
public class CompletableWithAsyncHandling {
    private static Logger logger = LoggerFactory.getLogger(CompletableWithAsyncHandling.class);

    public static void main(String[] args) {
        logger.info("==>main");

        List<CompletableFuture<CompletableFuture<Boolean>>> results = new ArrayList<>();

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            logger.info("f1 started");
            try {
                Thread.sleep(2000);
            } catch (Exception ignore) {
            }
            logger.info("f1 completed");
            return "Hello from f1";
        });

        results.add(f1.handleAsync((s, t) -> {
            if (t == null) {
                logger.info("f1's result is {}", s);
            } else {
                logger.error("f1 failed with exception: {}", t.getMessage());
            }
            return CompletableFuture.completedFuture(true);
        }));

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            logger.info("f2 started");
            try {
                Thread.sleep(1000);
            } catch (Exception ignore) {
            }
            logger.info("f2 completed");
            return "Hello from f2";
        });

        results.add(f2.handleAsync((s, t) -> {
            if (t == null) {
                logger.info("f2's result is {}", s);
            } else {
                logger.error("f2 failed with exception: {}", t.getMessage());
            }
            return CompletableFuture.completedFuture(true);
        }));

        // Wait all features
        results.forEach(f -> {
                    try {
                        f.get();
                    } catch (Exception ignore) {
                    }
                }
        );

        logger.info("<==main");
    }
}

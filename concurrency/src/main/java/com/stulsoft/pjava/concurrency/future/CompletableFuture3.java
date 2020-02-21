/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.concurrency.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author Yuriy Stul
 */
public class CompletableFuture3 {
    private static Logger logger = LoggerFactory.getLogger(CompletableFuture3.class);

    public static void main(String[] args) {
        logger.info("==>main");
        CompletableFuture3 cf3 = new CompletableFuture3();
        cf3.test1();
        cf3.test2();
        cf3.test3();
        logger.info("<==main");
    }

    private void test1() {
        logger.info("==>test1");
        try {
            CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignore) {
                }
            })
                    .get(700, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        logger.info("<==test1");
    }

    private void test2() {
        logger.info("==>test2");
        try {
            CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException ignore) {
                }
            })
                    .get(1000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        logger.info("<==test2");
    }

    private void test3() {
        logger.info("==>test3");
        try {
            CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(500);
                    throw new RuntimeException("test3 exception");
                } catch (InterruptedException ignore) {
                }
            })
                    .exceptionally(e -> {
                        logger.error(e.getMessage());
                        return null;
                    })
                    .get(1000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        logger.info("<==test3");
    }
}

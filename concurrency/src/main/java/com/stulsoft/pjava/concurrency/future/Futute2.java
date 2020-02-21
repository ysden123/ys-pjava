/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.concurrency.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Yuriy Stul
 */
public class Futute2 {
    private static Logger logger = LoggerFactory.getLogger(Futute2.class);
    private ExecutorService es = Executors.newFixedThreadPool(1);

    private void test1() {
        logger.info("==>test1");
        var future = es.submit(() -> {
            logger.info("Inside future run");
            try {
                Thread.sleep(500);
            } catch (Exception ignore) {
            }

            return "test1 finished";
        });

        try {
            var result = future.get(600, TimeUnit.MILLISECONDS);
            logger.info("Result: {}", result);
        } catch (Exception exc) {
            logger.error("Error: {}", exc.getMessage());
        }
        logger.info("<==test1");
    }

    private void closePool() {
        es.shutdown();
    }

    public static void main(String[] args) {
        logger.info("==>main");
        var f = new Futute2();
        f.test1();

        f.closePool();
        logger.info("<==main");
    }
}

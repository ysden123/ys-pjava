/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.concurrency.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author Yuriy Stul
 */
public class ThreadPoolEx3 {
    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolEx3.class);

    public static void main(String[] args) {
        logger.info("==>main");
        final Executor executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 3; ++i) {
            var theI = i;
            executor.execute(() -> {
                logger.info("Start i={}", theI);
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ignore) {
                    }
                }
            });
        }

    }
}

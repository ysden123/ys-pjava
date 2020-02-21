/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.concurrency.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * Executes Listener1 using CompletableFuture and ScheduledExecutorService
 *
 * @author Yuriy Stul
 */
public class ListenerTest3 {
    private static Logger logger = LoggerFactory.getLogger(ListenerTest3.class);

    private static void test(long timeout, long delay) {
        logger.info("==>test. timeout={}, delay={}", timeout, delay);
        Listener1 listener = new Listener1();

        CompletableFuture<?> future = CompletableFuture.runAsync(() -> {
            try {
                listener.work(timeout);
            } catch (TimeoutException e) {
                logger.error("Timeout. Message: " + e.getMessage(), e);
            }
        });

        ScheduledExecutorService es = Executors.newScheduledThreadPool(1);
                ScheduledFuture<?> scheduledFuture = es.schedule(listener::receiveMessage,
                delay, TimeUnit.MILLISECONDS);

        try {
            future.get(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        try {
            scheduledFuture.get(2, TimeUnit.SECONDS);
            es.shutdown();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        logger.info("<==test");
    }

    public static void main(String[] args) {
        logger.info("==>main");
        test(1000, 100);
        logger.info("\n");
        test(300, 700);
        logger.info("<==main");
    }
}

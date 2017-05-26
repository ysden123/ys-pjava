package com.stulsoft.pjava.concurrency.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

/**
 * Executes Listener1 using ExecutorService
 *
 * @author Yuriy Stul
 */
public class ListenerTest1 {
    private static Logger logger = LoggerFactory.getLogger(ListenerTest1.class);

    private static void test(long timeout, long delay) {
        logger.info("==>test. timeout={}, delay={}", timeout, delay);
        Listener1 listener = new Listener1();
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(() -> {
            try {
                listener.work(timeout);
            } catch (TimeoutException e) {
                logger.error("Timeout. Message: " + e.getMessage(), e);
            }
        });

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            logger.error("(2) Interrupted");
        }
        listener.receiveMessage();
        es.shutdown();
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

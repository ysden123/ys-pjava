package com.stulsoft.pjava.concurrency.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

/**
 * Simple listener
 *
 * @author Yuriy Stul
 */
public class Listener1 {
    private static Logger logger = LoggerFactory.getLogger(Listener1.class);
    private final Object syncObject = new Object();
    private volatile Status status = new Status();

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

    /**
     * Does a work
     *
     * Waits no more than 'timeout' milliseconds and checks status.
     * If status is "Completed" then everything is OK; otherwise throws TimeoutException.
     *
     * @param timeout max time to wait in milliseconds
     * @throws TimeoutException status was not set to Completed
     */
    void work(long timeout) throws TimeoutException {
        try {
            logger.info("Waiting {} milliseconds...", timeout);
            status.setStatus("Running");
            synchronized (syncObject) {
                syncObject.wait(timeout);
                if ("Running".equals(status.getStatus()))
                    throw new TimeoutException("Not completed yet...");
            }
            logger.info("Completed");
        } catch (InterruptedException e) {
            logger.error("Interrupted!");
            throw new TimeoutException("Was interrupted");
        }
    }

    /**
     * Sets the status to 'Completed' and notifies the status object.
     */
    void receiveMessage() {
        logger.info("notify()");
        synchronized (syncObject) {
            status.setStatus("Completed");
            syncObject.notify();
        }
    }
}

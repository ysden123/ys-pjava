package com.stulsoft.pjava.concurrency.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * @author Yuriy Stul
 */
public class ErrHandling4 {
    private static Logger logger = LoggerFactory.getLogger(ErrHandling4.class);

    public static void main(String[] args) {
        logger.info("==>main");
        ErrHandling4 eh = new ErrHandling4();
        logger.info("\n");
        eh.test1();

        logger.info("\n");
        eh.test2();

        logger.info("\n");
        logger.info("<==main");
    }

    private void test1() {
        logger.info("==>test1");
        CompletableFuture.supplyAsync(this::failWithCompleteExceptionally)
                .exceptionally(e -> {
                    logger.error(e.getMessage());
                    return null;
                })
                .thenApply(r -> {
                    logger.info("In thenApply. r is " + r);
                    logger.info("r.isCompletedExceptionally() is {}", r.isCompletedExceptionally());
                    return null;
                });
        sleep(1000);
        logger.info("<==test1");
    }

    private void test2() {
        logger.info("==>test2");
        CompletableFuture.supplyAsync(this::failWithException)
                .exceptionally(e -> {
                    logger.error(e.getMessage());
                    return null;
                })
                .thenApply(r -> {
                    logger.info("In thenApply. r is " + r);
                    if (r != null)
                        logger.info("r.isCompletedExceptionally() is {}", r.isCompletedExceptionally());
                    return null;
                });
        sleep(1000);
        logger.info("<==test2");
    }

    private CompletableFuture<Void> failWithCompleteExceptionally() {
        logger.info("==>failWithCompleteExceptionally");
        final CompletableFuture<Void> future = new CompletableFuture<>();
        sleep(200);
        logger.info("Complete exceptionally");
        future.completeExceptionally(new RuntimeException("test ex 1"));
        logger.info("<==failWithCompleteExceptionally");
        return future;
    }

    private CompletableFuture<Void> failWithException() {
        logger.info("==>failWithException");
        sleep(200);
        logger.info("Complete exceptionally");
        throw new RuntimeException("test ex 2");
    }

    private void sleep(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ignore) {
        }
    }
}

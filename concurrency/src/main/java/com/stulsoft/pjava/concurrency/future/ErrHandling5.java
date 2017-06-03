package com.stulsoft.pjava.concurrency.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * @author Yuriy Stul
 */
public class ErrHandling5 {
    private static Logger logger = LoggerFactory.getLogger(ErrHandling5.class);

    public static void main(String[] args) {
        logger.info("==>main");
        ErrHandling5 eh = new ErrHandling5();
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
        CompletableFuture.supplyAsync(this::success)
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

    private CompletableFuture<Void> success() {
        logger.info("==>success");
        final CompletableFuture<Void> future = new CompletableFuture<>();
        sleep(200);
        logger.info("Complete successfully");
        future.complete(null);
        logger.info("<==success");
        return future;
    }

    private void sleep(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ignore) {
        }
    }
}

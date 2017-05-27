package com.stulsoft.pjava.concurrency.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Error handling in CompletableFuture with chain.
 *
 * @author Yuriy Stul
 */
public class ErrHandling3 {
    private final static boolean THROW_EXCEPTION = true;
    private final static boolean DO_NOT_THROW_EXCEPTION = false;
    private static Logger logger = LoggerFactory.getLogger(ErrHandling3.class);

    public static void main(String[] args) {
        logger.info("==>main");
        ErrHandling3 eh = new ErrHandling3();
        eh.test1(THROW_EXCEPTION);

        logger.info("\n");
        eh.test1(DO_NOT_THROW_EXCEPTION);
        logger.info("<==main");
    }

    private void work1(boolean throwException) {
        logger.info("==>work1");
        try {
            Thread.sleep(300);
            if (throwException)
                throw new RuntimeException("Error in work1");
            logger.info("Completed work1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("<==work1");
    }

    private void test1(boolean throwException) {
        logger.info("==>test1 with throwException {}", throwException);
        try {
            CompletableFuture.runAsync(() -> work1(throwException))
                    .exceptionally((e) -> {
                        logger.error("(1) Error: " + e.getMessage());
                        return null;
                    })
                    .get(1, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error("(2) Error: " + e.getMessage());
        }
        logger.info("<==test1");
    }
}

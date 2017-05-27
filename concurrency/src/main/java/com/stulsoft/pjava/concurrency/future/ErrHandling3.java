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

        logger.info("\n");
        eh.test2(DO_NOT_THROW_EXCEPTION, DO_NOT_THROW_EXCEPTION);

        logger.info("\n");
        eh.test2(THROW_EXCEPTION, DO_NOT_THROW_EXCEPTION);

        logger.info("\n");
        eh.test2(THROW_EXCEPTION, THROW_EXCEPTION);

        logger.info("\n");
        eh.test3(THROW_EXCEPTION, THROW_EXCEPTION);
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

    private void work2(boolean throwException) {
        logger.info("==>work2");
        try {
            Thread.sleep(300);
            if (throwException)
                throw new RuntimeException("Error in work2");
            logger.info("Completed work2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("<==work2");
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

    /**
     * Doesn't catch exception in work2
     */
    private void test2(boolean throwException1, boolean throwException2) {
        logger.info("==>test2 with throwException1 {} and throwException2 {} ", throwException1, throwException2);
        try {
            CompletableFuture.runAsync(() -> work1(throwException1))
                    .exceptionally((e) -> {
                        logger.error("(1) Error: " + e.getMessage());
                        return null;
                    })
                    .thenRunAsync(() -> work2(throwException2))
                    .get(1, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error("(2) Error: " + e.getMessage());
        }
        logger.info("<==test2");
    }

    private void test3(boolean throwException1, boolean throwException2) {
        logger.info("==>test3 with throwException1 {} and throwException2 {} ", throwException1, throwException2);
        try {
            CompletableFuture.runAsync(() -> work1(throwException1))
                    .exceptionally((e) -> {
                        logger.error("(1) Error: " + e.getMessage());
                        return null;
                    })
                    .thenRunAsync(() -> work2(throwException2))
                    .exceptionally((e) -> {
                        logger.error("(2) Error: " + e.getMessage());
                        return null;
                    })
                    .get(1, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error("(3) Error: " + e.getMessage());
        }
        logger.info("<==test3");
    }
}

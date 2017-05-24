/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.concurrency.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author Yuriy Stul
 */
public class CompletableChain1 {
    private static Logger logger = LoggerFactory.getLogger(CompletableChain1.class);

    private CompletableFuture<Boolean> job1(boolean isToFail, int duration) {
        logger.info("==>job1");
        CompletableFuture<Boolean> future = new CompletableFuture<>();

        try {
            Thread.sleep(duration);
            if (isToFail)
                future.complete(false);
            else
                future.complete(true);
            logger.info("completed job1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("<==job1");
        return future;
    }

    private CompletableFuture<Boolean> job2(boolean isToFail, int duration) {
        logger.info("==>job2");

        CompletableFuture<Boolean> future = new CompletableFuture<>();

        try {
            Thread.sleep(duration);
            if (isToFail)
                future.complete(false);
            else
                future.complete(true);
            logger.info("completed job2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("<==job2");
        return future;
    }

    private void test1() {
        logger.info("==>test1");
        Boolean isToFail1;
        Boolean isToFail2;

        isToFail1 = false;
        isToFail2 = false;
        logger.info("Running with isToFail1: {}, isToFail2: {}", isToFail1, isToFail2);
        logger.info("Result: {}", jobExecutor1(isToFail1, isToFail2));
        logger.info("\n");

        isToFail1 = true;
        isToFail2 = false;
        logger.info("Running with isToFail1: {}, isToFail2: {}", isToFail1, isToFail2);
        logger.info("Result: {}", jobExecutor1(isToFail1, isToFail2));
        logger.info("\n");

        isToFail1 = false;
        isToFail2 = true;
        logger.info("Running with isToFail1: {}, isToFail2: {}", isToFail1, isToFail2);
        logger.info("Result: {}", jobExecutor1(isToFail1, isToFail2));
        logger.info("\n");

        isToFail1 = true;
        isToFail2 = true;
        logger.info("Running with isToFail1: {}, isToFail2: {}", isToFail1, isToFail2);
        logger.info("Result: {}", jobExecutor1(isToFail1, isToFail2));
        logger.info("<==test1");
    }

    private void test2() {
        logger.info("==>test2");
        int duration1;
        int duration2;

        duration1 = 2700;
        duration2=500;
        logger.info("Running with duration1: {}, duration2: {}", duration1, duration2);
        logger.info("Result: {}", jobExecutor2(duration1,duration2));
        logger.info("\n");

        duration1 = 500;
        duration2=2700;
        logger.info("Running with duration1: {}, duration2: {}", duration1, duration2);
        logger.info("Result: {}", jobExecutor2(duration1,duration2));
        logger.info("\n");

        logger.info("<==test2");
    }

    private Boolean jobExecutor1(boolean isToFail1, boolean isToFail2) {
        Boolean result;
        try {
            result = CompletableFuture.supplyAsync(() -> job1(isToFail1,500))
                    .thenApplyAsync((r) -> {
                                try {
                                    Boolean r1 = r.get();
                                    if (r1)
                                        return job2(isToFail2,500);
                                    else
                                        return CompletableFuture.completedFuture(false);
                                } catch (Exception e) {
                                    logger.error("(1) Failure", e);
                                    return CompletableFuture.completedFuture(false);
                                }
                            }
                    )
                    .get(2, TimeUnit.SECONDS)
                    .get();
            logger.info("result is {}", result);
        } catch (Exception e) {
            logger.error("(2) Failure", e);
            result = false;
        }

        return result;
    }

    private Boolean jobExecutor2(int duration1,int duration2) {
        Boolean result;
        try {
            result = CompletableFuture.supplyAsync(() -> job1(false,duration1))
                    .thenApplyAsync((r) -> {
                                try {
                                    Boolean r1 = r.get();
                                    if (r1)
                                        return job2(false,duration2);
                                    else
                                        return CompletableFuture.completedFuture(false);
                                } catch (Exception e) {
                                    logger.error("(1) Failure", e);
                                    return CompletableFuture.completedFuture(false);
                                }
                            }
                    )
                    .get(2, TimeUnit.SECONDS)
                    .get();
            logger.info("result is {}", result);
        } catch (Exception e) {
            logger.error("(2) Failure", e);
            result = false;
        }

        return result;
    }

    public static void main(String[] args) {
        logger.info("==>main");
        CompletableChain1 cc1 = new CompletableChain1();
        cc1.test1();
        cc1.test2();
        logger.info("<==main");
    }
}

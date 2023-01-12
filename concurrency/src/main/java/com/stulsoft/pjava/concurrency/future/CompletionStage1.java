package com.stulsoft.pjava.concurrency.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.concurrent.*;

public class CompletionStage1 {
    private static Logger logger = LoggerFactory.getLogger(CompletionStage1.class);

    private static void test1(){
        logger.info("==>test1");
        CompletionStage<Void> cf = CompletableFuture.runAsync(() -> performTask("first stage"));
        cf = cf.thenRun(() -> performTask("second stage"));
        ((CompletableFuture)cf).join(); // waits until task is completed
        logger.info("<==test1");

    }

    private static void test2(){
        logger.info("==>test2");
        ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletableFuture.runAsync(() -> performTask("first stage"), executor)
                .thenRun(() -> performTask("second stage"))
                .thenRunAsync(() -> performTask("third stage"), executor)
                .join();//waits until task is completed
        System.out.println("main exiting");
        executor.shutdown();
        logger.info("<==test2");
    }

    private static void performTask(String stage) {
        logger.info("==>performTask");
        logger.info("stage: {}, time before task: {}, thread: {}",
                stage, LocalTime.now(), Thread.currentThread().getName());
        try {
            // simulating long work
            Thread.sleep((1_000));
        } catch (Exception ignore) {
        }
        logger.info("stage: {}, time after task: {}, thread: {}",
                stage, LocalTime.now(), Thread.currentThread().getName());
    }

    private static CompletionStage<Integer> provideInt(){
        var cf = CompletableFuture.supplyAsync(() -> ThreadLocalRandom.current().nextInt(1, 10));
        return cf;
    }

    private static void test3(){
        logger.info("==>test3");
        provideInt().handle((i, err) ->{
           logger.info("(1) i = {}", i);
           logger.info("(1) err = {}", err);
           return null;
        });

        provideInt().whenComplete((i, err) ->{
            logger.info("(2) i = {}", i);
            logger.info("(2) err = {}", err);
        });

        logger.info("<==test3");
    }
    public static void main(String[] args) {
        logger.info("==>main");

        test1();
        test2();
        test3();

        logger.info("main exiting");
    }
}

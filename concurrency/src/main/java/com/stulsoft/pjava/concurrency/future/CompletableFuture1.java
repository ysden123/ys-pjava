/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.pjava.concurrency.future;

import java.util.concurrent.*;

/**
 * Playing with CompletableFuture
 * <p>
 * Created by Yuriy Stul on 12/14/2016.
 */
class CompletableFuture1 {
    private static Future<String> doWork() {
        CompletableFuture<String> future = new CompletableFuture<>();

        System.out.println("==>doWork");
        try {
            Thread.sleep(500);
            future.complete("done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("<==doWork");
        return future;
    }

    private static void supplyAsync1() {
        System.out.println("==>supplyAsync1");
        try {
            String result = CompletableFuture.supplyAsync(CompletableFuture1::doWork)
                    .get(2, TimeUnit.SECONDS)
                    .get();
            System.out.printf("result is %s\n", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("<==supplyAsync1");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("==>main");
        supplyAsync1();

        Thread.sleep(5000);
        System.out.println("<==main");
    }
}

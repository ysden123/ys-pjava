/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.pjava.concurrency.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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

    private static void supplyAsync() {
        System.out.println("==>supplyAsync");
        try {
            String result = CompletableFuture.supplyAsync(CompletableFuture1::doWork)
                    .get(2, TimeUnit.SECONDS)
                    .get();
            System.out.printf("result is %s\n", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("<==supplyAsync");
    }

    private static void supplyAsyncWithCallback() {
        System.out.println("==>supplyAsyncWithCallback");
        CompletableFuture.runAsync(CompletableFuture1::doWork)
                .thenAccept((Void) -> System.out.println("Done supplyAsyncWithCallback"));
        System.out.println("<==supplyAsyncWithCallback");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("==>main");
        supplyAsync();
        supplyAsyncWithCallback();

        Thread.sleep(5000);
        System.out.println("<==main");
    }
}

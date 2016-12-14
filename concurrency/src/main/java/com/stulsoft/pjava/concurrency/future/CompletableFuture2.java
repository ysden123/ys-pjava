/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.pjava.concurrency.future;

import java.util.concurrent.CompletableFuture;

/**
 * Playing with CompletableFuture2
 * <p>
 * Created by Yuriy Stul on 12/14/2016.
 */
public class CompletableFuture2 {
    private static String doWork() {
        System.out.println("==>doWork");
        try {
            Thread.sleep(500);
            System.out.println("<==doWork");
            return "Done work";
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("<==doWork");
            return null;
        }
    }

    private static Boolean sendNotification(final String r) {
        System.out.println("==>sendNotification");
        System.out.println("Value of r is " + r);
        Boolean done;
        try {
            Thread.sleep(500);
            done = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            done = false;
        }
        System.out.println("<==sendNotification");
        return done;
    }

    private static void supplyAsyncWithThenAccept() {
        System.out.println("==>supplyAsyncWithThenAccept");
        CompletableFuture.supplyAsync(CompletableFuture2::doWork)
                .thenAccept(r -> System.out.println("Result is " + r));
        System.out.println("<==supplyAsyncWithThenAccept");
    }

    private static void supplyAsyncWithChain() {
        System.out.println("==>supplyAsyncWithChain");

        CompletableFuture.supplyAsync(CompletableFuture2::doWork)
                .thenApply(CompletableFuture2::sendNotification)
                .thenAccept(r -> System.out.println("Result is " + r));
        System.out.println("<==supplyAsyncWithChain");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("==>main");
        CompletableFuture2.supplyAsyncWithThenAccept();
        CompletableFuture2.supplyAsyncWithChain();
        Thread.sleep(5000);
        System.out.println("<==main");
    }
}

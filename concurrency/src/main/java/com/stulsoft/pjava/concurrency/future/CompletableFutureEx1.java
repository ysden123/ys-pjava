/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.pjava.concurrency.future;

import java.util.concurrent.CompletableFuture;

/**
 * @author Yuriy Stul
 */
public class CompletableFutureEx1 {
    public static void main(String[] args) {
        System.out.println("==>main");
        CompletableFuture<String> result1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("result1 is started");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
            }
            System.out.println("result1 is ready");
            return "CompletableFutureEx1 finished 111";
        });
        CompletableFuture<String> result2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("result2 is started");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignore) {
            }
            System.out.println("result2 is ready");
            return "CompletableFutureEx1 finished 222";
        });
        try {
            String theAnswer1 = result1.get();
            System.out.printf("theAnswer1=%s%n", theAnswer1);
            String theAnswer2 = result2.get();
            System.out.printf("theAnswer2=%s%n", theAnswer2);
        } catch (Exception ignore) {
        }
        System.out.println("<==main");
    }
}

/*
 * Copyright (c) 2020. Yuriy Stul
 */
package com.stulsoft.pjava.concurrency.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Playing with future
 *
 * @author Yuriy Stul.
 */
public class Future1 {
    private ExecutorService es = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        System.out.println("==>main");
        Future1 f = new Future1();
        f.test1();
        f.test2();
        f.test3();
        f.closePool();
        System.out.println("<==main");
    }

    private void test1() {
        System.out.println("==>test1");
        Future<String> future = es.submit(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignore) {
            }
            return "result";
        });
        while (!future.isDone()) {
            System.out.println("Waiting...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignore) {

            }
        }
        try {
            System.out.println("Result is " + future.get());
        } catch (Exception ignore) {
        }

        System.out.println("<==test1");
    }

    private void test2() {
        System.out.println("==>test2");
        Future<String> future = f();
        while (!future.isDone()) {
            System.out.println("Waiting...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignore) {

            }
        }
        try {
            System.out.println("Result is " + future.get());
        } catch (Exception ignore) {
        }
        System.out.println("<==test2");
    }

    private void test3() {
        System.out.println("==>test3");
        Future<String> future = f1("test3");
        while (!future.isDone()) {
            System.out.println("Waiting...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignore) {

            }
        }
        try {
            System.out.println("Result is " + future.get());
        } catch (Exception ignore) {
        }
        System.out.println("<==test3");
    }

    private Future<String> f() {
        return es.submit(() -> {
            Thread.sleep(123);
            return "the second result";
        });
    }

    private Future<String> f1(String s) {
        return es.submit(() -> {
            Thread.sleep(123);
            return "the third result " + s;
        });
    }

    private void closePool() {
        es.shutdown();
    }

}

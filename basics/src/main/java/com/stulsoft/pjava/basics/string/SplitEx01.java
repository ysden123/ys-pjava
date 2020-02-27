/*
 * Copyright (c) 2020. Yuriy Stul
 */
package com.stulsoft.pjava.basics.string;

/**
 * Playing with String.split
 *
 * @author Yuriy Stul.
 */
public class SplitEx01 {
    private static void runTest(String text, int n) {
        String items[] = text.split(",", n);
        showResults(items, n);
    }

    private static void showResults(String items[], int n) {
        System.out.println("n=" + n);
        for (String item : items) {
            System.out.println(item);
        }
    }

    private static void test1() {
        final String text = "64.242.88.10,[07/Mar/2004:16:06:51 -0800], \"GET /twiki/bin/rdiff/TWiki/NewUserTemplate?rev1=1.3&rev2=1.2 HTTP/1.1\" 200 4523";
        System.out.println("text: " + text);
        runTest(text, 0);
        runTest(text, -1);
        runTest(text, 1);
    }

    public static void main(String[] args) {
        test1();
    }
}

/*
 * Copyright (c) 2021. Yuriy Stul
 */

package com.stulsoft.pjava.basics.env;

/**
 * @author Yuriy Stul
 */
public class EnvEx1 {
    public static void main(String[] args) {
        System.out.println("==>main");
        System.out.printf("System.getenv(\"environment\"): %s%n", System.getenv("environment"));
    }
}

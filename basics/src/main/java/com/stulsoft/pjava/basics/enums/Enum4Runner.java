/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.enums;

/**
 * @author Yuriy Stul
 */
public class Enum4Runner {
    public static void main(String[] args) {
        System.out.println("==>main");
        for (var en : Enum4.values()) {
            System.out.println(en.name());
        }
    }
}

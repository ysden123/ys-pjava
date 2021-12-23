/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pjava.basics.records;

/**
 * @author Yuriy Stul
 */
public record CompactConstructor(int start, int end) {
    public CompactConstructor {
        if (start > end)
            start = -start;
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        var cc1 = new CompactConstructor(1, 2);
        System.out.printf("cc1=%s%n", cc1);

        var cc2 = new CompactConstructor(2, 1);
        System.out.printf("cc2=%s%n", cc2);
    }
}

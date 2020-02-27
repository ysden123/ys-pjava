/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.java11.collection;

import java.util.Arrays;

/**
 * @author Yuriy Stul
 */
public class ToArray {
    public static void main(String[] args) {
        System.out.println("==>main");
        var collection = Arrays.asList("One", "Two", "Three");
        var array = collection.toArray();
        for (var i = 0; i < array.length; ++i) {
            System.out.printf("array[%d]: %s%n", i, array[i]);
        }
        System.out.println("<==main");
    }
}

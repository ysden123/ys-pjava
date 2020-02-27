/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Initializing List of List
 *
 * @author Yuriy Stul
 */
public class GenericsEx2 {
    private static <T> List<List<T>> build(List<T> src) {
//        return Arrays.asList(src);
        return Collections.singletonList(src);
    }

    public static void main(String[] args) {
        List<Integer> i = Arrays.asList(1, 2, 3);
        List<List<Integer>> r = build(i);
        System.out.println("r:" + r);

//        List<List<String>> r2 = build(i);   // Error
        List<String> s = Arrays.asList("1s","2s","3s");
        List<List<String>> r3 = build(s);
        System.out.println("r3:" + r3);
    }
}

/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.basics.loop;

import java.util.Arrays;
import java.util.List;

/**
 * @author Yuriy Stul
 */
public class LoopEx1 {
    private static void test1() {
        System.out.println("==>test1");
        int a[] = {1, 2, 3, 4};
        for (int i : a) {
            System.out.println("i="+i);
            if (i < 3)
                System.out.println(i);
            else
                break;
        }
        System.out.println("<==test1");
    }

    private static void test2() {
        System.out.println("==>test2");
        List<Integer> a = Arrays.asList(1, 2, 3, 4);
        a.forEach(i -> {
            System.out.println("i="+i);
            if (i < 3)
                System.out.println(i);
            else
                return;
        });
        for (int i : a) {
            System.out.println("i="+i);
            if (i < 3)
                System.out.println(i);
            else
                break;
        }
        System.out.println("<==test2");
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}

/*
 * Copyright (c) 2020. Yuriy Stul
 */

/*
   Created by Yuriy Stul 2018
*/
package com.stulsoft.pjava.basics.args;

/**
 * @author Yuriy Stul
 */
public class ThreeDotsEx1<T> {

    public static void main(String[] args) {
        System.out.println("==>main");
        ThreeDotsEx1<String> tde1 = new ThreeDotsEx1<>();
        tde1.test1("111", "222", "333");
// ERROR        tde1.test1(111,222,333);
        String[] args2 = {"111", "222", "333"};
        tde1.test2(args2);
        System.out.println("<==main");
    }

    @SuppressWarnings(value = "unchecked")
    private void test1(T... args) {
        System.out.println("==>test1");
        System.out.println("args.length=" + args.length);
        for (T arg : args) {
            System.out.println(arg);
        }
        System.out.println("<==test1");
    }

    private void test2(T[] args) {
        System.out.println("==>test2");
        System.out.println("args.length=" + args.length);
        for (T arg : args) {
            System.out.println(arg);
        }
        System.out.println("<==test2");
    }
}

/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.basics.finalVar;

import java.util.function.Function;

/**
 * Playing with final and effectively final variables.
 *
 * @author Yuriy Stul
 */
public class FinalVarEx02 {
    private static void test1() {
        System.out.println("==>test1");
        FinalVarEx02 fv = new FinalVarEx02();
        int m = 123;    // Effectively final: no reassignment
        int r = fv.foo((s) -> s.length() + m);
        System.out.println("r=" + r);
        System.out.println("<==test1");
    }

    private static void test3() {
        System.out.println("==>test3");
        FinalVarEx02 fv = new FinalVarEx02();
        // Array 'm' is effectively final variable: we don't reassign reference to array - we change 0-th item
        int m[] = {123};
        int r = fv.foo((s) -> {
            m[0] += s.length();
            return m[0] + s.length();
        });
        System.out.println("r=" + r);
        System.out.println("<==test3");
    }

/*
Error: 'm' is neither final or effectively final
    private static void test2(){
        System.out.println("==>test2");
        FinalVarEx02 fv = new FinalVarEx02();
        int m = 123;
        int r = fv.foo((s)->{
            m += s.length();
            return m + s.length();
        });
        System.out.println("<==test2");
    }
*/

    private static void test4() {
        System.out.println("==>test4");
        FinalVarEx02 fv = new FinalVarEx02();
        // Array 'm' is final variable: we don't reassign reference to array - we change 0-th item
        final int m[] = {123};
        int r = fv.foo((s) -> {
            m[0] += s.length();
            return m[0] + s.length();
        });
        System.out.println("r=" + r);
        System.out.println("<==test4");
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        test1();
        test3();
        test4();
        System.out.println("<==main");
    }

    private int foo(Function<String, Integer> f) {
        return f.apply("test");
    }

}


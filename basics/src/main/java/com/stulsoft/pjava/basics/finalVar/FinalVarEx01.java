/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.finalVar;

/**
 * Playing with final and effectively final variables.
 *
 * @author Yuriy Stul
 */
public class FinalVarEx01 {
    private final int v3 = 123;   // Final variable
    private int v1 = 123;   // Effectively final variable: no reassignment
    private int v2 = 123;   // Non final variable

    public static void main(String[] args) {
        System.out.println("==>main");
        FinalVarEx01 fv = new FinalVarEx01();
        fv.f();
        fv.f();
        fv.f();
        System.out.println("<==main");
    }

    private void f() {
        class InternalClass {
            private void foo() {
                System.out.println("==>foo");
                System.out.println("v1=" + v1);
                System.out.println("v2=" + v2);
                System.out.println("v3=" + v3);
                v2 += 1;
// cannot assign a value to final value               v3 += 1;
                System.out.println("<==foo");
            }
        }
        InternalClass ic = new InternalClass();
        ic.foo();
    }
}

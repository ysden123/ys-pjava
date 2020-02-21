/*
 * Copyright (c) 2020. Yuriy Stul
 */
package com.stulsoft.pjava.basics.interfaces;

/**
 * @author Yuriy Stul.
 */
public class Abstract2Runner {
    public static void main(String[] args) {
        Abstract2 a2 = new Abstract2() {
            @Override
            void foo() {
                System.out.println("Fooooo");
            }
        };
        a2.foo();

        System.out.println(I1.n);

        I1 i1 = new I1() {
            @Override
            public void foo2() {
                System.out.println("foo2");
            }
        };
        i1.foo1();
    }
}

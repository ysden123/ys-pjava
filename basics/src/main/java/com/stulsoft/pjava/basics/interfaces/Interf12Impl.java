/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.basics.interfaces;

/**
 * @author Yuriy Stul
 */
public class Interf12Impl implements Interf1, Interf2 {
    public static void main(String[] args) {
        Interf12Impl i = new Interf12Impl();
        i.f();
        i.f1();
        i.f2();
    }

    @Override
    public void f() {
        System.out.println("f");
    }

    @Override
    public void f1() {
        System.out.println("f1");
    }

    @Override
    public void f2() {
        System.out.println("f2");
    }
}

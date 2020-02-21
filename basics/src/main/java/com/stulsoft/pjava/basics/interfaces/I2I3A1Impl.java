/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.interfaces;

/**
 * @author Yuriy Stul
 */
public class I2I3A1Impl extends Abstract1 implements Interface2, Interface3 {
    private I2I3A1Impl() {
        super("the test");
    }

    public static void main(String[] args) {
        I2I3A1Impl impl = new I2I3A1Impl();
        impl.f2();
        impl.f3();
        impl.fa();
    }

    @Override
    public void f2() {
        System.out.println("f2");
    }

    @Override
    public void f3() {
        System.out.println("f3");
    }

    @Override
    void fa() {
        System.out.println("fa:" + getText());
    }
}

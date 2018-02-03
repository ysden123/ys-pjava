/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pjava.basics.generics.extention;

import java.util.Arrays;
import java.util.List;

/**
 * @author Yuriy Stul
 */
public class GenExt2 {
    void useFoo1(List<? extends A> l) {
        l.forEach(A::foo1);
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        GenExt2 genExt1 = new GenExt2();
        genExt1.useFoo1(Arrays.asList(a, b));
    }
}

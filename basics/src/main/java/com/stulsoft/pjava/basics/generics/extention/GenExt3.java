/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.generics.extention;

import java.util.Arrays;
import java.util.List;

/**
 * @author Yuriy Stul
 */
public class GenExt3<T extends A> {
    void useFoo1(List<? extends T> l) {
        l.forEach(A::foo1);
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        GenExt3<A> genExt1 = new GenExt3<>();
        genExt1.useFoo1(Arrays.asList(a, b));
        GenExt3<B> genExt2 = new GenExt3<>();
// error        genExt2.useFoo1(Arrays.asList(a, b));
        genExt2.useFoo1(Arrays.asList(b));
    }
}

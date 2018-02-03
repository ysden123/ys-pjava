/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pjava.basics.generics.extention;

/**
 * @author Yuriy Stul
 */
public class GenExt1<T extends A> {
    void useFoo1(T t) {
        t.foo1();
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        GenExt1<A> genExt11 = new GenExt1<>();
        genExt11.useFoo1(a);
        genExt11.useFoo1(b);
        GenExt1<B> genExt12 = new GenExt1<>();
// error       genExt12.useFoo1(a);
        genExt12.useFoo1(b);
    }
}

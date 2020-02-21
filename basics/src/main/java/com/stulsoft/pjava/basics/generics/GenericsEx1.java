/*
 * Copyright (c) 2020. Yuriy Stul
 */
package com.stulsoft.pjava.basics.generics;

import java.util.ArrayList;
import java.util.List;

/** Playing with generics
 * @author Yuriy Stul.
 */
public class GenericsEx1<T> {
    private final T t;
    GenericsEx1(T t){
        this.t=t;
    }
    public static <T> boolean checkOnNull(T t){
        return t == null;
    }
    public static <T> List<T> getAsList(T t){
        List<T> l = new ArrayList<>();
        l.add(t);
        return l;
    }
}

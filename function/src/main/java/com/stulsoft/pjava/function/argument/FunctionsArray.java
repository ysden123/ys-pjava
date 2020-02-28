/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.function.argument;

import java.util.HashMap;
import java.util.function.Function;

/**
 * @author Yuriy Stul
 */
public class FunctionsArray {
    public static void main(String[] args) {
        var fa = new FunctionsArray();
        fa.test1();
    }

    void test1() {
        System.out.println("==>test1");
        var functionMap = new HashMap<String, Function<Integer, String>>();

        functionMap.put("n1", Object::toString);
        functionMap.put("n2", i -> String.valueOf(i * 25));

        functionMap.forEach((name, f) ->System.out.printf("%s -> %s%n",name, f.apply(123)));
        System.out.println("<==test1");
    }
}

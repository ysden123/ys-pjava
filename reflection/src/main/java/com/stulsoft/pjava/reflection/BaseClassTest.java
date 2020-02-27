/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.reflection;

import java.lang.reflect.Method;

/**
 * Test runner for BaseClass
 * Created by Yuriy Stul on 11/11/2016.
 */
public class BaseClassTest extends BaseClass {

    /**
     * Access to private method.
     */
    public void accessPrivateMethod() {
        System.out.println("==>accessPrivateMethod");
        try {
            Class[] params = new Class[1];
            params[0] = String.class;
            Method foo = BaseClass.class.getDeclaredMethod("foo", params);
            foo.setAccessible(true);
            System.out.printf("foo.invoke(this, \"example of text\"): %s\n", foo.invoke(this, "example of text"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("<==accessPrivateMethod");
    }

    public static void main(String args[]) {
        System.out.println("==>main");
        BaseClassTest t = new BaseClassTest();
        t.accessPrivateMethod();
        System.out.println("<==main");
    }
}
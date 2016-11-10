package com.stulsoft.js_pjava.reflection;

/**
 * Test class with private member and method.
 *
 * Created by Yuriy Stul on 11/10/2016.
 */
final class AccessTestClass {
    AccessTestClass() {
        mi = 123;
    }

    /**
     * A private method.
     */
    private void foo() {
        System.out.println("==>foo");
        System.out.printf("mi = %d\n", mi);
        System.out.println("<==foo");
    }

    private int mi;
}

/*
 * Copyright (c) 2020. Yuriy Stul
 */

/*
   Created by Yuriy Stul 2018
*/
package com.stulsoft.pjava.basics.arrays;

import java.util.Arrays;

/**
 * Playing with arrays.
 *
 * @author Yuriy Stul
 * @since 2/18/2018
 */
public class PArraysEx1 {
    public static void main(String[] args) {
        PArraysEx1 ex = new PArraysEx1();
// ArrayStoreException ex.test1();
        ex.test2();
// ArrayStoreException ex.test4();
    }

    void test1() {
        Integer[] a1 = new Integer[]{1, 2};
        Type1[] a2 = Arrays.copyOf(a1, a1.length, Type1[].class);
        System.out.println(Arrays.asList(a2));
    }

    void test2() {
        Object[] a1 = {"Australia", "India"};
        String[] a2 = Arrays.copyOf(a1, a1.length, String[].class);
        System.out.println(Arrays.asList(a2));
    }

/* Error: int is not object
    void test3(){
        int[] a1 = new int[]{1,2};
        String[] a2 = Arrays.copyOf(a1, a1.length, String[].class);
    }
*/

    void test4() {
        Integer[] a1 = new Integer[]{1, 2};
        String[] a2 = Arrays.copyOf(a1, a1.length, String[].class);
        System.out.println(Arrays.asList(a2));
    }

    class Type1 {
        private final int age;

        public Type1(final int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Type1{" +
                    "age=" + age +
                    '}';
        }
    }
}

/*
 * Copyright (c) 2021. Yuriy Stul
 */

package com.stulsoft.pjava.basics.enums;

/**
 * @author Yuriy Stul
 */
public class EnumEntityRunner {
    public static void main(String[] args) {
        System.out.println("==>main");

        test1();
        test2();
        test3();
    }

    private static void test1() {
        System.out.println("==>test1");
        var sort = EnumEntity.fromString("sort-1");
        System.out.printf("sort: %s, sort == EnumEntity.SORT_1: %b%n", sort, sort == EnumEntity.SORT_1);
    }

    private static void test2(){
        System.out.println("==>test2");
        try {
            var sort = EnumEntity.fromString("sort-error");
            System.out.printf("sort: %s, sort == EnumEntity.SORT_1: %b%n", sort, sort == EnumEntity.SORT_1);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    private static void test3(){
        System.out.println("==>test3");
        try {
            var sort = EnumEntity.valueOf("sort-error");
            System.out.printf("sort: %s, sort == EnumEntity.SORT_1: %b%n", sort, sort == EnumEntity.SORT_1);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}

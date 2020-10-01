/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.excp;

import java.util.Arrays;

/**
 * @author Yuriy Stul
 */
public class ExcpEx02 {
    public static void main(String[] args) {
        System.out.println("==>main");
        test1();
        System.out.println("<==main");
    }
    private static void test1(){
        System.out.println("==>test1");
        var l = Arrays.asList(1,2,3,4,5);

        try {
            l.forEach(i -> {
                if (i > 2) {
                    throw new RuntimeException("Test exception");
                }else{
                    System.out.println(" " + i);
                }
            });
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("<==test1");
    }
}

/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.excp;

/**
 * @author Yuriy Stul
 */
public class ExcpEx01 {

    public void run() {
        throw new NullPointerException("test");
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        var e = new ExcpEx01();

        try {
            System.out.println("1");
            e.run();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("2");
            e.run();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("<==main");
    }
}

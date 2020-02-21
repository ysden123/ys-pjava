/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.classes;

/**
 * Demonstrates wrong initialization
 *
 * @author Yuriy Stul
 */
public class ClassWithWrongInit {
    private int i;
    private String is = calculateIS();

    public static void main(String[] args) {
        System.out.println("==>main");
        var c = new ClassWithWrongInit();
        System.out.printf("(0) c.getIs() = %s, c.getI()=%d%n", c.getIs(), c.getI());
        c.setI(123);
        System.out.printf("(1) c.getIs() = %s, c.getI()=%d%n", c.getIs(), c.getI());
        System.out.println("<==main");
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getIs() {
        return is;
    }

    public void setIs(String is) {
        this.is = is;
    }

    private String calculateIS() {
        return String.valueOf(i);
    }
}

/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics;

/**
 * @author Yuriy Stul
 */
public class SoundBell {
    public static void main(String args[]) {
        // ASCII bell
//        System.out.print("\0007");
//        System.out.println("BEEPu0007!");
        java.awt.Toolkit.getDefaultToolkit().beep();
        System.out.flush();
    }
}

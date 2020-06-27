/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.interfaces;

/**
 * @author Yuriy Stul
 */
public class InterfaceWithStaticMethods {
    static String intToString(int i){
        return Integer.toString(i);
    }

    static String lowCase(String s){
        return s.toLowerCase();
    }
}

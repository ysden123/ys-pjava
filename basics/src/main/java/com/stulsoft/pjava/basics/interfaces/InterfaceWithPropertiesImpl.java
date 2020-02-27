/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.interfaces;

/**
 * @author Yuriy Stul
 */
public class InterfaceWithPropertiesImpl implements InterfaceWithProperties {
    /*
        public void f2(int i){
            // ERROR: nonassignable variable p2: p2 = i + 100;
        }
    */
    public static void main(String[] args) {
        InterfaceWithProperties instance = new InterfaceWithPropertiesImpl();
        System.out.println("instance.f(123): " + instance.f(123));
        System.out.println("InterfaceWithProperties.p2: " + InterfaceWithProperties.p2);

    }

    @Override
    public int f(int i) {
        return i + p2;
    }
}

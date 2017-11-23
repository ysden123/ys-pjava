package com.stulsoft.pjava.basics.interfaces;

/**
 * @author Yuriy Stul
 */
public class InterfaceWithMethodsImpl implements InterfaceWithMethods {
    public static void main(String[] args) {
        System.out.println("==>main");
        InterfaceWithMethods instance = new InterfaceWithMethodsImpl();
        System.out.println(instance.add(1));
        System.out.println(instance.dec(1));
        System.out.println(InterfaceWithMethods.inc(1));
        System.out.println("<==main");
    }

    @Override
    public int dec(int i) {
        return i - 1;
    }
}

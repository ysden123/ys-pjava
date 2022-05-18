package com.stulsoft.pjava.basics.string;

/**
 * @author Yuriy Stul
 **/
public class AllocationEx01 {
    public static void main(String[] args) {
        AllocationEx01 allocationEx01 = new AllocationEx01();
        allocationEx01.test1();
        allocationEx01.test2();
    }
    private void test1(){
        System.out.println("==>test1");
        String t1 = "abc";
        String t2 = "abc";
        System.out.printf("t1 == t2 is %b%n", (t1 == t2));
    }

    private void test2(){
        System.out.println("==>test2");
        String t1 = new String("abc");
        String t2 = new String("abc");
        System.out.printf("t1 == t2 is %b%n", (t1 == t2));
    }
}

package com.stulsoft.pjava.basics.string;

/**
 * @author Yuriy Stul
 **/
public class SubstringTest {
    private static void test(String str, int maxLength){
        if (str.length() > maxLength) {
            str = str.substring(0, 2);
        }
        System.out.println("in test " + str);
    }

    public static void main(String[] args) {
        String str;
        str = "012";
        test(str, 2);
        System.out.println("after test " + str);

        str="0";
        test(str, 2);
        System.out.println("after test " + str);
    }
}

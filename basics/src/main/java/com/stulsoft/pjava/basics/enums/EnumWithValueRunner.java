package com.stulsoft.pjava.basics.enums;

public class EnumWithValueRunner {
    public static void main(String[] args) {
        var enumWithValue1 = EnumWithValue.EnV1;
        var enumWithValue2 = EnumWithValue.EnV2;

        System.out.println(enumWithValue1);
        System.out.println(enumWithValue2);

/*
        var enumWithValue3 = EnumWithValue.valueOf("enum value one");
        System.out.println(enumWithValue3);
*/
        var enumWithValue3 = EnumWithValue.valueOf("EnV1");
        System.out.println(enumWithValue3);
    }
}

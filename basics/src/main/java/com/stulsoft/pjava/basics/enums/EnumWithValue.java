package com.stulsoft.pjava.basics.enums;

/**
 * @author Yuriy Stul
 **/
public enum EnumWithValue {
    EnV1("enum value one"),
    EnV2("enum value two");

    private final String value;

    EnumWithValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}


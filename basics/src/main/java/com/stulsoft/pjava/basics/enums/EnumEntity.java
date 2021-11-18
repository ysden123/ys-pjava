/*
 * Copyright (c) 2021. Yuriy Stul
 */

package com.stulsoft.pjava.basics.enums;

import java.util.Arrays;

/**
 * @author Yuriy Stul
 */
public enum EnumEntity {
    SORT_1("sort-1"), SORT_2("sort-2");

    private String value;

    private EnumEntity(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static EnumEntity fromString(String text){
        var result = Arrays.stream(values()).filter(ee -> ee.toString().equals(text)).findFirst();
        if (result.isPresent())
            return result.get();
        else
            throw new IllegalArgumentException("Unsupported value of EnumEntity: " + text);
    }

}

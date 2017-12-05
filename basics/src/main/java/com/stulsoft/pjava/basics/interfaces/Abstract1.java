/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.basics.interfaces;

/**
 * @author Yuriy Stul
 */
abstract class Abstract1 {
    private final String text;

    Abstract1(String text) {
        this.text = text;
    }

    abstract void fa();

    String getText() {
        return text;
    }
}

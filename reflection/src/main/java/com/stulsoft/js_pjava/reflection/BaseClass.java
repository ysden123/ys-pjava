package com.stulsoft.js_pjava.reflection;

/**
 * Some base class
 * Created by Yuriy Stul on 11/11/2016.
 */
public class BaseClass {
    public String bar() {
        return "I'm bar. " + text;
    }

    /**
     * Some method.
     *
     * @param text a text
     * @return converted text
     */
    private String foo(String text) {
        return text.toUpperCase();
    }

    private String text = "A private text";
}


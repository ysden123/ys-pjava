/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.pjava.function;

import java.util.function.Consumer;

/**
 * Demonstrates usage delegated handler
 * @author Yuriy Stul
 */
class Executor {
    /**
     * Calls a handler during executing some process
     * @param handler the handler; receives string argument
     */
    static void execute(Consumer<String> handler) {
        System.out.println("==>execute");

        for (int i = 1; i <= 5; ++i) {
            handler.accept(String.format("The string # %d", i));
        }

        System.out.println("<==execute");
    }
}

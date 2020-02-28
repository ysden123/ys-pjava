/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.function.argument;

import java.util.function.Consumer;

/**
 * @author Yuriy Stul
 */
public class DetachedConsumer2 implements IDetachedService2{
    @Override
    public Consumer<Integer> consumer() {
        return i -> {
            System.out.printf("Inside %s: argument = %d%n", serviceName(), i);
        };
    }
}

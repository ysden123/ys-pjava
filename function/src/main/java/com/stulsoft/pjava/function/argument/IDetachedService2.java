/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.function.argument;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Yuriy Stul
 */
public interface IDetachedService2 {
    default String serviceName() {
        return this.getClass().getSimpleName();
    }

    Consumer<Integer> consumer();
}

/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.function.argument;

import java.util.function.Function;

/**
 * @author Yuriy Stul
 */
public interface IDetachedService {
    default String serviceName() {
        return this.getClass().getSimpleName();
    }

    Function<Integer, String> transformer();
}

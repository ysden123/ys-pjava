/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.function.argument;

import java.util.function.Function;

/**
 * @author Yuriy Stul
 */
public class DetachedService1 implements IDetachedService {

    @Override
    public Function<Integer, String> transformer() {
        return i -> String.valueOf(i + 123);
    }
}

/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pjava.basics.singleton;

import java.util.Random;

/**
 * @author Yuriy Stul
 */
public class SingletonEnum {
    enum RandomEnum {
        INSTANCE;

        private Random random = new Random();

        Random random() {
            return random;
        }
    }

    public void show() {
        System.out.printf("nextInt=%d%n", RandomEnum.INSTANCE.random().nextInt());

        RandomEnum.INSTANCE.random=null;
        System.out.printf("nextInt=%d%n", RandomEnum.INSTANCE.random().nextInt());
    }

    public static void main(String[] args) {
        var se = new SingletonEnum();
        se.show();
    }
}

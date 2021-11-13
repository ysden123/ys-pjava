/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pjava.basics.singleton;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Yuriy Stul
 */
public class SingletonEx1 {
    private static volatile Random random;

    public int nextInt(){
        if (random == null){
            synchronized (Random.class){
                if (random==null){
                    random=new Random();
                }
            }
        }
        return random.nextInt(0, 1000);
    }

    public int missing(int[] A){
        int[] sorted=Arrays.copyOf(A, A.length);

        Arrays.sort(sorted);
        int n = sorted[sorted.length -1] + 1;
        for(int i =0; i < sorted.length -1;++i){
            if (sorted[i + 1] - sorted[i] > 1){
                n=sorted[i] + 1;
                break;
            }
        }
        return n <= 0? 1: n;
    }

    public static void main(String[] args) {
        var sex1=new SingletonEx1();
        System.out.printf("n=%d%n", sex1.missing(new int[]{1,2,3}));
        System.out.printf("n=%d%n", sex1.missing(new int[]{1,5,7}));
    }
}

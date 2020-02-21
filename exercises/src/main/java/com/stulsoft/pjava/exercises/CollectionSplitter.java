/*
 * Copyright (c) 2020. Yuriy Stul
 */
package com.stulsoft.pjava.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yuriy Stul.
 */
public class CollectionSplitter {
    static <T> Tuple2<List<T>> splitAt(List<T> source, int position) {
        if (position >= source.size()) {
            return new Tuple2<>(source, new ArrayList<>());
        } else {
            List<T> left = new ArrayList<>();
            List<T> right = new ArrayList<>();
            left.addAll(source.subList(0, position));
            right.addAll(source.subList(position, source.size()));
            return new Tuple2<>(left, right);
        }
    }

    public static void main(String args[]){
        List<Integer> src1 = Arrays.asList(1,2,3);
        Tuple2<List<Integer>> t0 = CollectionSplitter.splitAt(src1, 0);
        System.out.println("src1: " + src1 + ", t0: " + t0);
        Tuple2<List<Integer>> t1 = CollectionSplitter.splitAt(src1, 1);
        System.out.println("src1: " + src1 + ", t1: " + t1);
        Tuple2<List<Integer>> t2 = CollectionSplitter.splitAt(src1, 2);
        System.out.println("src1: " + src1 + ", t2: " + t2);
        Tuple2<List<Integer>> t3 = CollectionSplitter.splitAt(src1, 3);
        System.out.println("src1: " + src1 + ", t3: " + t3);
        List<Integer> src2 = new ArrayList<>();
        Tuple2<List<Integer>> t4 = CollectionSplitter.splitAt(src2, 1);
        System.out.println("src2: " + src2 + ", t4: " + t4);
    }
}

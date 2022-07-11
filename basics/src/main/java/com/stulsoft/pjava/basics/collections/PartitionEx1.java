package com.stulsoft.pjava.basics.collections;

import com.google.common.collect.Lists;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Playing with "Lists.partition"
 *
 * @author Yuriy Stul
 **/
public class PartitionEx1 {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        test(l1, 2);
        test(l1, 3);
        test(l1, 10);
        test(l1, 100);
        test(Collections.emptyList(), 100);
    }


    private static void test(List<Integer> list, int partitionSize) {
        List<List<Integer>> partition = Lists.partition(list, partitionSize);
        System.out.println(MessageFormat.format("list.size() = {0}, partitionSize = {1}, partition.size() = {2}",
                list.size(), partitionSize, partition.size()));
    }
}

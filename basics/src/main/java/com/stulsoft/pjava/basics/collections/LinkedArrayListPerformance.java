package com.stulsoft.pjava.basics.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class LinkedArrayListPerformance {
    record Stats(Long arrayList, Long linkedList) {
    }

    public static void main(String[] args) {
        var collection = generate(10_000_000);
        var stats = new ArrayList<Stats>();
        for (int i = 1; i < 100; ++i)
            stats.add(new Stats(testArrayList(collection), testLinkedList(collection)));
        int averageArrayList = 0;
        int averageLinkedList = 0;
        for (Stats stat : stats) {
            System.out.println(stat);
            averageArrayList += stat.arrayList();
            averageLinkedList += stat.linkedList();
        }
        System.out.printf("averageArrayList = %d, averageLinkedList = %d%n",
                averageArrayList / stats.size(),
                averageLinkedList / stats.size());
    }

    private static Long testArrayList(Collection<String> data) {
        long start = System.currentTimeMillis();
//        new ArrayList<>(data);
        var list = new ArrayList<String>();
        list.addAll(data);
        return System.currentTimeMillis() - start;
    }

    private static Long testLinkedList(Collection<String> data) {
        long start = System.currentTimeMillis();
//        new LinkedList<>(data);
        var list = new LinkedList<String>();
        list.addAll(data);
        return System.currentTimeMillis() - start;
    }

    private static Collection<String> generate(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            list.add(String.format("Text %d", i));
        }
        return list;
    }
}

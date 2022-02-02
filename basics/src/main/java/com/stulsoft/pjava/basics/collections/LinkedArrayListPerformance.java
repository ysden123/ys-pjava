package com.stulsoft.pjava.basics.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class LinkedArrayListPerformance {
    record Stats(Long arrayList, Long linkedList) {
    }

    public static void main(String[] args) {
        var data = generate(10_000_000);
        testAddAll(data);
        testAdd(data);
    }

    private static void testAddAll(Collection<String> data){
        System.out.println("testAddAll:");
        var stats = new ArrayList<Stats>();
        for (int i = 1; i < 100; ++i)
            stats.add(new Stats(testAddAllArrayList(data), testAddAllLinkedList(data)));
        int averageArrayList = 0;
        int averageLinkedList = 0;
        for (Stats stat : stats) {
//            System.out.println(stat);
            averageArrayList += stat.arrayList();
            averageLinkedList += stat.linkedList();
        }
        System.out.printf("averageArrayList = %d, averageLinkedList = %d%n",
                averageArrayList / stats.size(),
                averageLinkedList / stats.size());
    }

    private static void testAdd(Collection<String> data){
        System.out.println("testAdd:");
        var stats = new ArrayList<Stats>();
        for (int i = 1; i < 100; ++i)
            stats.add(new Stats(testAddArrayList(data), testAddLinkedList(data)));
        int averageArrayList = 0;
        int averageLinkedList = 0;
        for (Stats stat : stats) {
//            System.out.println(stat);
            averageArrayList += stat.arrayList();
            averageLinkedList += stat.linkedList();
        }
        System.out.printf("averageArrayList = %d, averageLinkedList = %d%n",
                averageArrayList / stats.size(),
                averageLinkedList / stats.size());
    }

    private static Long testAddAllArrayList(Collection<String> data) {
        long start = System.currentTimeMillis();
        var list = new ArrayList<String>();
        list.addAll(data);
        return System.currentTimeMillis() - start;
    }

    private static Long testAddArrayList(Collection<String> data) {
        long start = System.currentTimeMillis();
        var list = new ArrayList<String>();
        data.forEach(list::add);
        return System.currentTimeMillis() - start;
    }

    private static Long testAddAllLinkedList(Collection<String> data) {
        long start = System.currentTimeMillis();
        var list = new LinkedList<String>();
        data.forEach(list::add);
        return System.currentTimeMillis() - start;
    }

    private static Long testAddLinkedList(Collection<String> data) {
        long start = System.currentTimeMillis();
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

package com.stulsoft.pjava.sqlfilter;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Yuriy Stul
 **/
public class QueryBuilderTests {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        System.out.println("==>test1");

        Filter filter = new Filter(Operator.AND, CompareOperator.EQ, "projectId", "1", Collections.emptyList());
        System.out.printf("query:%s%n", QueryBuilder.build(Collections.singletonList(filter)));

        Filter filter1 = new Filter(Operator.AND, CompareOperator.EQ, "projectId", 123, Collections.emptyList());
        System.out.printf("query:%s%n", QueryBuilder.build(Collections.singletonList(filter1)));
    }

    private static void test2() {
        System.out.println("==>test2");

        Filter filter1 = new Filter(Operator.AND, CompareOperator.EQ, "projectId", 1, Collections.emptyList());
        Filter filter2 = new Filter(Operator.AND, CompareOperator.EQ, "productId", 2, Collections.emptyList());
        Filter filter3 = new Filter(Operator.AND, CompareOperator.LIKE, "customerName", "%yu%", Collections.emptyList());
        System.out.printf("query:%s%n", QueryBuilder.build(Arrays.asList(filter1, filter2, filter3)));
    }

    private static void test3() {
        System.out.println("==>test3");

        Filter filter1 = new Filter(Operator.AND, CompareOperator.EQ, "projectId", 1, Collections.emptyList());
        Filter filter2 = new Filter(Operator.AND, CompareOperator.EQ, "productId", 2, Collections.emptyList());
        Filter filter3 = new Filter(Operator.AND, CompareOperator.LIKE, "customerName", "%yu%", Collections.emptyList());
        System.out.printf("query:%s%n", QueryBuilder.build(new Filter[]{filter1, filter2, filter3}));
    }
}

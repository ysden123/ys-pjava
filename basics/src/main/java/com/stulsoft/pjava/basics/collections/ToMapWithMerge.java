package com.stulsoft.pjava.basics.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Yuriy Stul
 **/
public class ToMapWithMerge {
    static class Container {
        private final Long id;
        private final String name;

        public Container(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Container{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        test1();
        test2();
        test3();
    }

    private static void test1() {
        System.out.println("==>test1");
        List<Container> list = new ArrayList<>();
        list.add(new Container(1L, "n1"));
        list.add(new Container(1L, "n2"));
        list.add(new Container(2L, "n3"));
        Map<Long, Container> map = list.stream().collect(Collectors.toMap(Container::getId, Function.identity(), (p1, p2) -> p1));
        System.out.println("list: " + list);
        System.out.println("map: " + map);
    }

    private static void test2() {
        System.out.println("==>test2");
        List<Container> list = new ArrayList<>();
        list.add(new Container(1L, "n1"));
        list.add(new Container(1L, "n2"));
        list.add(new Container(2L, "n3"));
        Map<Long, Container> map = list.stream().collect(Collectors.toMap(Container::getId, p -> p, (p1, p2) -> p1));
        System.out.println("list: " + list);
        System.out.println("map: " + map);
    }

    private static void test3() {
        System.out.println("==>test3");
        try {
            List<Container> list = new ArrayList<>();
            list.add(new Container(1L, "n1"));
            list.add(new Container(1L, "n2"));
            list.add(new Container(2L, "n3"));
            Map<Long, Container> map = list.stream().collect(Collectors.toMap(Container::getId, Function.identity()));
            System.out.println("list: " + list);
            System.out.println("map: " + map);
        }catch (IllegalStateException exception){
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}

package com.stulsoft.pjava.basics.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class ConsumerWithTwoArguments {
    static class Container {
        private final String name;
        private int counter;

        public Container(String name) {
            this.name = name;
            counter = 0;
        }

        @Override
        public String toString() {
            return "Container{" +
                    "name='" + name + '\'' +
                    ", counter=" + counter +
                    '}';
        }

        public void increaseCounter() {
            ++counter;
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        System.out.println("==>test1");

        Container blackContainer = new Container("black");
        Container blueContainer = new Container("blue");

        List<String> list = Arrays.asList("black", "blue", "black", "blue", "black", "black");
        boolean trigger = true;
        for (String name : list) {
            switch (name) {
                case "black":
                    blackContainer.increaseCounter();
                    if (trigger) {
                        blackContainer.increaseCounter();
                    }
                    break;
                case "blue":
                    blueContainer.increaseCounter();
                    if (trigger) {
                        blueContainer.increaseCounter();
                    }
                    break;
                default:
                    break;
            }
            trigger = !trigger;
        }

        System.out.println(blackContainer);
        System.out.println(blueContainer);
    }

    private static void test2() {
        System.out.println("==>test2");

        BiConsumer<Boolean, Container> consumer = (b, c) -> {
            c.increaseCounter();
            if (b){
                c.increaseCounter();
            }
        };

        Container blackContainer = new Container("black");
        Container blueContainer = new Container("blue");

        List<String> list = Arrays.asList("black", "blue", "black", "blue", "black", "black");
        Boolean trigger = true;
        for (String name : list) {
            switch (name) {
                case "black":
                    consumer.accept(trigger, blackContainer);
                    break;
                case "blue":
                    consumer.accept(trigger, blueContainer);
                    break;
                default:
                    break;
            }
            trigger = !trigger;
        }

        System.out.println(blackContainer);
        System.out.println(blueContainer);
    }
}

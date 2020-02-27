/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class User {
    private String casino;
    private String username;

    User(String casino, String username) {
        this.casino = casino;
        this.username = username;
    }

    String getCasino() {
        return casino;
    }

    @Override
    public String toString() {
        return "User{" +
                "casino='" + casino + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

/**
 * Demonstrates usage of groupingBy for converting collection to map[Key,Collection]
 *
 * @author Yuriy Stul
 */
public class Collection2Map {
    public static void main(String[] args) {
        Collection<User> c1 = Arrays.asList(new User("casino1", "user1"), new User("casino1", "user2"), new User("casino2", "user3"));

        Map<String, List<User>> m1 = c1.stream().collect(Collectors.groupingBy(User::getCasino));
        System.out.println("m1: " + m1);
    }
}

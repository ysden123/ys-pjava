/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.optional;

import java.util.Optional;

/**
 * Playing with map and flatMap of Optional
 *
 * @author Yuriy Stul
 */
public class POptionalWithMapAndFlatMap {
    public static void main(String[] args) {
        System.out.println("==>main");
        test1();
        test2();
        test3();
        test4();
        test5();
        System.out.println("<==main");
    }

    private static void test1() {
        System.out.println("==>test1");
        Person person = new Person();
        person.name = "test1";
        System.out.println("person.getAddress(): " + person.getAddress());
        Optional<Address> address = person.getAddress();
        System.out.println("address.map(Address::getCity): " + address.map(Address::getCity));
        System.out.println("<==test1");
    }

    private static void test2() {
        System.out.println("==>test2");
        Optional<Person> person = Optional.of(new Person());
        person.get().name = "test2";
        Optional<Address> address = person.flatMap(Person::getAddress);
        System.out.println("address: " + address);
        System.out.println("<==test2");
    }

    private static void test3() {
        System.out.println("==>test3");
        Optional<Person> person = Optional.of(new Person());
        person.get().name = "test3";
        person.get().address = new Address();
        person.get().address.city = "the city";
        Optional<String> city = person.flatMap(Person::getAddress).map(Address::getCity);
        System.out.println("city: " + city);
        System.out.println("<==test3");
    }

    private static void test4() {
        System.out.println("==>test4");
        Optional<Person> person = Optional.of(new Person());
        person.get().name = "test4";
        Optional<String> city = person.flatMap(Person::getAddress).map(Address::getCity);
        System.out.println("city: " + city);
        System.out.println("<==test4");
    }

    private static void test5() {
        System.out.println("==>test5");
        Optional<Person> person = Optional.of(new Person());
        person.get().name = "test5";
        Optional<String> city = person.map(Person::getAddress).map(a -> a.map(address -> address.city).orElse(null));
        System.out.println("city: " + city);
        System.out.println("city.isPresent(): " + city.isPresent());
        System.out.println("<==test5");
    }
}

class Person {
    String name;
    Address address;

    Optional<Address> getAddress() {
        return (address == null ? Optional.empty() : Optional.of(address));
    }
}

class Address {
    String city;

    String getCity() {
        return city;
    }
}

/*
 * Copyright (c) 2020. Yuriy Stul
 */
package com.stulsoft.pjava.function;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Usage of Predicate function.
 *
 * @author Yuriy Stul.
 */
public class PredicateExample {
	public static void main(String[] args) {
		System.out.println("==>main");
		Predicate<String> p = x -> x.equals("abc");
		Stream.of("cccc", "dddd", "abc")
				.filter(p)
				.forEach(System.out::println);
		System.out.println("<==main");

	}
}

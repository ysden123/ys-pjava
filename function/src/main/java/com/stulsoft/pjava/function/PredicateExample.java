/*
 * Copyright (c) 2017, Yuriy Stul
 */
package com.stulsoft.pjava.function;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Usage of Predicate function.
 *
 * @author Yuriy Stul.
 */
public class PredicateExample {
	public static void main(String[] args) {
		System.out.println("==>main");
		Predicate<String> p = x -> x.equals("abc");
		Arrays.asList("cccc", "dddd", "abc")
				.stream()
				.filter(p)
				.forEach(System.out::println);
		System.out.println("<==main");

	}
}

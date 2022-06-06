package com.maksymchuk.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class StringComparatorTest {

	@Test
	void test() {
		StringComparatorWithReference sc = new StringComparatorWithReference("foo".length());
		List<String> sl = new ArrayList<String>(Arrays.asList("1","12","123","1234","12345","123456"));
		
		System.out.println(sl);
		Collections.sort(sl, sc);
		
		System.out.println(sl);
		
	}
	
	@Test
	void testStringMapSortByInt()
	{
	    List<String> numbers = Arrays.asList("1", "2", "30", "4", "5", "16");
	    System.out.println("original list: " + numbers);

	    List<Integer> even = numbers.stream()
	                                .map(s -> Integer.valueOf(s))
	                                .filter(number -> number % 2 == 0)
	                                .sorted()
	                                .collect(Collectors.toList());
	    
	    System.out.println(even);
	}
}

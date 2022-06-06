package com.maksymchuk.prep;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StringToMap {

	@Test
	public void testStringStreamToCharArrray()
	{
		String s = "asdfasdfasdfasdfkdasjkdfa";
		Stream<Character> charStream = s.codePoints().mapToObj(c -> (char)c);
		
		List<Character> sorted = charStream.sorted().collect(Collectors.toList());
		
	}
	
	@Test
	public void testStringSplitUsingRegexAndStreams()
	{
        String phone = "012-3456789";

        // Normal String#split
        // String[] output = phone.split("-");

        // Java 8 splitAsStream
        List<String> output = Pattern.compile("-")
                .splitAsStream(phone)
                .collect(Collectors.toList());

        System.out.println(output);
	}
}

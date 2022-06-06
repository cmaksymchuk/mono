package com.maksymchuk.shopify;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class StringDictOfWordsTest {

	Set<String> dict;
	StringDictOfWords dwowt = new StringDictOfWords();

	
	
	
	
	@Test
	void test() {
		dict = new HashSet<String>();
		dict.addAll(Arrays.asList("practice","perfect","makes"));
		String string = "Practice makes perfect.";
		
		assertTrue(dwowt.validSentence(dict, string));
	}
	
	@Test
	void testFalseNotInDict() {
		dict = new HashSet<String>();
		dict.addAll(Arrays.asList("practice","perfect"));
		String string = "Practice makes perfect.";
		
		assertFalse(dwowt.validSentence(dict, string));
	}

}

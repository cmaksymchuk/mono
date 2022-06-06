package com.maksymchuk.prep;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnagramTest {
	
	Anagram anagram = new Anagram();
	
	@Test
	void testTrue() {
		assertTrue(anagram.test("foo","oof"));
		assertTrue(anagram.test("asdf", "asdf"));
		assertTrue(anagram.test(" --", "-- "));
	}
	
	@Test
	void testFalse() {
		assertFalse(anagram.test(null, (String)null));
		assertFalse(anagram.test("foo","oofo"));
		assertFalse(anagram.test("tews","wast"));
	}

}

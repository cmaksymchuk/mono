package com.maksymchuk.cce.arraysstrings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.TreeMap;

import org.junit.jupiter.api.Test;

public class ArraysStringsTest {
	ArraysStrings arraysStrings = new ArraysStrings();
	
	@Test 
	public void testIsUnique()
	{
		assertTrue(arraysStrings.isUnique1("abcd"));
		assertFalse(arraysStrings.isUnique1("abcdea"));		
		
	}
	
	@Test 
	public void testIsUnique2()
	{
		assertTrue(arraysStrings.isUnique2("abcd"));
		assertFalse(arraysStrings.isUnique2("abcdea"));
		
	}
}

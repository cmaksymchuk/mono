package com.maksymchuk.cci;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ArraysStringsTest {
	private ArraysStrings iu = new ArraysStrings();
	@Test
	void testIsUnique() {
		assertTrue(iu.isUnique("asdf"));
		assertTrue(iu.isUnique("Uu"));
		assertFalse(iu.isUnique("aa"));
		assertFalse(iu.isUnique("asdfa"));
	}

	@Test
	public void testIsPermutation()
	{
		assertTrue(iu.checkPermutation("asdf", "fasd"));
		assertTrue(iu.checkPermutation("AaAa", "aaaa"));
		assertFalse(iu.checkPermutation("b", "a"));
		assertFalse(iu.checkPermutation("aaaab", "aaaaa"));


	}
	
	@Test
	public void testUrlIfy()
	{
		assertEquals("asdf", iu.urlIfy("asdf"));
		assertEquals("aa%20aa",iu.urlIfy("aa aa  "));
		assertEquals("Mr%20John%20Smith",iu.urlIfy("Mr John Smith    "));
	}
	
	@Test
	public void testPalendromePermutation()
	{
		assertTrue(iu.permutationOfPalendrome("Tact Coa"));
	}
	
	@Test
	public void testOneAway() 
	{
		assertTrue(iu.oneAway("pale", "ple"));
		assertTrue(iu.oneAway("pales", "pale"));
		assertTrue(iu.oneAway("pale", "bale"));
		assertFalse(iu.oneAway("pale", "bake"));				
	}
}

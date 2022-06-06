package com.maksymchuk.prep;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ReversePolishTest {
	
	ReversePolish rp = new ReversePolish();

	@Test
	void testSimpleAdd() {
		assertEquals(13, rp.evaluate(new String[] {"1","12","+"}));
	}
	
	@Test
	void testSimpleMinus() {
		assertEquals(-11, rp.evaluate(new String[] {"1","12","-"}));
	}
	
	@Test
	void testSimpleMultiply() {
		assertEquals(12, rp.evaluate(new String[] {"1","12","*"}));
	}
	
	@Test
	void testSimpleDivide() {
		assertEquals(4, rp.evaluate(new String[] {"12","3","/"}));
	}



}

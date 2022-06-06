package com.maksymchuk.prep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Map;

import org.junit.jupiter.api.Test;

class RationsPlusMinusZeroTest {

	RationsPlusMinusZero rpmz = new RationsPlusMinusZero();
	private int expectedRationsSIze = 3; 
	
	@Test
	void testNull() {
		Map<Integer, Double> rations = rpmz.rations(null);
		assertEquals(expectedRationsSIze, rations.size(), 
				"Rations size should always be " + expectedRationsSIze);
		
		assertEquals(rations.get(Integer.valueOf(-1)), Double.valueOf(0));
		assertEquals(rations.get(Integer.valueOf(0)), Double.valueOf(0));
		assertEquals(rations.get(Integer.valueOf(1)), Double.valueOf(0));

	}
	
	@Test
	void testEmpty() {
		fail("Not yet implemented");
	}

	@Test
	void testAllPos() throws Exception {
		
	}
	
	@Test
	void testAllNeg() throws Exception {
		
	}
	
	@Test
	void testAllZero() throws Exception {
		
	}
	
	
	@Test
	void testAllExist() throws Exception {
		
	}
	
}

package com.maksymchuk.cci;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoinChangeTest {

	@Test
	void testOnes() {
		CoinChange ct = new CoinChange(new int[] {1,5,10,25});
		assertEquals(1, ct.minCoinsStandard(1));
		assertEquals(1, ct.minCoinsStandard(5));
		assertEquals(1, ct.minCoinsStandard(10));
		assertEquals(1, ct.minCoinsStandard(25));		
	}
	
	@Test
	void testNoCoinsPossible() {
		CoinChange ct = new CoinChange(new int[] {5,10,25});
		assertEquals(-1, ct.minCoinsStandard(3));		
		assertEquals(-1, ct.minCoinsStandard(6));		

	}
	
	@Test
	void testCombinations() {
		CoinChange ct = new CoinChange(new int[] {1,5,10,25});
		assertEquals(2, ct.minCoinsStandard(2));
		assertEquals(3, ct.minCoinsStandard(7));
		assertEquals(5, ct.minCoinsStandard(42));
		assertEquals(2, ct.minCoinsStandard(50));		
	}
	

}

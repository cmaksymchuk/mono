package com.maksymchuk.stockspanner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StockSpannerTest {

	@Test
	void testNextOne() {
		test(new int[] {100}, 1);		
	}
	
	@Test
	void testNextTwoSame() {
		test(new int[] {100,100}, 2);		
	}
	
	@Test
	void testNextTwoGreater() {
		test(new int[] {100,101}, 2);		
	}
	
	@Test
	void testNextTwoLess() {
		test(new int[] {100,99}, 1);		
	}

	
	
	
	@Test
	void testNextThreeSame() {
		test(new int[] {100,100,100}, 3);		
	}
	
	@Test
	void testNextThreeGreater() {
		test(new int[] {100,101,102}, 3);		
	}
	
	@Test
	void testNextThreeLess() {
		test(new int[] {100,101,100}, 1);		
	}
	
	@Test
	void testNextThreeLastTwoGreater() {
		test(new int[] {200,101,102},2);		
	}
	
	
	
	
	void test(int[] stockPrices, int expectedSpan)
	{
		StockSpanner stockSpanner = new StockSpanner();
		int span = 0;
		for (int i = 0 ; i < stockPrices.length; i++) 
		{
			span = stockSpanner.next(stockPrices[i]);
		}
		assertEquals(expectedSpan, Integer.valueOf(span));
	}

}

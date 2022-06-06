package com.maksymchuk.prep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StockPriceTest {

	@Test
	void testPricesNormal() {
		int[] prices = new int[] {7,1,5,3,6,4};
		StockPrice sp = new StockPrice();
		assertEquals(5, sp.maxProfit(prices));
	}
	
	@Test
	void testPricesDescendingZero() {
		int[] prices = new int[] {7,6,4,3,1};
		StockPrice sp = new StockPrice();
		assertEquals(0, sp.maxProfit(prices));
	}
	
	
	@Test
	void testPricesNormal2() {
		int[] prices = new int[] {7,1,5,3,6,4};
		StockPrice sp = new StockPrice();
		assertEquals(5, sp.maxProfit(prices));
	}
	
	@Test
	void testPricesDescendingZero2() {
		int[] prices = new int[] {7,6,4,3,1};
		StockPrice sp = new StockPrice();
		assertEquals(0, sp.maxProfit(prices));
	}
	
	@Test
	void testRecursion() {
		int[] prices = new int[] {3,6,4};
		StockPrice sp = new StockPrice();
		sp.maxProfit3(prices);
	}
	
	@Test
	void testMaxProfit4() {
		int[] prices = new int[] {7,1,5,3,6,4};
		StockPrice sp = new StockPrice();
		assertEquals(5, sp.maxProfit4(prices));
	}
	
	

}

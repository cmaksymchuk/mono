package com.maksymchuk.prep;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GameOfLifeFunctionlTest {
	
	@Test
	public void testFewerThanTwoLiveNeighborsDies()
	{
		// initial state is 1, less than two neighbors dies
		testNextVal(1, 0, 0);
		testNextVal(1, 1, 0);
	}

	@Test
	public void testTwoOrThreeLiveNeighborsLives()
	{
		// initial state is 1, two or three neighbors
		testNextVal(1, 2, 1);
		testNextVal(1, 3, 1);
	}
	
	@Test
	public void moreThanThreeLiveNeighborsDies()
	{
		// initial state is 1, more than three neighbors
		testNextVal(1, 4, 0);
		testNextVal(1, 5, 0);
	}
	
	@Test
	public void exactlyThreeLiveNeighborsTurnsLiving()
	{
		// initial state is 0, exactly three neighbors
		testNextVal(0, 3, 1);
		
		// initial state is 0, not exactly three neighbors
		testNextVal(0, 0, 0);
		testNextVal(0, 1, 0);
		testNextVal(0, 2, 0);
		testNextVal(0, 4, 0);
	}

	void testNextVal(int currentValue, int neighbors, int expectedValue) {		
		int nextVal = new GameOfLifeFunction().apply(currentValue, neighbors);
		assertEquals(expectedValue, nextVal);		
	}
}

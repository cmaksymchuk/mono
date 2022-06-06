package com.maksymchuk.prep;

import org.junit.jupiter.api.Test;

class GameOfLifeTest {

	@Test
	void test() throws InterruptedException {
		int[][] board = 
			{ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
	            { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
	        };
		GameOfLifeBoard golBoard = new GameOfLifeBoard(board);
		for (int i = 0; i < 10; i++)
		{
			golBoard.print();
			System.out.println();
			golBoard = golBoard.nextBoard();
			Thread.sleep(1000);
		}
		golBoard.print();
	}

//	Any live cell with fewer than two live neighbors dies as if caused by under-population.
//	Any live cell with two or three live neighbors lives on to the next generation.
//	Any live cell with more than three live neighbors dies, as if by over-population.
//	Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

}

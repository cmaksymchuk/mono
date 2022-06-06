package com.maksymchuk.prep;

import java.util.Arrays;
import java.util.function.BiFunction;

public class GameOfLifeBoard {
	
	private int[][] board;
	
	BiFunction<Integer, Integer, Integer> gameOfLifeFunction = new GameOfLifeFunction();

	public GameOfLifeBoard(int[][] board) {		
		this.board = board;
	}
	

	public Integer neighbors(int row, int col) {
//	    	boolean upPossible = y > 0;
//	    	boolean leftPossible = x > 0;
//	    	boolean rightPossible = board.length > 0 && x < board[0].length - 2;
//	    	boolean bottomPossible = y < board.length - 2;

		int topLeft = board[row - 1][col - 1];
		int top = board[row - 1][col];
		int topRight = board[row - 1][col + 1];
		int left = board[row][col - 1];
		int right = board[row][col + 1];
		int bottomLeft = board[row + 1][col - 1];
		int bottom = board[row + 1][col];
		int bottomRight = board[row + 1][col + 1];
		
		return Integer.valueOf(topLeft+ top+ topRight+ left+ right+ bottomLeft+ bottom+ bottomRight);

//		int[] neighbors = new int[] { topLeft, top, topRight, left, right, bottomLeft, bottom, bottomRight };

//		return new Long(Arrays.stream(neighbors).filter(i -> i == 1).count()).intValue();
	}
	
	public GameOfLifeBoard nextBoard()
	{
		int[][] newBoard = new int[board.length][board[0].length];

		if (board.length > 2 || (board.length > 0 && board[0].length > 2)) {
			for (int row = 1; row < board.length - 1; row ++)
			{
				for (int col = 1; col < board[row].length - 1; col++) {
					//GameOfLifeCell cell = new GameOfLifeCell(col, row, board[row][col]);
					int val = board[row][col];
					newBoard[row][col] = gameOfLifeFunction.apply(val,  neighbors(row, col));
				}
			}
		}
		return new GameOfLifeBoard(newBoard);
	}

	
	public void print()
	{
		for (int row = 0; row < board.length; row ++)
		{
			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] == 0 ? "." : "*");
			}
			System.out.println();
		}
	}

}

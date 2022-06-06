package com.maksymchuk.shopify;

import org.junit.jupiter.api.Test;

public class ChessGraphTest {
	
	public String[][] board = new String[][]
	{
		{ "A", "B", "C", " ", "E" },
		{ " ", "G", "H", "I", "J" },
		{ "K", "L", "M", "N", "O" },
		{ "P", "Q", "R", "S", "T" },
		{ "U", "V", " ", " ", "Y" }
	};
	
	ChessGraph chessGraph = new ChessGraph();
	
	@Test
	public void testAddBoard() {
		System.out.println(chessGraph.addBoard(board));
	}

}

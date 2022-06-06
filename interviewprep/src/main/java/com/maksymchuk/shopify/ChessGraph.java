package com.maksymchuk.shopify;

import java.util.HashSet;
import java.util.Set;

public class ChessGraph {

	
	public int addBoard(String[][] board)
	{
		int num = 0;
		for (int rowIndex = 0; rowIndex < board.length; rowIndex++)
		{
			for (int colIndex = 0; colIndex < board[rowIndex].length ; colIndex++)
			{
				ChessNode cn = new ChessNode(rowIndex, colIndex, board);
				 new HashSet<String>();
				 Set<String> nodeWordSet = cn.traverse("");
				num += nodeWordSet.size();
				System.out.print(cn.getLetter());
			}
			System.out.println();			
		}
		return num;
	}

}

package com.maksymchuk.shopify;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ChessNode {
	private String letter;
	private int rowIndex, colIndex;
	private String[][] board;

	private List<ChessNode> nodes;
	
	public String getLetter() {
		return letter;
	}

	public List<ChessNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<ChessNode> nodes) {
		this.nodes = nodes;
	}

	public ChessNode(int rowIndex, int colIndex, String[][] board)
	{
		this.letter = board[rowIndex][colIndex];
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
		this.board = board;
	}
	
	public List<ChessNode> getMovableNodes()
	{
		// up 2
		List<ChessNode> possible = new ArrayList<ChessNode>();
		possible.add(getNode(-2,-1, board));
		possible.add(getNode(-2,1, board));
		
		// left 2
		possible.add(getNode(-1,-2, board));
		possible.add(getNode(1,-2, board));
		
		// down 2
		possible.add(getNode(2,-1, board));
		possible.add(getNode(2,1, board));
		
		// right 2
		possible.add(getNode(1,2, board));
		possible.add(getNode(-1,2, board));

		// filter out nulls
		return possible.stream().filter(p -> p != null).collect(Collectors.toList());
	}
	
	public ChessNode getNode(int moveRow, int moveCol, String[][] board)
	{
		int newRowIndex = this.rowIndex + moveRow;
		int newColIndex = this.colIndex + moveCol;
		if (newRowIndex < 0 || newRowIndex > (board.length-1) || newColIndex < 0 || newColIndex > (board[0].length-1))
		{
			return null;
		}
		return new ChessNode(newRowIndex, newColIndex, board);
	}
	
	@Override
	public String toString()
	{
		return this.rowIndex + " " + this.colIndex;
		
	}
	
	public boolean equals(ChessNode otherNode)
	{
		if (otherNode == null)
		{
			return false;
		}
		else if (otherNode == this)
		{
			return true;
		}
		else
		{
			return otherNode.colIndex == colIndex 
					&& otherNode.rowIndex == rowIndex;
		}		
	}
	
	@Override
	public int hashCode() {
	    return rowIndex + colIndex;
	}

	public Set<String> traverse(String currentString) {
		Set<String> wordsAccumulated = new HashSet<String>();
				
		if (!letter.equals(" ") && !currentString.contains(letter))
		{
			String newString = currentString + this.letter;
			if (isValid(newString))
			{
				wordsAccumulated.add(newString);
			}
			for (ChessNode node : this.getMovableNodes())
			{
				wordsAccumulated.addAll(node.traverse(newString));				
			}
		}
		return wordsAccumulated;
	}	
	
	public boolean isValid(String word)
	{
		int countVowels = word.replaceAll("[^aeiouAEIOU]","").length();
		int countSpaces = word.replaceAll("[^\\s]","").length();
		return countVowels <= 2 && countSpaces == 0;
	}
}

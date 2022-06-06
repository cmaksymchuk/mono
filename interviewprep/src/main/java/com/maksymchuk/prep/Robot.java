package com.maksymchuk.prep;

public class Robot {

	public class Coords {
		int x;
		int y;

		public Coords(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	int[][] grid;
	Coords coords = new Coords(0,0);

	public String toString() 
	{
		return "(" + coords.x + "," + coords.y + ")";
	}
	public Robot(int[][] grid) {
		this.grid = grid;
	}

	public void moveLeft()
	{
		if (coords.x > 0)
		{
			coords.x--;
		}
	}


	public void moveRight()
	{
		if (coords.x < grid[0].length - 1)
		{
			coords.x++;
		}
	}
	
	public void moveDown()
	{
		if (coords.y < grid.length - 1)
		{
			coords.y++;
		}
	}

	public void moveUp() {
		if (coords.y > 0)
		{
			coords.y--;
		}
	}
}

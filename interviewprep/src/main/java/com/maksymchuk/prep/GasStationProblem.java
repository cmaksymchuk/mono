package com.maksymchuk.prep;
import java.util.Arrays;

public class GasStationProblem {
	
	
	public void findIndex(int[] gas, int[] cost)
	{
		int[] difference = new int[gas.length];
		for (int i = 0; i < gas.length; i++)
		{
			difference[i] = gas[i] - cost[i];
		}
		for (int i = 0; i < difference.length; i++)
		{
			int failedAtIndex = failedAtIndex(difference, i);
			System.out.println(i + " " + failedAtIndex);
			if (failedAtIndex == -1)
			{
				System.out.println(i + " Success");
				break;
			}
			
		}
		
		
//		System.out.println("" + 0 + " " + traverse(difference, 9));

		
		System.out.println(Arrays.toString(difference));
	}
	
	public int failedAtIndex(int[] difference, int startIndex)
	{
		int running = 0;
//		int steps = 0;
		// we didn't fail at an index yet
		int rtrn = -1;
		
		for (int i = startIndex; i < difference.length + startIndex ; i++)
		{
			int index = i % difference.length;
//			System.out.println(index);
			
			running += difference[index];
//			
//
			if (running < 0)
			{
				rtrn = index;
				break;
			}
			if (index == startIndex -1)
			{
				// we are back at the start, return -1 (success)
				break;
			}			
		}
		return rtrn;
	}
}

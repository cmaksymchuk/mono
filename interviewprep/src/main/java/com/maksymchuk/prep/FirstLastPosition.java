package com.maksymchuk.prep;
import java.util.List;

/*
 * Given a sorted array of Integers arr
 * and an integer target, find the index of the first and last position 
 * of target in arr.  If target can't be found in arr, return [-1,-1]
 * 
 */
public class FirstLastPosition {
	public int[] firstLast(List<Integer> arr, Integer target)
	{
		int first = -1;
		int last = -1;
		for (int index = 0 ; index < arr.size(); index++)
		{
			Integer val = arr.get(index);
			if (val > target)
			{
				break;
			}
			if (val.equals(target))
			{
				if (first == -1)
				{
					first = index;
				}
				last = index;
			}
			
		}
		return new int[] {first, last};
	}
}

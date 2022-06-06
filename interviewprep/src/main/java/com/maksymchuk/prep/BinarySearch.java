package com.maksymchuk.prep;
public class BinarySearch {
	
	public static void main(String...value)
	{
		System.out.println(7/2);
	}
	
	public int index(int[] list, int value) 
	{
		int start = 0;
		int end = list.length - 1;
		
		return index(list, start, end, value);
	}
	
	private int index(int[] list, int start, int end, Integer value)
	{
		if (list[start] > value || list[end] < value)
		{
			return -1;
		}
		// if size = 7, end would be index 6, the midpoint would be the 4th position or index of 3
		// if size = 6, end would be index 5, 5the midpoi
		int mid = (start + end) / 2;
		
		int valueAtMid = list[mid];
		
		// value at mid is correct, return it
		if (valueAtMid == value)
		{
			 return mid;			
		}
		
		// value at mid is not correct, and start == end so the value does not exist
		if (start == end)
		{
			return -1;			
		}
		// value at mid is either less than or greater than mid
		else		
		{			
			// value at mid > i, the value must be between start and mid
			if (valueAtMid > value)
			{
				return index(list, start, mid-1, value);				
			}
			if (valueAtMid < value)
			{
				return index(list, mid + 1, end, value);				
			}	
		}
		throw new RuntimeException("This method should never reach the end");
		
	}

}

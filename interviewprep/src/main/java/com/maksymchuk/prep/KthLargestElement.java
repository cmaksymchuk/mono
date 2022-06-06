package com.maksymchuk.prep;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * given an 
 * - array of integers arr
 * - an integer k
 * find
 * - the kth largest element
 */
public class KthLargestElement {
	
	public int kth(int[] arr, int k)
	{		
		Arrays.sort(arr);
		return arr[arr.length - k];
	}
}
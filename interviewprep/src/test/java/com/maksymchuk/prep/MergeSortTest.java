package com.maksymchuk.prep;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MergeSortTest {
	
	@Test
	public void test()
	{
		MergeSort mergeSort = new MergeSort();
		System.out.println(Arrays.toString(mergeSort.mergeSort(new int[] { 1,6,3,6,8,0,4,57,89,4})));
		
	
	}

}

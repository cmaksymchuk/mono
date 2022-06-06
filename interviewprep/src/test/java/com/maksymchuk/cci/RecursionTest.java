package com.maksymchuk.cci;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecursionTest {

	Recursion r = new Recursion();

	@Test
	void test() {
		System.out.println(r.trippleStep(4));
	}

	@Test
	void testRobotOnAGrid() {
		assertEquals(3, r.robotOnGrid(3, 2));
		System.out.println("");
		assertEquals(28, r.robotOnGrid(3, 7));
	}
	

	@Test
	void testMagicIndex() {
		int[] arr;
		
		arr = null;
		assertEquals(-1, r.magicIndex(arr));
				
		// empty array
		arr = new int[]{  };
		assertEquals(-1, r.magicIndex(arr));
		
		// array of size 1 - matching index
		arr = new int[]{ 0 };
		assertEquals(0, r.magicIndex(arr));

		// array of size 1 - non matching index
		arr = new int[]{ 1 };
		assertEquals(-1, r.magicIndex(arr));
		
		// array of size 1 - non matching index
		arr = new int[]{ 1 };
		assertEquals(-1, r.magicIndex(arr));

		// 4 is magic index
		arr = new int[]{ -1, 0, 1, 2, 4, 10 };
		assertEquals(4, r.magicIndex(arr));
		
		// array, magic index doesn't exist
		arr = new int[]{ -1, 0, 1, 2, 7, 10 };
		assertEquals(-1, r.magicIndex(arr));

		// magic index is first value
		arr = new int[]{ 0, 2, 3, 7, 10 };
		assertEquals(0, r.magicIndex(arr));

		// magic index is last value
		arr = new int[]{ -1, 0, 1, 2, 4 };
		assertEquals(4, r.magicIndex(arr));

	}
	
	@Test
	public void testSubsetOfSets()
	{
		int[] set = new int[] {1,2,3};
		r.subsetOfSets(set);
		
		set = new int[] {1,2,3,4};
		r.subsetOfSets(set);
	}
	
	
	
	@Test
	public void testRecursiveMultiply()
	{
		
		assertEquals(6, r.recursiveMultiply(2, 3));

		assertEquals(80, r.recursiveMultiply(8, 10));

	}
	
	
	@Test
	public void testPermutationsWithoutDupes()
	{		
		System.out.println(r.permutationsWithoutDupes("abc"));
	}
	
	@Test
	public void sumAllPosValues()
	{
		assertEquals(6, r.sumAllPositiveValuesUpToN(3));
		assertEquals(10, r.sumAllPositiveValuesUpToN(4));
	}

	@Test
	public void subsetOfSetsIterative()
	{
		System.out.println(r.subsetOfSetsIterative(new int[] {1,2,3}));

	}
	@Test
	public void testNumPathsOnGrid() {
		assertEquals(3, r.numPathsNmGrid(3, 2));
		System.out.println("");
		assertEquals(28, r.numPathsNmGrid(3, 7));
	}
}

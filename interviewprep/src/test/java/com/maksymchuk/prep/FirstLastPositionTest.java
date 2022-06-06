package com.maksymchuk.prep;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class FirstLastPositionTest {

	FirstLastPosition firstLastPosition = new FirstLastPosition();
	
	@Test
	void testFound1() {
		List<Integer> arr = list(1,2,3,4,5);
		int[] rtrn = firstLastPosition.firstLast(arr, Integer.valueOf(1));
		
		assertEquals(0, rtrn[0]);
		assertEquals(0, rtrn[1]);
	}
	
	@Test
	void testFound2() {
		List<Integer> arr = list(1,2,2,2,3,4,5);
		int[] rtrn = firstLastPosition.firstLast(arr, Integer.valueOf(2));
		
		assertEquals(1, rtrn[0]);
		assertEquals(3, rtrn[1]);
	}
	
	@Test
	void testNotFound() {
		List<Integer> arr = list(1,2,3,4,5);
		int[] rtrn = firstLastPosition.firstLast(arr, Integer.valueOf(0));
		
		assertEquals(-1, rtrn[0]);
		assertEquals(-1, rtrn[1]);
	}
	
	private List<Integer> list(int... ints)
	{
		List<Integer> list = new ArrayList<Integer>();
		for (int i : ints)
		{
			list.add(Integer.valueOf(i));
		}
		return list;
	}

}

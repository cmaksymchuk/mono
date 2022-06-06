package com.maksymchuk.prep;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

	BinarySearch bs = new BinarySearch();
	
	@Test
	void test() {
		assertTrue(bs.index(new int[] {1,3,5,7,9,11,13,15}, 1) == 0);
		assertTrue(bs.index(new int[] {1,3,5,7,9,11,13,15}, 3) == 1);
		assertTrue(bs.index(new int[] {1,3,5,7,9,11,13,15}, 5) == 2);
		assertTrue(bs.index(new int[] {1,3,5,7,9,11,13,15}, 7) == 3);
		assertTrue(bs.index(new int[] {1,3,5,7,9,11,13,15}, 9) == 4);
		assertTrue(bs.index(new int[] {1,3,5,7,9,11,13,15}, 15) == 7);
		
		
		assertTrue(bs.index(new int[] {1,3,5,7,9,11,13,15}, 0) == -1);
		assertTrue(bs.index(new int[] {1,3,5,7,9,11,13,15}, 16) == -1);
		assertTrue(bs.index(new int[] {1,3,5,7,9,11,13,15}, 2) == -1);
		assertTrue(bs.index(new int[] {1,3,5,7,9,11,13,15}, 12) == -1);
		
		
	}

}

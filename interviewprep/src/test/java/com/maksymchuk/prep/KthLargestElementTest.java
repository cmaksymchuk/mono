package com.maksymchuk.prep;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KthLargestElementTest {

	@Test
	void test() {
		KthLargestElement kle = new KthLargestElement();
		assertTrue(99 == kle.kth(new int[] {1, 3, 5, 7, 9, 11, 13, 15, 99, 77, 23, 12}, 1));
		assertTrue(77 == kle.kth(new int[] {1, 3, 5, 7, 9, 11, 13, 15, 99, 77, 23, 12}, 2));
		assertTrue(23 == kle.kth(new int[] {1, 3, 5, 7, 9, 11, 13, 15, 99, 77, 23, 12}, 3));
	}

}

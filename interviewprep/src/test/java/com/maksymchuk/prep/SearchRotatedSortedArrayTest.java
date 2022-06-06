package com.maksymchuk.prep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SearchRotatedSortedArrayTest {
	SearchRotatedSortedArray srsa = new SearchRotatedSortedArray();

	@Test
	void test1() {
		assertEquals(4, srsa.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
	}

	@Test
	void test2() {
		assertEquals(-1, srsa.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
	}

	@Test
	void test3() {
		assertEquals(-1, srsa.search(new int[] { 1 }, 0));
	}
	
	
	@Test
	void test5() {
		assertEquals(7, srsa.search(new int[] { 4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2 }, 11));
	}
}

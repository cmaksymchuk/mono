package com.maksymchuk.prep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class MergeIntervalsTest {

	@Test
	void test1() {
		int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}};
		MergeIntervals mi = new MergeIntervals();
		System.out.println(Arrays.deepToString(intervals));
		intervals = mi.merge(intervals);
		System.out.println(Arrays.deepToString(intervals));
	}
	
	@Test
	void test2() {
		int[][] intervals = new int[][] {{1,3},{4,6},{7,10},{0,10},{11,99}};
		MergeIntervals mi = new MergeIntervals();
		System.out.println(Arrays.deepToString(intervals));
		intervals = mi.merge(intervals);
		System.out.println(Arrays.deepToString(intervals));
	}

}

package com.maksymchuk.prep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ZeroMoverTest {

	ZeroMover zeroMover = new ZeroMover();
	

	@Test
	void testMoveZerosAlreadyMoved() {
		int[] originalNums = {1,34,6,0,0,0,0};
		int[] expectedNums = {1,34,6,0,0,0,0};
		
		
		zeroMover.moveZeroes(originalNums);
		assertTrue(Arrays.equals(expectedNums, originalNums));		
	}
	
	@Test
	void testMoveZerosManyZeros() {
		int[] originalNums = {0,0,0,0};
		int[] expectedNums = {0,0,0,0};
		
		
		zeroMover.moveZeroes(originalNums);
		assertTrue(Arrays.equals(expectedNums, originalNums));		
	}
	
	@Test
	void testMoveZerosOnlyOneZero() {
		int[] originalNums = {0};
		int[] expectedNums = {0};
		
		
		zeroMover.moveZeroes(originalNums);
		assertTrue(Arrays.equals(expectedNums, originalNums));		
	}
	
	@Test
	void testMoveZerosNoZerosShort() {
		int[] originalNums = {1};
		int[] expectedNums = {1};
		
		
		zeroMover.moveZeroes(originalNums);
		assertTrue(Arrays.equals(expectedNums, originalNums));		
	}
	
	
	@Test
	void testMoveZerosNoZerosLong() {
		int[] originalNums = {1,2,3};
		int[] expectedNums = {1,2,3};
		
		
		zeroMover.moveZeroes(originalNums);
		assertTrue(Arrays.equals(expectedNums, originalNums));		
	}
	
	
	
	@Test
	void testMoveZerosNull() {
		int[] originalNums = null;
		int[] expectedNums = null;
		
		
		zeroMover.moveZeroes(originalNums);
		assertTrue(Arrays.equals(expectedNums, originalNums));		
	}
	
	
	@Test
	void testMoveZerosEmpty() {
		int[] originalNums = new int[] {};
		int[] expectedNums = new int[] {};
		
		
		zeroMover.moveZeroes(originalNums);
		assertTrue(Arrays.equals(expectedNums, originalNums));		
	}
	
	@Test
	void testMoveZeros() {
		int[] originalNums = new int[] {0,1,0,3,12};
		int[] expectedNums = new int[] {1,3,12,0,0};
		
		
		zeroMover.moveZeroes(originalNums);
		assertTrue(Arrays.equals(expectedNums, originalNums));		
	}

}

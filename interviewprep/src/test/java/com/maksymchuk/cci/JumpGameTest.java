package com.maksymchuk.cci;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JumpGameTest {

	@Test
	void testPossible() {
		JumpGame jumpGame = new JumpGame();
		int[] jumps = new int[] {2,3,1,1,4};
		assertTrue(jumpGame.jump(jumps));		
	}
	
	@Test
	void testNotPossible1() throws Exception {
		JumpGame jumpGame = new JumpGame();
		int[] jumps = new int[] {3,2,1,0,4};
		assertFalse(jumpGame.jump(jumps));	
	}
	
	@Test
	void testZeroLastValue() throws Exception {
		JumpGame jumpGame = new JumpGame();
		int[] jumps = new int[] {3,2,2,1,0};
		assertTrue(jumpGame.jump(jumps));	
	}
	
	@Test
	void testZeroFirstValue() throws Exception {
		JumpGame jumpGame = new JumpGame();
		int[] jumps = new int[] {0,2,2,1,1};
		assertFalse(jumpGame.jump(jumps));	
	}
	
	@Test
	void testTwoZerosAtEnd() throws Exception {
		JumpGame jumpGame = new JumpGame();
		int[] jumps = new int[] {2,0,0};
		assertTrue(jumpGame.jump(jumps));	
	}

	@Test
	void testLongString() throws Exception {
		JumpGame jumpGame = new JumpGame();
		int[] jumps = new int[] {1,0,0,1,1,2,2,0,2,2};
		assertTrue(jumpGame.jump(jumps));	
	}


}

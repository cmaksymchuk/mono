package com.maksymchuk.complexity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BigOTest {
	BigO bigO = new BigO();
	
	@Test
	void test() {
		System.out.println(bigO.logFuncRecursive(8));
		System.out.println(bigO.logFuncIterative(8));
		System.out.println(bigO.nLogN(8));
	}

}

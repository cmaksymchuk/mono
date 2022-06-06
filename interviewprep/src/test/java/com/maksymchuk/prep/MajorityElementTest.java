package com.maksymchuk.prep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MajorityElementTest {

	MajorityElement me = new MajorityElement();

	@Test
	void test() {
		assertEquals(2, me.majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
	}

	@Test
	void testNull() throws Exception {
		assertEquals(1, me.majorityElement(new int[] { 1 }));
	}
}

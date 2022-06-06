package com.maksymchuk.prep;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ClosedLoopTest {
	
	ClosedLoops cl = new ClosedLoops();
	
	@Test
	public void testNull()
	{
		assertTrue(0 == cl.test(null));
		assertTrue(0 == cl.test(""));
		assertTrue(0 == cl.test("abcdefg"));
		assertTrue(1 == cl.test("0"));
		assertTrue(5 == cl.test("1234567890"));
		assertTrue(4 == cl.test("88"));



	}

}

package com.maksymchuk.shopify;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class StringMoverTest {

	CommandParser mover = new CommandParser();
	
	@Test
	void testGetOperationsEmptyString() {
		List<String> operations = mover.getOperations("");
		assertEquals(0, operations.size());
	}
	
	@Test
	void testGetOperationsNull() {
		List<String> operations = mover.getOperations(null);
		assertEquals(0, operations.size());
	}
	
	@Test
	void testGetOperationsSingle() {
		testGetOperationsSingle("F1", 1, "F1");
		testGetOperationsSingle("F234", 1, "F234");
		testGetOperationsSingle("B2", 1, "B2");
		testGetOperationsSingle("B53", 1, "B53");
		testGetOperationsSingle("Rx", 1, "Rx");
		testGetOperationsSingle("Ry", 1, "Ry");		
	}
	
	@Test
	void testGetOperationsMultiple() {
		testGetOperationsSingle("F1B1", 2, "F1","B1");
		testGetOperationsSingle("F1B1Rx", 3, "F1","B1","Rx");
	}
	
	@Test
	public void parse()
	{
		System.out.println(mover.parse("abcdefghijklmn", "F2B1F5Rw"));
	}
	private void testGetOperationsSingle(String input, int expectedSize, String... elements) {
		List<String> operations = mover.getOperations(input);
		assertEquals(expectedSize, operations.size());
		for (int i = 0 ; i < elements.length; i++)
		{
			assertEquals(elements[i], operations.get(i));
		}
	}

}

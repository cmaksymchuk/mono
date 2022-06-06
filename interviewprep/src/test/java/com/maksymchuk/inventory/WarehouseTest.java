package com.maksymchuk.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WarehouseTest {
	
	// https://mkyong.com/unittest/junit-how-to-test-a-map/
	// hamcrest matchers

	@Test
	void testConstructor() {
		Warehouse warehouse = new Warehouse("name");
		assertEquals("name", warehouse.getName());
	}
	
	@Test
	void testAdd() {
		Warehouse warehouse = new Warehouse("name");
		warehouse.add("name1", 1);
		warehouse.add("name2", 2);
		
		assertEquals(2, warehouse.getInventoryAmounts().size());
	}
	
	@Test
	void testCanFill() {
		Warehouse warehouse = new Warehouse("name");
		warehouse.add("name1", 1);
		warehouse.add("name2", 2);
		
		
		
        //assertThat(warehouse, is(expected));

		
	}
}

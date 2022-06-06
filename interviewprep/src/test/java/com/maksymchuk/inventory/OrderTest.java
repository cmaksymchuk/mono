package com.maksymchuk.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OrderTest {

	@Test
	void testAdd() {
		Order order = new Order();
		order.add("pn", 1);
		assertEquals(1, order.getOrderItems().size());
		assertEquals(1, order.getOrderItems().get("pn"));
		
	}

}

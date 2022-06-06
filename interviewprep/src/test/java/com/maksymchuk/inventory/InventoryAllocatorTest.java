package com.maksymchuk.inventory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Map;

import org.junit.jupiter.api.Test;

class InventoryAllocatorTest {

	@Test
	void testFulfillOrderHappyPath() {
		Order order = order("apple", "5");
		Warehouse warehouse = warehouse("w1", "apple", "5");
		Map<String, Map<String, Integer>> rtrn = new InventoryAllocator().fulfillOrder(order, Arrays.asList(warehouse));
		assertEquals(1, rtrn.size());
		
		Map<String, Integer> allocation = rtrn.get("w1");
		assertThat(allocation, is(order.getOrderItems()));
	}
	
	@Test
	void testFulfillOrderTwoWarehouses() {
		Order order = order("apple", "5");
		Warehouse warehouse1 = warehouse("w1", "apple", "2");
		Warehouse warehouse2 = warehouse("w2", "apple", "3");
		Map<String, Map<String, Integer>> rtrn = new InventoryAllocator().fulfillOrder(order, Arrays.asList(warehouse1, warehouse2));
		assertEquals(2, rtrn.size());
		
		Map<String, Integer> shipment1 = rtrn.get("w1");
		assertThat(shipment1, is(warehouse1.getInventoryAmounts()));
		
		Map<String, Integer> shipment2 = rtrn.get("w2");
		assertThat(shipment2, is(warehouse2.getInventoryAmounts()));
	}
	
	
	private Order order(String... items)
	{
		Order order = new Order();
		for (int i = 0; i < items.length; i = i+2) {
			order.add(items[i], Integer.valueOf(items[i+1]));
		}
		return order;		
	}
	
	private Warehouse warehouse(String name, String... items)
	{
		Warehouse warehouse = new Warehouse(name);
		for (int i = 0; i < items.length; i = i+2) {
			warehouse.add(items[i], Integer.valueOf(items[i+1]));
		}
		return warehouse;		
	}

}

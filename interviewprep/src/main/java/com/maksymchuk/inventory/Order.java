package com.maksymchuk.inventory;

import java.util.HashMap;
import java.util.Map;

public class Order {
	private Map<String, Integer> orderItems = new HashMap<String, Integer>();

	public void add(String productName, Integer inventoryAmount)
	{
		orderItems.put(productName, inventoryAmount);
	}

	public Map<String, Integer> getOrderItems() {
		return orderItems;
	}
}

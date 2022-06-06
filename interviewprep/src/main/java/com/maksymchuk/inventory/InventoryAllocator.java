package com.maksymchuk.inventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// https://leetcode.com/discuss/interview-question/810114/cisco-online-assessment-question

public class InventoryAllocator {
	
	public Map<String, Map<String, Integer>> fulfillOrder(Order order, List<Warehouse> warehouses)
	{
		Map<String, Map<String, Integer>> shipments = new HashMap<String, Map<String, Integer>> ();
		
		// first check to see if any single warehouse can fulfill the entire order
		for (Entry<String, Integer> orderItem : order.getOrderItems().entrySet())
		{		
			String itemName = orderItem.getKey();
			Integer quantityRemaining = orderItem.getValue();
			
			for (Warehouse warehouse : warehouses)
			{	
				if (warehouse.getInventoryAmounts().containsKey(itemName))
				{
					int originalQuantityRemaining = quantityRemaining;
					quantityRemaining = warehouse.fulfill(itemName, quantityRemaining);
					shipments.putIfAbsent(warehouse.getName(), new HashMap<String, Integer>());
					shipments.get(warehouse.getName()).put(itemName, originalQuantityRemaining - quantityRemaining);
				}
			}
			if (quantityRemaining > 0)
			{
				return new HashMap<String, Map<String, Integer>> ();
			}
		}
	
		
		return shipments;
	}
	
	

}

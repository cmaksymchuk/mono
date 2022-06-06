package com.maksymchuk.inventory;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
	
	private Map<String, Integer> inventoryAmounts = new HashMap<String, Integer>();
	private String name;
	
	public Warehouse(String name)
	{
		this.name = name;
	}
	
	public void add(String productName, Integer inventoryAmount)
	{
		inventoryAmounts.put(productName, inventoryAmount);
	}

	public Map<String, Integer> getInventoryAmounts() {
		return inventoryAmounts;
	}

	public String getName() {
		return name;
	}
	
	/**
	 * Return the number of items remaining to be shipped after being
	 * removed from this warehouse
	 * @param itemName
	 * @param orderQuantity
	 * @return
	 */
	public Integer fulfill(String itemName, Integer orderQuantity)
	{
		if (inventoryAmounts.containsKey(itemName))
		{
			int inventoryQuantity = inventoryAmounts.get(itemName);
			if (inventoryQuantity > orderQuantity)
			{
				return 0;
			}
			else
			{
				return orderQuantity - inventoryQuantity;
			}
		}
		return orderQuantity;
	}
	

}

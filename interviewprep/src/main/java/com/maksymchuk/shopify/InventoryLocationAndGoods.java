package com.maksymchuk.shopify;

import java.util.HashMap;
import java.util.Map;

public class InventoryLocationAndGoods {

	static class Item {
		String name;

		public Item(String name) {
			this.name = name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Item other = (Item) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}		
	}

	static class Location {
		Map<Item, Integer> inventory = new HashMap<Item, Integer>();
		
		public boolean canFill(Order order)
		{
			return order.items.entrySet()
					.stream().allMatch(orderItem -> inventory.containsKey(orderItem.getKey()) && inventory.get(orderItem.getKey()) >= orderItem.getValue());
		}
	}
	
	static class Order {
		Map<Item, Integer> items = new HashMap<Item, Integer>();
		public void add(Item item, Integer quantity)
		{
			if (!items.containsKey(item))
			{
				items.put(item, quantity);
			}
			else
			{
				Integer itemsQuantity = items.get(item);
				itemsQuantity += quantity;
				items.put(item, itemsQuantity);
			}
		}
	}

}

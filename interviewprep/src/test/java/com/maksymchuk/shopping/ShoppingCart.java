package com.maksymchuk.shopping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Step 1: Shopping cart
 * 
 * You are building a checkout system for a shop which only sells apples and
 * oranges. Apples cost 60p and oranges cost 25p. Build a checkout system which
 * takes a list of items scanned at the till and outputs the total cost For
 * example: [ Apple, Apple, Orange, Apple ] => £2.05 Make reasonable assumptions
 * about the inputs to your solution; for example, many candidates take a list
 * of strings as input
 * 
 * https://codereview.stackexchange.com/questions/161134/shopping-cart-design-interview-task
 */

public class ShoppingCart implements IShoppingCart {

	private List<Item> scannedItems = new ArrayList<Item>();

	@Override
	public List<Item> getScannedItems() {
		return scannedItems;
	}


	@Override
	public void scan(Item... items) {
		scannedItems = Arrays.asList(items);
	}

	@Override
	public double checkout(Discount... discounts) {
		double total = scannedItems.stream().collect(Collectors.summingDouble(Item::getPrice));
		for (Discount d : discounts)
		{
			total -= d.apply(this);
		}
		return total;
	}

}

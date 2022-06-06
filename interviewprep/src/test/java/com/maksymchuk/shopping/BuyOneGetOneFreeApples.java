package com.maksymchuk.shopping;

import java.util.List;
import java.util.stream.Collectors;

public class BuyOneGetOneFreeApples implements Discount {

	@Override
	public double apply(IShoppingCart shoppingCart) {
		List<Item> apples = shoppingCart.getScannedItems().stream()
				.filter(item -> "apple".equals(item.getName()))
				.collect(Collectors.toList());
		
		double applePrice = 0;
		if (apples.size() > 0)
		{
			applePrice = apples.get(0).getPrice();
		}
		
		return apples.size() / 2 * applePrice;
	}
	

}

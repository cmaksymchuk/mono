package com.maksymchuk.shopping;

import java.util.List;

public interface IShoppingCart {

	List<Item> getScannedItems();

	void scan(Item... items);

	double checkout(Discount... discounts);

}
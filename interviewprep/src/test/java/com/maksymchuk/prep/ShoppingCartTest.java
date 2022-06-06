package com.maksymchuk.prep;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.maksymchuk.shopping.IShoppingCart;
import com.maksymchuk.shopping.Item;
import com.maksymchuk.shopping.ShoppingCart;

class ShoppingCartTest {

	@Test
	public void test() {
		Item apple = new Item("apple", .6d);
		Item orange = new Item("orange", .25d);
		IShoppingCart sc = new ShoppingCart();
		sc.scan(apple, apple, orange, orange);
		assertEquals(1.7d, sc.checkout());
	}

}

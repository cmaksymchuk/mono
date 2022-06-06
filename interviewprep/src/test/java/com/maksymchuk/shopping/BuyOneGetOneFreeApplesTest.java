package com.maksymchuk.shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(EasyMockExtension.class)
class BuyOneGetOneFreeApplesTest {

	@TestSubject 
	BuyOneGetOneFreeApples bogoApples = new BuyOneGetOneFreeApples();
	Item apple = new Item("apple", .6d);
	List<Item> noApples = Arrays.asList(new Item[] {});
	List<Item> twoApples = Arrays.asList(new Item[] {apple,apple});
	List<Item> threeApples = Arrays.asList(new Item[] {apple,apple,apple});
	List<Item> sevenApples = Arrays.asList(new Item[] {apple,apple,apple,apple,apple,apple,apple});

	@Mock
	IShoppingCart mockShoppingCart;
	
	@Test
	void test() {
		EasyMock.expect(mockShoppingCart.getScannedItems()).andReturn(noApples).once();
		EasyMock.replay(mockShoppingCart);
		
		double discount = bogoApples.apply(mockShoppingCart);
		EasyMock.verify(mockShoppingCart);
		
		assertEquals(0d, discount);		
	}
	
	@Test
	void testTwoApples() {
		EasyMock.expect(mockShoppingCart.getScannedItems()).andReturn(twoApples).once();
		EasyMock.replay(mockShoppingCart);
		
		double discount = bogoApples.apply(mockShoppingCart);
		EasyMock.verify(mockShoppingCart);
		
		assertEquals(.6d, discount);		
	}


}

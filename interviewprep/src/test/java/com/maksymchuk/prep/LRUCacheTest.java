package com.maksymchuk.prep;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LRUCacheTest {



	@Test()
	void testConstructor() {
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> {
					new LRUCache(0);
		}, "Constructor too low");
	}
	
	@Test
	void testPutCacheSizeOne() {
		LRUCache lruc = new LRUCache(1);
		lruc.put(1, 1);
		assertEquals(1, lruc.get(1));
	}
	
	@Test
	void testCapacity() {
		LRUCache lruc = new LRUCache(1);
		lruc.put(1, 2);
		lruc.put(3, 4);
		assertEquals(-1, lruc.get(1));
		assertEquals(4, lruc.get(3));
		System.out.println(lruc.cache);
	}

	@Test
	void testNormal() {
		LRUCache lruc = new LRUCache(3);
		lruc.put(1, 2);
		lruc.put(3, 4);
		lruc.put(5, 6);
		lruc.put(7, 8);

//		assertEquals(2, lruc.get(1));
//		assertEquals(4, lruc.get(3));
//		assertEquals(6, lruc.get(5));
		System.out.println(lruc.getCache());
	}
}

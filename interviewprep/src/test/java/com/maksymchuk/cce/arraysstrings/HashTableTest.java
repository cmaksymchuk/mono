package com.maksymchuk.cce.arraysstrings;

import org.junit.jupiter.api.Test;

public class HashTableTest {

	@Test
	public void test()
	{
		HashTable ht = new HashTable();
		ht.add("1", "one");
		ht.add("99", "ninety nine");
		ht.add("489", "four hundred eighty nine");
		ht.add("1000", "one thousand");
		
		System.out.println(ht.retrieve("1"));
	}
}

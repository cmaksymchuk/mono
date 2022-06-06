package com.maksymchuk.binarytree;

import java.util.Random;

import org.junit.jupiter.api.Test;



class BinaryHeapTreeTest {
	
	BinaryHeapTree bht = new BinaryHeapTree();

	@Test
	void test() {
		Random r = new Random();
		for (int i = 0 ; i < 100; i++)
		{
			bht.add(r.nextInt(1000));
			
		}
		System.out.println(bht.toString());
	}

}

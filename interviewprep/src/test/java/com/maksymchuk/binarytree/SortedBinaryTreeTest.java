package com.maksymchuk.binarytree;

import org.junit.jupiter.api.Test;

class SortedBinaryTreeTest {
	SortedBinaryTree tree = new SortedBinaryTree();
	
	@Test
	void test() {
		tree.add(10);
		tree.add(5);
		tree.add(7);
		tree.print();
	}

}

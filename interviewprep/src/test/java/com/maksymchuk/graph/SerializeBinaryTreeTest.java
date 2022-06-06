package com.maksymchuk.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.maksymchuk.graph.SerializeBinaryTree.TreeNode;

class SerializeBinaryTreeTest {

	SerializeBinaryTree sbt = new SerializeBinaryTree();
	
	@Test
	void testSerializeNull() {
		assertEquals("[]", sbt.serilaze(null));
	}
	
	@Test
	void testSerializeNonEmpty() {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		
		one.left = two;
		one.right = three;
		
		three.left = four; 
		three.right = five;
		
		
		assertEquals("[1, 2, 3, null, null, 4, 5, null, null, null, null]", sbt.serilaze(one));
	}

	@Test
	void testSerializeSingle() {
		TreeNode headNode = new TreeNode(1);
		
		assertEquals("[1, null, null]", sbt.serilaze(headNode));
	}

	@Test
	void testDeserialize() {
		TreeNode node = sbt.deSerilaze("[1, null, null]");
		
		assertEquals(Integer.valueOf(1), node.val);
		assertNull(node.left);
		assertNull(node.right);
	}

	

}

package com.maksymchuk.binarytree;

import org.junit.jupiter.api.Test;

public class BinaryTreeTest {
	
	@Test
	public void setup()
	{
		BinaryTreeNode<String> root = new BinaryTreeNode<String>("1",
				new BinaryTreeNode<String>("2", new BinaryTreeNode<String>("4"), new BinaryTreeNode<String>("5", 
						new BinaryTreeNode<String>("8"), new BinaryTreeNode<String>("9") )), 
				new BinaryTreeNode<String>("3", new BinaryTreeNode<String>("6"), new BinaryTreeNode<String>("7")	));
		
		root.inOrderTraversal(root);
		root.preOrderTraversal(root);
		root.postOrderTraversal(root);
		
		System.out.println(root.toString());
		System.out.println(root.find(root,"6"));
		System.out.println(root.find(root,"2"));


	}

}

package com.maksymchuk.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeBinaryTree {

	Queue<TreeNode> queue = new LinkedList<TreeNode>();

	private IntArraySerializer ias = new IntArraySerializer();

	public IntArraySerializer getIas() {
		return ias;
	}

	public void setIas(IntArraySerializer ias) {
		this.ias = ias;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public String serilaze(TreeNode headNode) {

		List<Integer> list = new ArrayList<Integer>();

		if (headNode != null) {
			queue.add(headNode);

			while (!queue.isEmpty()) {
				TreeNode node = queue.remove();

				if (node != null) {
					list.add(node.val);
					queue.add(node.left);
					queue.add(node.right);
				} else {
					list.add(null);
				}
			}
		}
		
		return ias.serialize(list.toArray(new Integer[0]));
	}

	public TreeNode deSerilaze(String serialized) {
		Integer[] array = ias.deSerialize(serialized);

		return null;
	}
	
	public TreeNode helper(Integer[] array, int index)
	{
		if (array[index] != null)
		{
			TreeNode node = new TreeNode(array[index]);
			node.left = new TreeNode(array[index+1]);
			node.right = new TreeNode(array[index+2]);
			return node;
		}
		return null;
		
	}

}

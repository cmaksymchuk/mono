package com.maksymchuk.binarytree;

/**
https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java
**/
public class BinaryTreeNode<T> {
	
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T value;
	
	public BinaryTreeNode(T value)
	{
		this.value = value;
	}
	
	public BinaryTreeNode(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right)
	{
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public T value()
	{
		return value;
	}
	
	public BinaryTreeNode<T> left()
	{
		return left;
	}
	
	public BinaryTreeNode<T> right()
	{
		return right;
	}
	
	public void inOrderTraversal(BinaryTreeNode<T> node)
	{
		if (node != null)
		{
			inOrderTraversal(node.left);
			visit(node);
			inOrderTraversal(node.right);
		}
		
	}

	public void preOrderTraversal(BinaryTreeNode<T> node)
	{
		if (node != null)
		{
			visit(node);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
		
	}
	
	public void postOrderTraversal(BinaryTreeNode<T> node)
	{
		if (node != null)
		{
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			visit(node);

		}
		
	}
	private void visit(BinaryTreeNode<T> node) {
		System.out.println(node.value);
		
	}

	public BinaryTreeNode<T> find(BinaryTreeNode<T> node, T value)
	{		
		if (node != null)
		{
			if (node.value() == value)
			{
				System.out.println("found node with value " + value);
				return node;
			}
			
			BinaryTreeNode<T> leftSearch = find(node.left(), value);
			if (leftSearch != null)
			{
				return leftSearch;
			}
			return find(node.right(), value);
		}
		return null;
	}

    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    public void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(value);
        buffer.append('\n');
        if (left != null)
        {
            left.print(buffer, childrenPrefix + "|-- ", childrenPrefix + "|   ");
        }
        if (right != null)
        {
            right.print(buffer, childrenPrefix + "|-- ", childrenPrefix + "|   ");        
        }
    }
}

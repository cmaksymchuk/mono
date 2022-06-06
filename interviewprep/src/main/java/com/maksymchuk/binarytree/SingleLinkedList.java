package com.maksymchuk.binarytree;

public class SingleLinkedList {
	private SllNode head;
	private SllNode tail;
	
	public boolean isEmpty()
	{
		return head == null;
	}

	public SllNode getHead() {
		return head;
	}

	public SllNode getTail() {
		return tail;
	}

	public void add(int... datas)
	{
		for (int data : datas)
		{
			SllNode node = new SllNode(data);
			if (head == null)
			{
				head = node;
				tail = head;
			}
			else
			{
				tail.setNext(node);
				tail = node;			
			}
		}
	}
	
	public SllNode remove()
	{
		if (tail == null)
		{
			return null;			
		}
		if (head.getNext() == null)
		{
			SllNode returnNode = head;
			head = null;
			tail = null;
			return returnNode;
		}
		SllNode node = head;
		while (node.getNext().getNext() != null)
		{
			node = node.getNext();
		}
		SllNode returnNode = node.getNext();
		tail = node;
		tail.setNext(null);
		return returnNode;
	}
	
	
}

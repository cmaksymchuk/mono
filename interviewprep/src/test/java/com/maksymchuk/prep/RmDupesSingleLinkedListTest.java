package com.maksymchuk.prep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.maksymchuk.prep.RmDupesSingleLinkedList.ListNode;

class RmDupesSingleLinkedListTest {

	@Test
	void test() {
		ListNode node1 = node(1,1,2,3,3);
		
		print(node1);
		
		RmDupesSingleLinkedList rmd = new RmDupesSingleLinkedList();
		rmd.deleteDuplicates(node1);
		print(node1);
	}
	
	private ListNode node(int... vals)
	{
		ListNode next = null;
		for (int i = vals.length - 1; i >= 0; i--)
		{
			ListNode node = new ListNode(vals[i]);
			if (next != null)
			{
				node.next = next;
			}
			next = node;
		}
		return next;
		
	}
	
	public void print(ListNode node)
	{
		while (node != null)
		{
			System.out.print(node.val + " ");
			node = node.next;
		}
		
	}

}

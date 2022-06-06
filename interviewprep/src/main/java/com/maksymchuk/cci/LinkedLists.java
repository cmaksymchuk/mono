package com.maksymchuk.cci;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import com.maksymchuk.binarytree.SingleLinkedList;
import com.maksymchuk.binarytree.SllNode;

public class LinkedLists {

	public void removeDupes1(LinkedList<String> ll) {
		Set<String> hashSet = new HashSet<String>();
		Iterator<String> it = ll.iterator();

		while (it.hasNext()) {
			String next = it.next();
			if (hashSet.contains(next))
			{
				it.remove();
			}
			else {
				hashSet.add(next);
			}
		}
		
		for (String s : ll)
		{
			System.out.println(s);
		}
	}
	
	public void removeDupes2(LinkedList<String> ll) {
		Iterator<String> it = ll.iterator();
		Iterator<String> searcher = ll.iterator();
		int index = 0;
		

		while (it.hasNext()) {			
			String next = it.next();
			boolean duplicate = searchForDupeInLinkedList(index + 1, next, ll);
			if (duplicate)
			{
				it.remove();
				index--;
			}			
			index++;
		}

	}
	
	public boolean searchForDupeInLinkedList(int searchFromIndex, String searchFor, LinkedList<String> ll) 
	{
		while (searchFromIndex < ll.size())
		{
			String searchedNext = ll.get(searchFromIndex);
			if (searchedNext.equals(searchFor))
			{
				return true;
			}
			searchFromIndex++;
		}
		return false;
	}
	
	public int sumLists(SingleLinkedList l1, SingleLinkedList l2)
	{
		return getValue(l1) + getValue(l2);
	}
	
	public int getValue(SingleLinkedList l)
	{
		int times = 1;
		int sum = 0;
		SllNode node = l.getHead();
		while (node != null)
		{
			sum += node.getData() * times;
			times = times * 10;
			node = node.getNext();
		}	
		return sum;
	}
	

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int val1 = val(l1);
		int val2 = val(l2);

		int sum = val1 + val2;
		System.out.println(sum);
		ListNode previous = null;
		ListNode head = null;
		while (sum > 0) {
			int rightDigit = sum % 10;
			ListNode n = new ListNode(rightDigit);
			sum = sum / 10;
			if (previous != null) {
				previous.next = n;
			} else {
				head = n;
			}
			previous = n;
		}
		return head;

	}

	public int val(ListNode l) {
		ListNode pointer = l;
		int multiply = 1;
		int val = pointer.val * multiply;
		while (pointer.next != null) {
			pointer = pointer.next;
			multiply *= 10;
			val += pointer.val * multiply;
		}
		return val;
	}


}

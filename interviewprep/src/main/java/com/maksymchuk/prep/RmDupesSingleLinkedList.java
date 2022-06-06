package com.maksymchuk.prep;

public class RmDupesSingleLinkedList {

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
		public String toString()
		{
			return Integer.toString(val);
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode originalHead = head;
		while (head != null && head.next != null)
		{
			if (head.val == head.next.val)
			{
				head.next = head.next.next;
			}
			head = head.next;
		}
		return originalHead;
	}

}

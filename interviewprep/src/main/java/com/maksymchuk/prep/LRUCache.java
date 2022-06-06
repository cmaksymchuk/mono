package com.maksymchuk.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 * 
 * Design a data structure that follows the constraints of a Least Recently Used
 * (LRU) cache.
 * 
 * Implement the LRUCache class:
 * 
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * 
 * int get(int key) Return the value of the key if the key exists, otherwise
 * return -1.
 * 
 * void put(int key, int value) - Update the value of the key if the key exists.
 * - Otherwise, add the key-value pair to the cache. - If the number of keys
 * exceeds the capacity from this operation, evict the least recently used key.
 * 
 * The functions get and put must each run in O(1) average time complexity.
 * 
 * This is a comment
 */
class LRUCache {

	class LLNode {
		public LLNode(int key, int val) {
			super();
			this.key = key;
			this.val = val;
		}

		int key;
		int val;
		public LLNode previous;
		public LLNode next;
		public String toString() { 
			return "key=" + key + " val=" + val + " ";
		}
	}

	/**
	 * capacity = 3
	 * 
	 * put 1 1 (least recently used = 1) put 2 2,1 (MR = 2, LU = 1) put 3 3,2,1 (MR
	 * = 3, LU = 1) get(2) 2,3,1 (MR = 2, LU = 1) get(1) 1,3,2 (MR = 1, LU = 2)
	 **/

	Map<Integer, LLNode> cache = new HashMap<Integer, LLNode>();
	LLNode head;
	LLNode tail;
	// ll.first = Least recently used
	// ll.last = Most Recently Used

	private int capacity = 0;

	public LRUCache(int capacity) {
		if (capacity < 1) {
			throw new IllegalArgumentException("Constructor too low");
		}
		this.capacity = capacity;
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			LLNode node = cache.get(key);
			remove(node);
			addHead(node);
			return node.val;
		}
		return -1;
	}

	public void put(int key, int value) {
		// check if the number of elements in the cache is the same as the capacity
		// if so we must evict
		if (cache.containsKey(key)) {
			LLNode node = cache.get(key);
			node.val = value;
			remove(node);
			addHead(node);
		} else {
			LLNode node = new LLNode(key, value);

			if (capacity == cache.size()) {
				LLNode lastUsed = tail;
				cache.remove(lastUsed.key);
				remove(lastUsed);
			}
			cache.put(key, node);
			addHead(node);
		}
	}

	public void addHead(LLNode node) {
		node.next = head;
		if (head != null) {
			head.previous = node;
		}
		if (tail == null)
		{
			tail = node;
		}
		head = node;
	}

	public void remove(LLNode node) {
		if (node.next != null) {
			node.next.previous = node.previous;
		}
		if (node.previous != null) {
			node.previous.next = node.next;
		}
		if (head == node) {
			head = head.next;
		}
		if (tail == node) {
			tail = node.previous;
		}
	}
	
	public List<LLNode> getCache()
	{
		List<LLNode> cache = new ArrayList<LLNode>();
		LLNode node = head;
		while (node != null)
		{
			cache.add(node);
			node = node.next;			
		}
		return cache;
	}
}

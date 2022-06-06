package com.maksymchuk.binarytree;

public class SllNode {
	private SllNode next;
	private int data;

	public SllNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public SllNode getNext() {
		return next;
	}

	public void setNext(SllNode next) {
		this.next = next;
	}
}

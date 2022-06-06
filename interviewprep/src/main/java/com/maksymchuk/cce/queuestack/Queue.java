package com.maksymchuk.cce.queuestack;

import java.util.NoSuchElementException;

public class Queue<T> {
	
	public static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;
		
		public QueueNode(T data)
		{
			this.data = data;
		}		
		
		public void setNext(QueueNode<T> next)
		{
			this.next = next;
		}
	}
	
	// remove from head
	private QueueNode<T> head;
	// add to tail
	private QueueNode<T> tail;
	
	public void add(T data)
	{		
		QueueNode<T> qn = new QueueNode<T>(data);
		if (tail == null && head == null)
		{
			tail = qn;			
			head = qn;
		}
		else
		{
			tail.setNext(qn);
			tail = qn;
		}						
	}
	
	public T remove()
	{	
		if (head == null && tail == null)
		{
			throw new NoSuchElementException("Queue is empty");		
		}
		
		if (head == tail)
		{
			T data = head.data;
			head = null;
			tail = null;
			return data;			
		}
		else 
		{
			T data = head.data;
			head = head.next;
			return data;
		}			
	}
	
	public T peek()
	{
		if (head == null && tail == null)
		{
			throw new NoSuchElementException("Queue is empty");		
		}
		else
		{
			return head.data;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}
}

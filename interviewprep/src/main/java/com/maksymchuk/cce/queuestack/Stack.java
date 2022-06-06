package com.maksymchuk.cce.queuestack;

import java.util.NoSuchElementException;

public class Stack<T> {
	
	public static class StackNode<T> {
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data)
		{
			this.data = data;
		}		
		
		public void setNext(StackNode<T> next)
		{
			this.next = next;
		}
	}
	
	// remove from head
	private StackNode<T> top;
	
	public void add(T data)
	{		
		StackNode<T> qn = new StackNode<T>(data);
		if (top == null)
		{
			top = qn;
		}
		
		else
		{
			qn.next = top;
			top = qn;
		}						
	}
	
	public T remove()
	{	
		if (top == null)
		{
			throw new NoSuchElementException("Queue is empty");		
		}
		
		else 
		{
			
			T data = top.data;
			top = top.next;
			return data;
		}			
	}
	
	public T peek()
	{
		if (top == null)
		{
			throw new NoSuchElementException("Queue is empty");		
		}
		else
		{
			return top.data;
		}
	}

	public boolean isEmpty() {
		return top == null;
	}

}

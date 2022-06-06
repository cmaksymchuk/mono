package com.maksymchuk.cce.queuestack;

import org.junit.jupiter.api.Test;

public class StackTest {
	
	@Test
	public void test()
	{
		Stack<String> q = new Stack<String>();
		q.add("1");
		q.add("2");
		q.add("3");
		q.add("4");
		q.add("5");
		q.add("6");
		while (!q.isEmpty())
		{
			System.out.println(q.remove());
		}
		
	}
}

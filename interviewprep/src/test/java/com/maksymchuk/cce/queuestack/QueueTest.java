package com.maksymchuk.cce.queuestack;

import org.junit.jupiter.api.Test;

public class QueueTest {
	
	@Test
	public void test()
	{
		Queue<String> q = new Queue<String>();
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

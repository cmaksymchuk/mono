package com.maksymchuk.graph;

import org.junit.jupiter.api.Test;

public class GraphTest {
	
	@Test
	public void testDfs()
	{
		GraphNode<String> one = new GraphNode<String>("1");
		
		GraphNode<String> two = new GraphNode<String>("2");
		one.add(two);
		one.add(new GraphNode<String>("3"));
		one.add(new GraphNode<String>("4"));
		one.add(new GraphNode<String>("5"));
		
		two.add(new GraphNode<String>("6"));
		two.add(new GraphNode<String>("7"));
		
		
		System.out.println("Found : " + one.dfs(one, "5"));
		
		System.out.println();
		
		System.out.println("Found : " + one.dfs(one, "6"));
		
		System.out.println();
		
		System.out.println("Found : " + one.dfs(one, "99"));
		
	}
	
	@Test
	public void testBfs()
	{
		GraphNode<String> one = new GraphNode<String>("1");
		
		GraphNode<String> two = new GraphNode<String>("2");
		one.add(two);
		one.add(new GraphNode<String>("3"));
		one.add(new GraphNode<String>("4"));
		one.add(new GraphNode<String>("5"));
		
		two.add(new GraphNode<String>("6"));
		
		GraphNode<String> seven = new GraphNode<String>("7");
		two.add(seven);
		seven.add(one);
		
		
		
		
//		System.out.println("Found : " + one.bfs(one, "5"));
//		
//		System.out.println();
		
		System.out.println("Found : " + one.bfs(one, "6"));
		
		System.out.println();
		
		System.out.println("Found : " + one.bfs(one, "99"));
		
	}
	
	

}

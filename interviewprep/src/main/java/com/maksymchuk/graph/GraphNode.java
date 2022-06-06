package com.maksymchuk.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class GraphNode<T> {
	T value;
	List<GraphNode<T>> children = new ArrayList<GraphNode<T>>();
	boolean visited = false;
	
	public GraphNode(T t)
	{
		this.value = t;
	}
	
	public void add(GraphNode<T> t)
	{
		if (t != null)
		{
			children.add(t);	
		}		
	}
	
	public String toString() 
	{
		return value == null ? "null" : value.toString();
	}
	
	public GraphNode<T> dfs(GraphNode<T> node, T value)
	{
		GraphNode<T> found = null;
		
		System.out.println("visiting " + node.value);
		if (node != null && node.value == value)
		{
			return node;
		}
		if (children != null)
		{
			for (GraphNode<T> childNode : node.children)
			{				
				if (found == null)
				{
					found = dfs(childNode, value);
				}						
			}
		}		
		return found;
	}
	
	public GraphNode<T> bfs(GraphNode<T> node, T value)
	{	
		GraphNode<T> found = null;
		Queue<GraphNode<T>> queue = new LinkedList<GraphNode<T>>();
		
		Set<GraphNode<T>> visited = new HashSet<GraphNode<T>>();

		
		if (node != null)
		{
			queue.add(node);
		}
		
		while (!queue.isEmpty() && found == null)
		{
			GraphNode<T> currentNode = queue.remove();
			
			System.out.println("visiting " + currentNode.value);
			visited.add(currentNode);
			if (currentNode.value == value)
			{
				found = currentNode;
				break;
			}
			List<GraphNode<T>> notVisitedChildren =
					currentNode.children.stream().filter(filterNode -> !visited.contains(filterNode)).collect(Collectors.toList());
			
			for (GraphNode<T> childNode : notVisitedChildren)
			{
				queue.add(childNode);
			}
		}
		return found;
	}
}

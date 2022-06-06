package com.maksymchuk.prep;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class ReversePolish {
	Stack<Integer> stack = new Stack<Integer>();
	Map<String, BiFunction<Integer, Integer, Integer>> operationsMap = new HashMap<String, BiFunction<Integer, Integer, Integer>>();
	
	static class PlusFunction implements BiFunction<Integer, Integer, Integer>
	{
		@Override
		public Integer apply(Integer t, Integer u) {
			return t + u;
		}		 
	}
	
	static class MinusFunction implements BiFunction<Integer, Integer, Integer>
	{
		@Override
		public Integer apply(Integer t, Integer u) {
			return t - u;
		}		 
	}
	
	static class MultiplyFunction implements BiFunction<Integer, Integer, Integer>
	{
		@Override
		public Integer apply(Integer t, Integer u) {
			return t * u;
		}		 
	}
	
	static class DivideFunction implements BiFunction<Integer, Integer, Integer>
	{
		@Override
		public Integer apply(Integer t, Integer u) {
			return t / u;
		}		 
	}
	
	public ReversePolish()
	{
		operationsMap.put("+", new PlusFunction());
		operationsMap.put("-", new MinusFunction());
		operationsMap.put("/", new DivideFunction());
		operationsMap.put("*", new MultiplyFunction());
	}
	

	// If a value appears next in the expression, push this value on to the stack
	// If an operator appears next, pop two items from the top of the stack and push 
	// the result of the operation on to the stack.
	public int evaluate(String[] strs)
	{
		for (String string : strs)
		{
			if (operationsMap.containsKey(string))
			{
				BiFunction<Integer, Integer, Integer> f = operationsMap.get(string);
				Integer i1 = stack.pop();
				Integer i2 = stack.pop();
				Integer i3 = f.apply(i2, i1);
				stack.push(i3);
			} else
			{
				stack.push(Integer.valueOf(string));
			}
		}
		return stack.pop();
	}

}

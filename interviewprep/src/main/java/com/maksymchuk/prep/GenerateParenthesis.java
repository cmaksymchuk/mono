package com.maksymchuk.prep;
import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	
	// Given an integer n,
	// generate all the valid combinations of n pairs of parentheses
	
	// for example 2
	// "(())", "()()"
	// for example 3
	// "((()))", "(()())","(())()","()(())","()()()"
	
	public static void main(String... args)
	{
		GenerateParenthesis gp = new GenerateParenthesis();
		List<String> strings = gp.generate(3);
		for (String s : strings)
		{
			System.out.println(s);
		}
		
	}
	
	public List<String> generate(int n)	{
		
		int stringLength = 2 * n;
		double stringCount = Math.pow(2,stringLength);
		List<String> strings = new ArrayList<String>();
		
	    for (int i = 0; i < stringCount; i++) {
	        String s = String.format("%" + stringLength + "s", Integer.toBinaryString(i)).replace(' ', '0')
	        		.replaceAll("0","(").replaceAll("1", ")");
			if (isValid(s))
			{
				strings.add(s);				
			}
	    }
	    return strings;
	}
	
	public boolean isValid(String s)
	{
		int left = 0;
		int right = 0;
		
		for (int i = 0 ; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (c == '(')
			{
				left++;
			}
			else if (c == ')')
			{
				right++;
			}
			if (right > left || right > 3 || left > 3)
			{
				return false;
			}
		}
		
		return true;
	}

}

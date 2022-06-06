package com.maksymchuk.prep;

import java.util.Arrays;

public class ReverseString {
	
	public static void main(String[] args)
	{
		String[] s = new String[] {"h","e","l","l","o"};
		for (int i = 0 ; i < s.length/2; i++)
		{
			String temp = s[i];
			s[i] = s[s.length-1-i];
			s[s.length-1-i] = temp;
		}
		System.out.println(Arrays.deepToString(s));
	}

}

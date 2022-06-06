package com.maksymchuk.cci;

import java.util.HashSet;
import java.util.Set;

public class StringPermutations {
	
    public static void main(String[] args)
    {
        String s = "abc";
        System.out.println(printPermutn(s));
    }
    
    public static Set<String> printPermutn(String s)
    {
    	Set<String> ps = new HashSet<String>();
    	
    	if (s == null)
    	{
    		return ps;
    	}
    	if (s.length() == 0)
    	{
    		ps.add("");
    		return ps;
    	}
    	char c = s.charAt(0);
    	String remainder = s.substring(1);
    	
    	Set<String> words = printPermutn(remainder);
    	for (String word : words)
    	{
    		for (int i = 0 ; i <= word.length(); i++)
    		{
    			ps.add(addCharacter(word, c, i));
    		}
    	}    	
    	return ps;
    }
    
    public static String addCharacter(String s, char c, int atIndex)
    {
    	StringBuilder sb = new StringBuilder();
    	sb.append(s.substring(0,atIndex));
    	sb.append(c);
    	sb.append(s.substring(atIndex));
    	return sb.toString();
    }

}

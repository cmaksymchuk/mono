package com.maksymchuk.cci;

import java.util.Arrays;

public class ArraysStrings {
	
	public boolean isUnique(String s) {
		boolean isUnique = true;
		if (s == null)
		{
			return false;
		}
		for (int i = 0 ; i < s.length(); i++)
		{
			char c = s.charAt(i);
			int secondOccurrence = s.indexOf(c, s.indexOf(c) + 1);
			if (secondOccurrence > 0)
			{
				isUnique = false;
				break;
			}
		}
		return isUnique;
		
	}
	
	public boolean checkPermutation(String s1, String s2)
	{
		if (s1.length() != s2.length())
		{
			return false;
		}
		boolean isPermutation = true;
		char[] s1CharArray = s1.toCharArray();
		char[] s2CharArray = s2.toCharArray();
		Arrays.sort(s1CharArray);
		Arrays.sort(s2CharArray);
		for (int i = 0; i < s1.length(); i++) {
			
			if (Character.toLowerCase(s1CharArray[i]) != Character.toLowerCase(s2CharArray[i])) {
				isPermutation = false;
				break;
			}
		}
		return isPermutation;
	}
	
	public String urlIfy(String s)
	{
		int len = s.length();
		char[] ca = new char[len];
		int index = len-1;
		boolean foundLastChar = false;
		
		for (int i = len-1; i >= 0; i--) {
			char c = s.charAt(i);
			if (!foundLastChar)
			{
				if (c == ' ')
				{
					continue;
				}
				else
				{
					foundLastChar = true;
				}
			}
			
			if (c == ' ')
			{
				ca[index--] = '0';
				ca[index--] = '2';
				ca[index--] = '%';
			}
			else 
			{
				ca[index--] = c;	
			}			
		}
		return new String(ca);
	}
	
	public boolean permutationOfPalendrome(String str)
	{
		str = str.toLowerCase();
		str = str.replaceAll("\\s", "");
		char[] chars = str.toCharArray();
		Arrays.parallelSort(chars);
		boolean isOddLength = str.length() % 2 == 1;
		int nonMatching = 0;
		
		for (int i = 0; i < chars.length; i++) {
			boolean lastChar = i == chars.length -1;
			if (lastChar || chars[i] != chars[i+1])
			{
				nonMatching++;							
			}
			else
			{
				i++;				
			}
		}
		
		return isOddLength ? nonMatching == 1 : nonMatching == 0;		
	}
	
	public boolean oneAway(String s1, String s2)
	{
		int numCharDifference = s1.length() - s2.length();
		
		if (numCharDifference == 0)
		{			
			return oneEditAway(s1, s2);
		}
		
		if (numCharDifference == 1)
		{
			return oneLetterAway(s1, s2);
		}
		if (numCharDifference == -1)
		{
			return oneLetterAway(s2, s1);
		}
		return false;
	}

	private boolean oneEditAway(String s1, String s2) {
		int nonMatchingChars = 0;
		for (int i = 0 ; i < s1.length(); i++)
		{
			nonMatchingChars += s1.charAt(i) == s2.charAt(i) ? 0 : 1;
			if (nonMatchingChars > 1)
			{
				return false;
			}
		}
		return true;
	}
	
	private boolean oneLetterAway(String larger, String smaller) {
		int nonMatchingChars = 0;
		int largeIndex = 0;
		int smallIndex = 0;
		while (largeIndex < larger.length() && smallIndex < smaller.length())
		{
			boolean isMatch = larger.charAt(largeIndex) == smaller.charAt(smallIndex);
			if (!isMatch)
			{
				largeIndex++;
			}
			else 
			{
				largeIndex++;
				smallIndex++;
			}
			if (largeIndex-smallIndex > 1)
			{
				return false;
			}
		}
		return true;
	}
	

}

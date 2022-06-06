package com.maksymchuk.cce.arraysstrings;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArraysStrings {

	public boolean isUnique2(String string) {
		
		Map<String, Long> map = string.codePoints().mapToObj(c -> String.valueOf(c)).collect(Collectors.groupingBy(
				Function.identity(), Collectors.counting()));
		
		return !map.values().stream().anyMatch(l -> l > 1);
		
	}
	
	public boolean isUnique1(String string) {
		boolean isUnique = true;
		Set<Character> map = new HashSet<Character>();
		for (int i = 0; i < string.length(); i++)
		{
			char c = string.charAt(i);
			if (!map.contains(new Character(c)))
			{
				map.add(new Character(c));
			}
			else
			{
				isUnique = false;
				break;
			}			
		}
		return isUnique;
	}

//	public boolean oneAway(String string1, String string2) {
//		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
//		Map<Character, Integer> map2 = new HashMap<Character, Integer>();
//		for (int i = 0; i < string1.length(); i++)
//		{
//			char c = string1.charAt(i);
//			int count = 1;
//			if (map1.containsKey(c))
//			{
//				count = map1.get(c) + 1;				
//			}
//			map1.put(c, count);
//		}
//		return false;
//		
//	}
	
	

}

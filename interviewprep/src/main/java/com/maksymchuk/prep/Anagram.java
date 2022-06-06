package com.maksymchuk.prep;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

	public boolean test(String string1, String string2) {
		boolean rtrn = false;
		if (string1 != null && string2 != null)
		{
			rtrn = mapsEqual(map(string1), map(string2)); 
		}
		
		return rtrn;		
	}
	
	public Map<Character, Integer> map(String string)
	{
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		for (int i = 0; i < string.length(); i++)
		{
			char c = string.charAt(i);
			if (charMap.containsKey(c))
			{
				Integer count = charMap.get(c);
				count = count.intValue() + 1;
				charMap.put(c, (count));
			}
			else
			{
				charMap.put(c, Integer.valueOf(1));
			}
		}
		return charMap;
	}
	
	public boolean mapsEqual(Map<Character, Integer> m1, Map<Character, Integer> m2)
	{
		if (m1.size() != m2.size())
			return false;
		return m1.entrySet().stream().allMatch(entry -> m2.get(entry.getKey()) == entry.getValue());
	}

}

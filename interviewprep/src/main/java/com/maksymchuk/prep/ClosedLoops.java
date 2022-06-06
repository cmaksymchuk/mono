package com.maksymchuk.prep;

import java.util.HashMap;
import java.util.Map;

public class ClosedLoops {
	private static Map<String, Integer> numbers = new HashMap<String, Integer>();
	static
	{
		numbers.put("0", Integer.valueOf(1));
		numbers.put("6", Integer.valueOf(1));
		numbers.put("8", Integer.valueOf(2));
		numbers.put("9", Integer.valueOf(1));
	}
	public int test(String string) {
		int rtrn = 0;
		if (string != null)
		{
			for (int i = 0 ; i < string.length(); i++)
			{
				char c = string.charAt(i);
				String character = String.valueOf(c);
				if (numbers.containsKey(character))	
				{
					rtrn += numbers.get(character);
				}
			}

		}
		return rtrn;
	}
	
	
}

package com.maksymchuk.prep;

public class FirstNonRepeatingCharacter {
	
	public static void main(String[] args)
	{
		String s = "loveleetcode";
		for (int i = 0; i < s.length(); i++)
		{
			boolean repeating = false;
			char currentChar = s.charAt(i);
			for (int j = i+1; j < s.length(); j++)
			{
				char lookingForRepeatingChar = s.charAt(j);
				if (currentChar == lookingForRepeatingChar)
				{
					repeating = true;
					break;
				}				
			}
			if (repeating == false)
			{
				System.out.println(i);
				break;
			}			
		}
			
	}
		

}

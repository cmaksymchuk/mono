package com.maksymchuk.shopify;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {
	
	
	static class Editor
	{
		StringBuilder inputString;
		int position;
		
		public Editor(String inputString)
		{
			this.inputString = new StringBuilder(inputString);
		}
		
		public void move(int howMany)
		{
			int newPosition = position + howMany;
			if (newPosition < 0 || newPosition > inputString.length() - 1)
			{
				throw new IndexOutOfBoundsException("Moved to index " + newPosition);
			}
			position = newPosition;
		}
		
		public void replace(char c)
		{
			inputString.setCharAt(position, c);
		}
		
		public String toString()
		{
			return inputString.toString();
		}
	}

	// method takes in two strings
	// read 1 letter, 0 or 1 number
	// F = move forward
	// F2 = move forward 2
	// B = move backward
	// B3 = move backward 3
	// Rx = replace current character with the character x
	/*
	 * Original string: abcdefghijklmn Operations:F -> move curser forward, B ->
	 * move curse backward, R -> replace char Operation string: F2B1F5Rw ->
	 * abcdefwhijklmn (expected output) Moving forward by 2 chars, move backward by
	 * 1 char, move forward 5 chars, replace 1 char to be ‘w’ We can assume that
	 * curser is at first character at the beginning. How can I add more operations
	 * using OOP if required?
	 */
	public List<String> getOperations(String operationsString) {
		List<String> operations = new ArrayList<String>();
		if (operationsString != null) {

			Pattern pattern = Pattern.compile("([F|B]{1}\\d+)|([R][a-zA-Z])");
			Matcher matcher = pattern.matcher(operationsString);
			while (matcher.find()) {
				operations.add(matcher.group());
			}
		}
		return operations;
	}
	
	public void apply(Editor editor, String command)
	{
		if (command.charAt(0) == 'F')
		{
			editor.move(Integer.valueOf(command.substring(1))); 
		}
		if (command.charAt(0) == 'B')
		{
			editor.move(Integer.valueOf(command.substring(1))*-1); 
		}
		if (command.charAt(0) == 'R')
		{
			editor.replace(command.charAt(1)); 
		}
	}
	
	public String parse(String inputString, String command)
	{
		List<String> commands = this.getOperations(command);
		Editor editor = new Editor(inputString);
		for (String op : commands)
		{
			apply(editor, op);
		}
		return editor.toString();
	}
	


}

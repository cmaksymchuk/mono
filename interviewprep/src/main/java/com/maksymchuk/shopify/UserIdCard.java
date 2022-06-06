package com.maksymchuk.shopify;

import java.util.Calendar;
import java.util.Scanner;

public class UserIdCard {
	
	
	/**
	 * Jigarius Caesar looks as follows: CAJI202002196
	 
	    CA: First 2 characters of the employee’s last name.
		JI: First 2 characters of the employee’s first name.
		2020: Full year of joining.
		02: 2 digit representation of the month of joining.
		19: Indicates that this is the 19th employee who joined in Feb 2020.
		This will have at least 2 digits, starting with 01, 02, and so on.
		6: The last digit is a verification digit which is computed as follows:
		Take the numeric part of the ID code (without the verification digit).
		Sum all digits in odd positions. Say this is O.
		Sum all digits in even positions. Say this is E.
		Difference between O & E. Say this is V.
		If V is negative, ignore the sign, e.g., -6 is treated as 6. Say this is V.
		If V is greater than 9, divide it by 10 and take the reminder. Say this is V.
		V is the verification code.
	 * @param args
	 */
	
	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter first last number: ");
		String input = reader.nextLine(); // Scans the next token of the input as an int.
		System.out.println(input);
		reader.close();
	}
	
	public boolean isValid(String first, String last, String number)
	{
		if (first == null || last == null || number == null)
		{
			return false;
		}
		
		if (number.length() < 13)
		{
			return false;
		}
		
		
		String lastTwo = number.substring(0,2);
		String firstTwo = number.substring(2,4);
		String year = number.substring(4,8);
		String month = number.substring(8,10);
		
		// this is interesting
		int nthIndexEndIndex = 10 + number.length() - 11;
		String nTh = number.substring(10, nthIndexEndIndex);
		String numericPartOfIdCodeWithoutVerification = number.substring(4,number.length()-1);
		
		int oddSum = 0;
		int evenSum = 0;
		
		for (int i = 0; i < numericPartOfIdCodeWithoutVerification.length(); i++)
		{
			char c = numericPartOfIdCodeWithoutVerification.charAt(i);
			oddSum += i % 2 == 1 ? (c - '0') : 0;
			evenSum += i % 2 == 0 ? (c - '0') : 0;
		}
		int validVerification = Math.abs(oddSum - evenSum);
		int verification = number.charAt(nthIndexEndIndex) - '0';
		
		if (!lastTwo.equalsIgnoreCase(last.substring(0, 2)))
		{
			return false;
		}
		if (!firstTwo.equalsIgnoreCase(first.substring(0, 2)))
		{
			return false;
		}
		try 
		{
			int yearInt = Integer.parseInt(year);
			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			if (yearInt > currentYear || yearInt < 1900)
			{
				return false;
			}
		} catch (Exception e) 
		{
			return false;
		}
		
		if (Integer.parseInt(month) > 12)
		{
			return false;
		}
		
		if (verification != validVerification)
		{
			return false;
		}
//		System.out.println(lastTwo + " " + firstTwo + " " + year + " " + month + " " + nTh + " " + verification);
		return true;
		
		
		
		/*
		 * 2 + 2 + 4 + 2 + 1 + n = 11 + n
		 * where n >= 2 and 
		 * length >= 13
		 * n = len(string) - 11
		 * 
	    CA: First 2 characters of the employee’s last name.
		JI: First 2 characters of the employee’s first name.
		2020: Full year of joining.
		02: 2 digit representation of the month of joining.
		19: Indicates that this is the 19th employee who joined in Feb 2020.
		This will have at least 2 digits, starting with 01, 02, and so on.
		6: The last digit is a verification digit which is computed as follows:
		Take the numeric part of the ID code (without the verification digit).
		Sum all digits in odd positions. Say this is O.
		Sum all digits in even positions. Say this is E.
		Difference between O & E. Say this is V.
		If V is negative, ignore the sign, e.g., -6 is treated as 6. Say this is V.
		If V is greater than 9, divide it by 10 and take the reminder. Say this is V.
		V is the verification code.
		*/
	}
	

	/*
	 * 
	Prints PASS if the ID code seems valid.
	Prints INVESTIGATE otherwise.
	*/

}

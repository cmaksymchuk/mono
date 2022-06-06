package com.maksymchuk.binarytree;

import static java.lang.Integer.toBinaryString;

import org.junit.jupiter.api.Test;

public class BitManipulationTest {
	
	@Test
	public void testOrXorAndShift()
	{
		int a = 9;
		int b = 10;
		print(a, b, "&", a&b);
		print(a, b, "|", a|b);
		print(a, b, "^", a^b);
		print(a, 2, "<<", a<<2);

//		// 9 shifted by 2 left is 9*2*2 
//		System.out.println(toBinaryString(a) + " << " + 2 + " + " + toBinaryString(a << 2) + " = " + (a << 2));
//		// 9 shifted by to to the right is 2 (9/2/2)
//		System.out.println(toBinaryString(a) + " >> " + 2 + " + " + toBinaryString(a >> 2) + " = " + (a >> 2));
//
//		
//		System.out.(0110 + 0010)
		
		/**
		 * Two's compliment
		 * Left most bit is sign bit
		 * Positive number are the same  
		 * For negative numbers, invert non-sign bits then add 1
		
		7 0111   -1 1111
		6 0110    -2 1110
		5 0101    -3 1101
		4 0100    -4 1100
		3 0011    -5 1 011
		2 0010    -6 1 010
		1 0001    -7 1 001
		0 0000
		
		 */
		/**
		 * >> is an arithmatic right shift, divides by 2
		 * >>> is a logical right shift 
		 * 10110101 (-75) >>> = 11011010 (90)
		 * 
		 * An arithmatic right shift is the same as a logical right shift but we keep the sign bit
		 * 
		 * If we do continual logical right shifts, we will get 00000000 because we continually put 0's into the most significant bit
		 * If we do continual arithmatic right shifts we get 11111111 (if the number started negative).  Two's compliment of that is 10000001 (-1) 
		 * 
		 */
	}
	
	
	
	public void print(int a, int b, String sign, int answer)
	{
		System.out.println("" + a + " " + sign + " " + b + " = " + (answer) + "\n\t" 
				+ toBinaryString(a) + " " + sign + " " + toBinaryString(b) + " " + "= " + toBinaryString(answer));

	}
	
	
	@Test
	public void testTwosCompliment()
	{
		// 1010
		System.out.println(binaryString(10));
		
		// 11111111111111111111111111110110(-10)
		// 10000000000000000000000000001010(-10) flipped + 1
		System.out.println(binaryString(-10));
		
		
		// 11111111111111111111111111110110(-10)
		// 00000000000000000000000000001010(+10)
		// =====================================
		// 00000000000000000000000000000000(0)

		// 1010(+10)
		// 1010(+10)
		// =====================================
		// 10100(+20)
		
		System.out.println(binaryString(20));

	}
	
	public String binaryString(int i)
	{
		return "" + toBinaryString(i) + "(" + i + ")"; 
	}
	
	// int is 32 bits
	// AND:   1010 & 1100 = 1000 (regular and)
	// OR:    1110 | 0011 = 1111 (regular or)
	// XOR:   if different then 1, else 1
	// 
	
	/*
	 * +  ?
	 * -  ?
	 * *  ?
	 * >> bitshift
	 * <<
	 * ^  xor
	 * ~  not
	 */
	
	/*
	 * 1
	 */
}

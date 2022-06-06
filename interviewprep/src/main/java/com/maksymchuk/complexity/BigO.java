package com.maksymchuk.complexity;

public class BigO {

	/**
	 O(n) - linear. As n increases, so does time proportionally.  O(3n) is the same as O(n)
	 O(m+n) - 2 inputs, as they increase so does time proportionally
	 O(max(m,n)) -  Only one of the inputs, the bigger mattters 
	 O(1 or any other constant) - Constant time, inputs don't matter
     O(logn) what power do I need to power my base by to get n.  This is the case with algorithms that behave on trees or structures
     that half things like binary search or binary trees
     O(n*logn)  Quick sort or merge sort.  Log n levels and doing constant work n times in each level
     
     log8 is 3 because there are three levels of 2 to get 8
     2 4 8
     
     O(n squared).  Naive sorting algorithms.  Bubble sort, insertion sort.  Even if its O(1/2 * n squared) its still O(n squared)
     O(2 power n).  Exponential time.  Normally seen in backtracking nad recursive problems.  Recursive problems that create forks, 2 forks n levels deep?
     O(n!) factorial time.  For example permutations of the word cat.  C A T.  C forks twice, A forks twice, T forks twice.  on next level each level forks once.  3*2*1
     
     Balance between time and memory.  Time goes down as memory goes up.  Increase space, lower time is best usuall
     
     Space complexity is same as time complexity.  How does the space usage by our algorithm change as the problem gets very large

     Tips: Sorted array, binary search, log(n)
     
     Big O Growth Heirarchy
     GOOD
     O(1) constant                  - understand
     O(Log n) logarithmic           - binary search because we divide the array by 2 every time - easy peasy
     O(n) linear                    - understand
     O(n log n) linearithmic        - merge sort
     O(n squared) quadric           - understand
     O(n cubed) cubic               - understand
     O(2 power n) expnential
     O(n!) factorial	
     BAD
     
     A logarithm is the power a number needs to be raised to to get some other number	
     log
     
     2 pow(x) = 8
     written as: log subscript(2) 8 = x
     said as log base 2 of 8 is 3
     
     
	 */
	int level = 0;
	
	public int logFuncRecursive(int n) {
		while (n > 1)
		{
			level++;
			n = n/2;
			return logFuncRecursive(n);				
		}
		return level;
				
	}
	
	public int logFuncIterative(int n) {
		level = 0;
		while (n > 1)
		{
			level++;
			n = n/2;				
		}
		return level;
				
	}
	
	public int nLogN(int n) 
	{
		int y = n;
		while (n != 1)
		{
			for (int i = 0 ; i < y; i++)
			{
				// do some thing n times
			}
			n = n/2;
		}
		return n;
	}
}

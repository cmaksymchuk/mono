package com.maksymchuk.cci;

public class JumpGame {
// You are given an integer array nums. You are initially positioned 
// at the array's first index, and each element in the array represents 
// your maximum jump length at that position.
// Return true if you can reach the last index, or false otherwise.
	
//	Input: nums = [2,3,1,1,4]
//	Output: true
//	Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//	              0,1,2,3,4
// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
	public boolean jump(int[] nums)
	{
		boolean possible = true;
		
		for (int i = 0 ; i < nums.length-1; i++)
		{
			if (nums[i] == 0)
			{
				possible = false;
				int zeroIndex = i;
				// look backward for something that can jump the square
				for (int j = zeroIndex-1; j >= 0; j--)
				{
					if (nums[j] >= zeroIndex - j + 1)
					{
						possible = true;
						break;
						// all good, we can jump the 0
					}
					if (!possible)
					{
						break;
					}
				}
			}
		}
		return possible;
	}
}

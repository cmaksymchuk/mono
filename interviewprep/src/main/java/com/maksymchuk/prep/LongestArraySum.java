package com.maksymchuk.prep;

public class LongestArraySum {
	public static void main(String...strings)
	{
		int[] arr = new int[] {15,16,1,2,3,4,5,6,7,8,0,0,0,0,0};
		int sum = 15;
		findLongest(arr,sum);
		System.out.println();
		findLongest2(arr, sum);
		
	}
	
	public static void findLongest(int[] arr, int testSum)
	{
		int left = 0;
		int right = 0;
		
		int highestLeft = -1;
		int highestRight = -1;
		
		while (right < arr.length)
		{
			int sum = 0;
			for (int i = left ; i <= right; i++)
			{
				sum = sum + arr[i];
			}
			
			if (sum == testSum)
			{
				System.out.println(left + " " + right + " " + sum);
				if ((right - left) > (highestRight - highestLeft))
				{
					highestLeft = left;
					highestRight = right;
				}
				right++;
			}
			else if (sum < testSum)
			{				
				right++;
			}
			else if (sum > testSum )
			{
				if (left <= right)
				{
					left++;
				}
				if (left == right && left < arr.length)
				{
					left++;
					right++;
				}
			}
		}
		System.out.println(highestLeft + " " + highestRight);

	}
	
	public static void findLongest2(int[] arr, int testSum)
	{
		int left = 0;
		int right = 0;
		
		int highestLeft = -1;
		int highestRight = -1;
		int sum = 0;

		while (right < arr.length)
		{			
			if (sum == testSum)
			{
				System.out.println(left + " " + right + " " + sum);
				if ((right - left) > (highestRight - highestLeft))
				{
					highestLeft = left;
					highestRight = right;
				}
			}
			
			if (sum <= testSum)
			{				
				sum = incrementRight(arr,  right++,  sum);
			}
			else if (sum > testSum )
			{

				if (left == right && left < arr.length)
				{
					sum = incrementLeft(arr,  left++,  sum);
					sum = incrementRight(arr,  right++,  sum);
				}
				if (left <= right)
				{
					sum = incrementLeft(arr,  left++,  sum);
				}
			}
		}
		System.out.println(highestLeft + " " + highestRight);

	}
	
	public static int incrementLeft(int[] arr, int left, int sum)
	{
		return sum - arr[left];
	}
	
	public static int incrementRight(int[] arr, int right, int sum)
	{
		return sum + arr[right];
	
	}
}

package com.maksymchuk.prep;

/**
 * There is an integer array nums sorted in ascending order 
 * (with distinct values).
 * 
 * Prior to being passed to your function, nums is possibly rotated at an 
 * unknown pivot index k (1 <= k < nums.length) such that the resulting 
 * array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., 
 * nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated 
 * at pivot index 3 and become [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the possible rotation and an integer target, 
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
    	return search(nums, 0, nums.length -1, target);    	
    }
    
    private int search(int[] nums, int start, int end, int target) {
    	int index = -1;
    	if (start == end)
    	{
    		return nums[start] == target ? start : -1; 
    	}
    	else 
    	{
    		int mid = (start + end) / 2;
    		if (nums[mid] == target)
    		{
    			return mid;
    		} 
    		else
    		{
    			// go left if 
    			// start <= target < mid
    			// or
    			// start > mid and target > start and target < end    			
    			if ((nums[start] <= target && target <= nums[mid])   				||
    				(nums[start] > nums[mid] && (target >= nums[start] || target < nums[mid])))
    			{
    				// go left if left is not rotated   
    				return search(nums, start, mid-1, target);
    				
    			}
    			else if ((nums[mid] <= target && target < nums[end])   				||
        				(nums[mid] > nums[end] && (target >= nums[mid] || target < nums[end])))
    			{
    				return search(nums, mid+1, end, target);
    			}
    			else
    			{
    				return -1;
    			}
    		}
    	}
    }
}

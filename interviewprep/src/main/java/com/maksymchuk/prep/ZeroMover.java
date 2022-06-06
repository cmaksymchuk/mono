package com.maksymchuk.prep;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ZeroMover {

	public void moveZeroesOne(int[] nums) {

		// first count the zeros

		// iterate through the list,
		// if the element is a zero, move right to the next element
		// if the element is non-zero, keep swapping the element with its leftward
		// neighbor until its leftward neighbor is non-zero

		System.out.println("Original: " + Arrays.toString(nums));

		if (nums != null && nums.length > 1) {
			long numberOfZeros = Arrays.stream(nums).filter(i -> i == 0).count();
			if (numberOfZeros != nums.length) {
				for (int leadPosition = 1; leadPosition < nums.length; leadPosition++) {
					compareAndSwap(leadPosition, nums);
				}
			}
		}

		System.out.println("Sorted: " + Arrays.toString(nums));
	}

	public void compareAndSwap(int index, int[] nums) {
		if (index >= 1) {
			int numAtIndex = nums[index];
			int numBeforeIndex = nums[index - 1];
			if (numAtIndex != 0 && numBeforeIndex == 0) {
				int temp = nums[index];
				nums[index] = nums[index - 1];
				nums[index - 1] = temp;
				compareAndSwap(index - 1, nums);
			}
		}
	}

	public void moveZeroes(int[] nums) {

		// first count the zeros

		// iterate through the list,
		// if the element is a zero, move right to the next element
		// if the element is non-zero, keep swapping the element with its leftward
		// neighbor until its leftward neighbor is non-zero

		System.out.println("Original: " + Arrays.toString(nums));

		if (nums != null && nums.length > 1) {
			int numberOfZeros = Long.valueOf(Arrays.stream(nums).filter(i -> i == 0).count()).intValue();
			
			// remove the zeros
			if (numberOfZeros != nums.length && numberOfZeros != 0) {				
				int lag = findFirstIndex(nums, 0);
				if (lag != nums.length - 1)
				{
					
					for (int lead = lag+1 ; lead < nums.length; lead++)
					{
						if (nums[lead] != 0)
						{
							nums[lag] = nums[lead];
							lag++;							
						}
					}
				}
				
				for (int j = nums.length - numberOfZeros; j < nums.length; j++) {
					nums[j] = 0;
				}
				
			}
			
			
			
		}

		System.out.println("Sorted: " + Arrays.toString(nums));
	}

	public int findFirstIndex(int nums[], int target) {
		return IntStream.range(0, nums.length).filter(i -> target == nums[i]).findFirst().orElse(-1); // return -1 if the
																								// target is not found

	}

}

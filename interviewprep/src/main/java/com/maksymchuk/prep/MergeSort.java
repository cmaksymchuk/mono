package com.maksymchuk.prep;
import java.util.Arrays;
import java.util.stream.Stream;

public class MergeSort {
	
	public int[] mergeSort(int[] arr)
	{
		if (arr.length < 2) {
			return arr;
		}
		int[] leftArr = Arrays.copyOfRange(arr, 0, arr.length/2);
		int[] rightArr = Arrays.copyOfRange(arr, arr.length/2, arr.length);
		
		System.out.println("mergeSort left=" + Arrays.toString(leftArr) + " right=" + Arrays.toString(rightArr));
		return merge(mergeSort(leftArr), mergeSort(rightArr));
	}
	
	public int[] merge(int[] leftArray, int[] rightArray)
	{
		int[] resultArr = new int[leftArray.length + rightArray.length];
		int resultIndex = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		
		while (leftIndex < leftArray.length && rightIndex < rightArray.length)
		{
			if (leftArray[leftIndex] < rightArray[rightIndex])
			{
				resultArr[resultIndex] = leftArray[leftIndex];
				leftIndex++;
			}
			else
			{
				resultArr[resultIndex] = rightArray[rightIndex];
				rightIndex++;
			}
			resultIndex++;		
		}
		for (int i = leftIndex; i < leftArray.length; i++)
		{
			resultArr[resultIndex++] = leftArray[i];
		}
		for (int i = rightIndex; i < rightArray.length; i++)
		{
			resultArr[resultIndex++] = rightArray[i];
		}
		System.out.println("merge left=" + Arrays.toString(leftArray) + " right=" + Arrays.toString(rightArray) + " into=" + Arrays.toString(resultArr));
		return resultArr;
	}

}

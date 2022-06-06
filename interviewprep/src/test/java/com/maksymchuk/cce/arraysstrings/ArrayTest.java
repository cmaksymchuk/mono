package com.maksymchuk.cce.arraysstrings;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ArrayTest {

	/**
	 * To resize an array	 
		1) Create a new array of the desired size, and copy the contents from the original array to the new array, using java.lang.System.arraycopy(...);
		2) Use the java.util.ArrayList<T> class, which does this for you when you need to make the array bigger. It nicely encapsulates what you describe in your question.
		3) Use java.util.Arrays.copyOf(...) methods which returns a bigger array, with the contents of the original array.
	*/
	
	@Test
	public void arrayCopy1()
	{
		int[] arr = new int[] {1,2,3};
		int[] arrBigger = new int[6];
		System.arraycopy(arr, 0, arrBigger, 0, 1);
		System.out.println("arr:       " + Arrays.toString(arr));
		System.out.println("arrBigger  " + Arrays.toString(arrBigger));
//		arr:       [1, 2, 3]
//		arrBigger  [1, 0, 0, 0, 0, 0]
	}
	
	@Test
	public void arrayCopy2()
	{
		int[] arr = new int[] {1,2,3};
		int[] arrBigger = new int[6];
		System.arraycopy(arr, 0, arrBigger, 0, 3);
		System.out.println("arr:       " + Arrays.toString(arr));
		System.out.println("arrBigger  " + Arrays.toString(arrBigger));
//		arr:       [1, 2, 3]
//		arrBigger  [1, 2, 3, 0, 0, 0]
	}
	
	@Test
	public void arrayCopy3()
	{
		int[] arr = new int[] {1,2,3};
		int[] arrBigger = new int[6];
		System.arraycopy(arr, 0, arrBigger, 4, 3);
		System.out.println("arr:       " + Arrays.toString(arr));
		System.out.println("arrBigger  " + Arrays.toString(arrBigger));
		// index out of bounds
	}
	
	@Test
	public void arraysCopyOf()
	{
		int[] arr = new int[] {1,2,3};
		int[] arrBigger = Arrays.copyOf(arr, arr.length * 3);
		System.out.println("arr:       " + Arrays.toString(arr));
		System.out.println("arrBigger  " + Arrays.toString(arrBigger));
		// index out of bounds
	}

}

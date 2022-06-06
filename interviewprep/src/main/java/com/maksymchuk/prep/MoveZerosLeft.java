package com.maksymchuk.prep;
import java.util.Arrays;

public class MoveZerosLeft {
	
	public static void main(String...strings)
	{
		int[] arr = new int[] {1,10,20,0,59,63,0,88,0};
        System.out.println(Arrays.toString(arr));
        arr = moveLeft(arr);
        System.out.println(Arrays.toString(arr));
	}
	
	public static int[] moveLeft(int[] arr)
	{
		int ri = arr.length - 1;
		int wi = arr.length - 1;
		
		while (ri >= 0)
		{
			if (arr[ri] != 0)
			{
				arr[wi] = arr[ri];
				wi--;
			}
			ri--;
		}
		while (wi >= 0)
		{
			arr[wi] = 0;
			wi--;
		}		

		return arr;

	}
}

package com.maksymchuk.prep;

import java.util.Arrays;

public class SortOnMultiDimensionalArray {
	static Object[][] fields = {{
	      "sam", "mccarty",
	      "m", "1988/06/01", 5.0, true
	   },
	   {
	      "tom", "huges",
	      "m", "1988/06/01", 7.0, true
	   },
	   {
	      "jim", "ross",
	      "m", "1988/06/01", 6.5, true
	   }
	};
	
	public static void main(String... args)
	{
		System.out.println(Arrays.deepToString(fields));
		Arrays.sort(fields, (o1,o2) -> Double.compare((Double) o1[4], (Double) o2[4]));
		System.out.println(Arrays.deepToString(fields));
	}
}

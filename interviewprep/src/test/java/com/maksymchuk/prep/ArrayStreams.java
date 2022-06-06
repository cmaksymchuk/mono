package com.maksymchuk.prep;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayStreams {
	
	public static void main(String[] args)
	{
		  String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

		  // array to a stream
		  Stream<String[]> stream1 = Arrays.stream(array);
		  

		  // same result
		  Stream<String[]> stream2 = Stream.of(array);

	}

}

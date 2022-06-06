package com.maksymchuk.graph;

import java.util.Arrays;

public class IntArraySerializer {

	public String serialize(Integer[] ints) {
		return ints == null ? "[]" : Arrays.toString(ints);
	}

	public Integer[] deSerialize(String string) {
		Integer[] result = new Integer[] {};
		if (string != null ) {
			string = string.replace("[", "").replace("]", "");
			if (string.length() > 0)
			{
				String[] strings = string.split(", ",-1);
				result = new Integer[strings.length];
				for (int i = 0; i < result.length; i++) {
					result[i] = new Integer(strings[i]);
				}	
			}		
		}
		return result;
	}
}

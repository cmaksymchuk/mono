package com.maksymchuk.prep;

import java.util.Comparator;

public class StringComparatorWithReference implements Comparator<String> {

	private int referenceLength = 0;
	public StringComparatorWithReference(int referenceLength)
	{
		this.referenceLength = referenceLength;
	}
	@Override
	public int compare(String o1, String o2) {
		int o1Length = o1 == null ? 0 : Math.abs(referenceLength - o1.length());
		int o2Length = o2 == null ? 0 : Math.abs(referenceLength - o2.length());
		
		return o1Length - o2Length;
	}	
}

package com.maksymchuk.prep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, calculate the ratios of its elements that are 
 * positive, negative, and zero. Print the decimal value of each fraction on 
 * a new line with  places after the decimal.
 * 
 * @author cmaksym
 */
public class RationsPlusMinusZero {
	
	public Map<Integer, Double> rations(int[] nums)
	{
		Map<Integer, Double> ratios = new HashMap<Integer, Double>();
		
		
		
		long negative = Arrays.stream(nums).filter(i -> i < 0).count();
		long positive = Arrays.stream(nums).filter(i -> i > 0).count();
		long zero = nums.length - negative - positive;
		
		ratios.put(-1, Double.valueOf(negative/nums.length));
		ratios.put(1, Double.valueOf(positive/nums.length));
		ratios.put(0, Double.valueOf(zero/nums.length));
		
		return ratios;
	}

}

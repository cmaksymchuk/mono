package com.maksymchuk.prep;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	Map<Integer, Integer> intCount = new HashMap<Integer, Integer>();

	public int majorityElement(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int occurrences = 0;
			if (intCount.containsKey(num)) {
				occurrences = intCount.get(num);
			}
			occurrences++;
			if (occurrences > nums.length / 2) {
				return num;
			} else {
				intCount.put(num, occurrences);

			}

		}
		return -1;
	}
}

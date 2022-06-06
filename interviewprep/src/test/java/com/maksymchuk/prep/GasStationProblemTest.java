package com.maksymchuk.prep;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class GasStationProblemTest {
	GasStationProblem gsp = new GasStationProblem();
	
	int[] gas = new int[]  {1,5,3,3,5,3,1,3,4,5};
	int[] cost = new int[] {5,2,2,8,2,4,2,5,1,2};
	int[] diff = new int[] {-4,3,1,-5,3,-1,-1,-2,3,3};

	Map<Integer, Integer> goNeg = new HashMap<Integer, Integer>();
	
	
	@Test
	void test() {
//		gsp.findIndex(gas, cost);
//		gsp.traverse(gas, 1);
		gsp.findIndex(gas, cost);
	}

}

package com.maksymchuk.prep;

import java.util.function.BiFunction;

public class GameOfLifeFunction implements BiFunction<Integer, Integer, Integer> {

	@Override	
	public Integer apply(Integer val, Integer neighbors) {
		if (fewerThanTwoLiveNeighborsDies(val, neighbors)) {
			return 0;
		} else if (twoOrThreeLiveNeighborsLives(val, neighbors)) {
			return 1;
		} else if (moreThanThreeLiveNeighborsDies(val, neighbors)) {
			return 0;
		} else if (exactlyThreeLiveNeighborsTurnsLiving(val, neighbors)) {
			return 1;
		} 
		return val;
	}


	public boolean fewerThanTwoLiveNeighborsDies(Integer val, Integer neighbors) {
		return val == 1 && neighbors < 2;
	}

	public boolean twoOrThreeLiveNeighborsLives(Integer val, Integer neighbors) {
		return val == 1 && (neighbors == 2 || neighbors == 3);
	}

	public boolean moreThanThreeLiveNeighborsDies(Integer val, Integer neighbors) {
		return val == 1 && neighbors > 3;
	}

	public boolean exactlyThreeLiveNeighborsTurnsLiving(Integer val, Integer neighbors) {
		return val == 0 && neighbors == 3;
	}
}

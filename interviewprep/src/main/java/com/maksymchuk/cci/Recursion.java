package com.maksymchuk.cci;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Recursion {

	/*
	 * A child is running up a staircase with n steps and can hop either 1 step, 2
	 * steps, or 3 steps at a time. Implement a method to count how many possible
	 * ways the child can run up the stairs.
	 */
	int completedPath = 0;

	public int trippleStep(int stepsRemaining) {
		int totalPaths = 0;
		int maxStepsCanTake = Math.min(stepsRemaining, 3);

		for (int i = 1; i <= maxStepsCanTake; i++) {
			totalPaths += trippleStep(stepsRemaining - i);
		}
		if (stepsRemaining == 0) {
			totalPaths++;
		}
		return totalPaths;
	}

	/**
	 * There is a robot on an m x n grid. The robot is initially located at the
	 * top-left corner (i.e., grid[0][0]). The robot tries to move to the
	 * bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
	 * either down or right at any point in time. Given the two integers m and n,
	 * return the number of possible unique paths that the robot can take to reach
	 * the bottom-right corner. The test cases are generated so that the answer will
	 * be less than or equal to 2 * 109.
	 * 
	 * @param xLen
	 * @param yLen
	 * @return
	 */
	public int robotOnGrid(int xLen, int yLen) {
		System.out.println("(" + xLen + "," + yLen + ")");
		int sum = 0;

		if (0 < xLen - 1) {
			sum += robotOnGrid(xLen - 1, yLen);
		}
		if (0 < yLen - 1) {
			sum += robotOnGrid(xLen, yLen - 1);
		}

		if (0 == xLen - 1 && 0 == yLen - 1) {
			// we are at the end;
			System.out.println("bingo");
			return 1;
		}
		return sum;
	}

	/**
	 * Magic Index: A magic index in an array A [ 0... n -1] is defined to be an
	 * index such that A[ i] = i. Given a sorted array of distinct integers, write a
	 * method to find a magic index, if one exists, in array A.
	 */
	public int magicIndex(int[] arr) {

		if (null == arr || arr.length == 0) {
			return -1;
		}

		return magicIndex(0, arr.length - 1, arr);
	}

	private int magicIndex(int startAt, int endAt, int[] arr) {
		int sliceLength = endAt - startAt + 1;
		int sliceLengthDivTwo = sliceLength / 2;

		int midPointIndex = startAt + sliceLengthDivTwo;
		int valueAtMidpointIndex = arr[midPointIndex];

		if (valueAtMidpointIndex == midPointIndex) {
			return midPointIndex;
		} else if (startAt == endAt) {
			return -1;
		}

		if (valueAtMidpointIndex < midPointIndex) {
			return magicIndex(midPointIndex + 1, endAt, arr);
		}
		if (valueAtMidpointIndex > midPointIndex) {
			return magicIndex(startAt, midPointIndex - 1, arr);
		}
		return -1;
	}

	/*
	 * Given an integer array nums of unique elements, return all possible subsets
	 * (the power set). The solution set must not contain duplicate subsets. Return
	 * the solution in any order. Input: nums = [1,2,3] Output:
	 * [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
	 */
	public int[][] subsetOfSets(int[] set) {

		Set<Set<Integer>> setOfSets = new HashSet<Set<Integer>>();
		for (int n = 0; n <= set.length; n++) {
			allPossibleSetsOfLengthN(n, set, new HashSet<Integer>(), setOfSets);
		}
		System.out.println(setOfSets);
		return null;
	}

	private void allPossibleSetsOfLengthN(int setLength, int[] originalSet, Set<Integer> setUntilNow,
			Set<Set<Integer>> totalSets) {
		totalSets.add(setUntilNow);
		for (int i = 0; i < originalSet.length; i++) {
			if (setUntilNow.size() < setLength && !setUntilNow.contains(originalSet[i])) {
				Set<Integer> newSet = new HashSet<Integer>(setUntilNow);
				newSet.add(originalSet[i]);
				if (newSet.size() == setLength) {
					totalSets.add(newSet);
				} else {
					allPossibleSetsOfLengthN(setLength, originalSet, newSet, totalSets);
				}
			}
		}
	}

	public int recursiveMultiply(int x, int y) {
		// keep adding x, y times
		int sum = 0;
		if (y == 0) {
			return sum;
		} else {
			return x + recursiveMultiply(x, y - 1);
		}
	}

	public List<String> permutationsWithoutDupes(String s) {
		List<String> permutations = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			permutations.addAll(permutations(s, i));
		}

		return permutations;

	}

	private List<String> permutations(String s, int charAtIndex) {
		List<String> permutations = new ArrayList<String>();
		String sWithoutCharAt = s.substring(0, charAtIndex) + s.substring(charAtIndex + 1, s.length());
		char charAt = s.charAt(charAtIndex);

		for (int i = 0; i <= sWithoutCharAt.length(); i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(sWithoutCharAt.substring(0, i));
			sb.append(Character.toString(charAt));
			sb.append(sWithoutCharAt.substring(i, sWithoutCharAt.length()));
			permutations.add(sb.toString());
		}
		System.out.println(permutations);
		return permutations;
	}

	public int sumAllPositiveValuesUpToN(int n) {
		if (n == 0) {
			return 0;
		} else {
			return n + sumAllPositiveValuesUpToN(n - 1);
		}
	}

	/**
	 * https://www.youtube.com/watch?v=ngCos392W4w&ab_channel=Reducible
	 * 
	 * 1. What is the simplest possible input. This often gives us the base case 2.
	 * Play with samples and visualize 3. Relate simple cases to harder cases 4.
	 * Generalize the pattern 5. Write code that combines the recursive pattern with
	 * the base case
	 * 
	 * @param x
	 * @param y
	 * @return
	 */

	public int numPathsNmGrid(int x, int y) {
		if (x == 1 || y == 1) {
			// if either path is 1 deep, there is only 1 path
			return 1;
		}

		else {
			return numPathsNmGrid(x - 1, y) + numPathsNmGrid(x, y - 1);
		}
	}

	public Set<Set<Integer>> subsetOfSetsIterative(int[] set) {
		Set<Set<Integer>> subsets = new HashSet<Set<Integer>>();
		// add empty set
		subsets.add(new HashSet<Integer>());
		for (int i = 0; i < set.length; i++) {
			subsetOfSets(subsets, set[i]);
		}
		return subsets;
	}

	private void subsetOfSets(Set<Set<Integer>> subsets, int toAdd) {
		Set<Set<Integer>> subsetsToAdd = new HashSet<Set<Integer>>();

		for (Set<Integer> subset : subsets) {
			Set<Integer> newSet = new HashSet<Integer>(subset);
			newSet.add(toAdd);
			subsetsToAdd.add(newSet);
		}
		subsets.addAll(subsetsToAdd);
	}

}

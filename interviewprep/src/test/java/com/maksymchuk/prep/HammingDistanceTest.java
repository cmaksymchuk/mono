package com.maksymchuk.prep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HammingDistanceTest {

	HammingDistance hd = new HammingDistance();

	void test() {
		assertEquals(7, hd.apply(7, 4));
	}

	private void printBinary(int... x) {
		for (int i = 0; i < x.length; i++) {
			String s = Integer.toBinaryString(x[i]);
			System.out.println(s);
		}
	}

	private void printInt(String s) {
		System.out.println(Integer.parseInt(s, 2));

	}

}

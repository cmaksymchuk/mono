package com.maksymchuk.shopify.space;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpaceShipTest {
	
	SpaceShipInterface ss;
	
	@BeforeEach
	public void setUp() {
		ss = new SpaceShip(0, 0, 0, 5, 1, -5, 5);
	}

	@Test
	void testIncreaseSpeedNormal() {
		assertEquals(0, ss.getSpeed());
		ss.changeSpeed(1);
		assertEquals(1, ss.getSpeed());
	}


	@Test
	void testIncreaseSpeedToMax() {
		assertEquals(0, ss.getSpeed());
		ss.changeSpeed(5);
		assertEquals(5, ss.getSpeed());
	}
	
	@Test
	void testIncreaseSpeedAboveMax() {
		assertEquals(0, ss.getSpeed());
		ss.changeSpeed(6);
		assertEquals(5, ss.getSpeed());
	}
	
	
	@Test
	void testDecreaseSpeed() {
		ss.setSpeed(2);
		assertEquals(2, ss.getSpeed());
		ss.changeSpeed(-1);
		assertEquals(1, ss.getSpeed());
	}

	@Test
	void testDecreaseSpeedBelowMin() {
		ss.setSpeed(2);
		assertEquals(2, ss.getSpeed());
		ss.changeSpeed(-2);
		assertEquals(1, ss.getSpeed());
	}
	
	@Test
	void testDecreaseSpeedToMin() {
		ss.setSpeed(2);
		assertEquals(2, ss.getSpeed());
		ss.changeSpeed(-1);
		assertEquals(1, ss.getSpeed());
	}

	@Test
	void testMoveLeft() {
		assertEquals(0, ss.getyCoord());
		ss.moveLeft();
		assertEquals(-1, ss.getxCoord());
	}
	
	@Test
	void testMoveRight() {
		assertEquals(0, ss.getyCoord());
		ss.moveRight();
		assertEquals(1, ss.getxCoord());
	}

}

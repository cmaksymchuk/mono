package com.maksymchuk.prep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RobotTest {

	@Test
	void test() {
		Robot robot = new Robot(new int[10][10]);
		System.out.println(robot.toString());
		for (int i = 0 ; i < 15; i++)
		{
			robot.moveDown();
			System.out.println(robot.toString());	
		}
		for (int i = 0 ; i < 15; i++)
		{
			robot.moveRight();
			System.out.println(robot.toString());	
		}
		for (int i = 0 ; i < 15; i++)
		{
			robot.moveLeft();
			System.out.println(robot.toString());	
		}
		for (int i = 0 ; i < 15; i++)
		{
			robot.moveUp();
			System.out.println(robot.toString());	
		}
	}

}

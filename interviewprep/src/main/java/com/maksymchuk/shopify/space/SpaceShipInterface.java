package com.maksymchuk.shopify.space;

public interface SpaceShipInterface {

	void moveForward();

	void moveLeft();

	void checkTrajectory();

	void moveRight();

	void changeSpeed(int howMany);
	
	void setMinSpeed(int minSpeed);

	void setSpeed(int speed);

	int getxCoord();

	int getyCoord();

	int getSpeed();

}
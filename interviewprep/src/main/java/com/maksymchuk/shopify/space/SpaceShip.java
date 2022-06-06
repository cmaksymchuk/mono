package com.maksymchuk.shopify.space;

public class SpaceShip implements SpaceShipInterface {
	private int xCoord = 0;
	private int yCoord = 0;
	
	private int speed = 0;
	private int maxSpeed = 5;
	private int minimumSpeed = 0;
	
	private int warnLeft = 5;
	
	public int getWarnLeft() {
		return warnLeft;
	}

	public void setWarnLeft(int warnLeft) {
		this.warnLeft = warnLeft;
	}

	public void setMinSpeed(int minimumSpeed) {
		this.minimumSpeed = minimumSpeed;
	}

	private int warnRight = 5;
	
	@Override
	public void moveForward()
	{
		this.yCoord += speed;
	}
	
	private void moveHorizontal(int howMany)
	{
		this.xCoord += howMany;
		checkTrajectory();
	}
	
	@Override
	public void moveLeft()
	{
		moveHorizontal(-1);
	}
	
	@Override
	public void checkTrajectory()
	{
		if (xCoord < warnLeft || xCoord > warnRight)
		{
			System.out.println("wrong trajectory");
		}
	}
	
	@Override
	public void moveRight()
	{
		moveHorizontal(1);
	}

	public SpaceShip(int xCoord, int yCoord, int speed, int maxSpeed, int minSpeed, int warnLeft, int warnRight) {
		super();
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.speed = speed;
		this.maxSpeed = maxSpeed;
		this.minimumSpeed = minSpeed;
		this.warnLeft = warnLeft;
		this.warnRight = warnRight;
	}
	
	@Override
	public void changeSpeed(int howMany)
	{
		setSpeed(howMany + speed);
	}
	
	@Override
	public void setSpeed(int speed) {
		if (this.maxSpeed < speed)
		{
			System.out.println("maximum speed");
		}
		if (this.minimumSpeed  > speed)
		{
			System.out.println("minimum speed");
		}
		this.speed = Math.max(Math.min(speed, maxSpeed), minimumSpeed);
	}

	@Override
	public int getxCoord() {
		return xCoord;
	}

	@Override
	public int getyCoord() {
		return yCoord;
	}

	@Override
	public int getSpeed() {
		return speed;
	}
}

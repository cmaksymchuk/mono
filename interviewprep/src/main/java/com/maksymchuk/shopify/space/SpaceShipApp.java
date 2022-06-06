package com.maksymchuk.shopify.space;

public class SpaceShipApp {
	
	SpaceShipInterface ss = new SpaceShip(0, 0, 0, 5, 1, -5, 5);
	
	public void init()
	{
        System.out.println(getCoordsString(ss) + " ready for launch");
	}
	
	public void increase()
	{
		ss.setMinSpeed(1);
		ss.changeSpeed(1);
		ss.moveForward();
		System.out.println(getCoordsString(ss));		
	}
	
	public void decrease()
	{
		ss.changeSpeed(-1);
		ss.moveForward();
		System.out.println(getCoordsString(ss));

	}
	public void left()
	{
		ss.moveLeft();
		ss.moveForward();
		System.out.println(getCoordsString(ss));
	}
	public void right()
	{
		ss.moveRight();
		ss.moveForward();
		System.out.println(getCoordsString(ss));
	}
	
	public void checkCoords()
	{
    	if (ss.getyCoord() > 250)
    	{
    		System.out.println("contact lost");
    	}
    	if (ss.getyCoord() == 250 && ss.getxCoord() == 0)
    	{
    		System.out.println("on the moon");
    	}
	}
	
	

	private String getCoordsString(SpaceShipInterface ss) {
		return "(" + ss.getxCoord() + "," + ss.getyCoord() + ")";
	}
	
	
}

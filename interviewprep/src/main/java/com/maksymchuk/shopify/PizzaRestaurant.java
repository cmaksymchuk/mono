package com.maksymchuk.shopify;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * I was told to design a pizza restaurant for an OOP interview. This was fine
 * until they told me to make it such that different restaurants are able to set
 * themselves up to have different prices for bases and sizes and could offer
 * their own particular set of toppings. I thought that the best way to set up
 * this was as a PizzaRestaurant class, which could be intialised with
 * particular prices and options.
 * 
 * @author cmaksym
 *
 */
public class PizzaRestaurant {

	static enum Topping {
		PEPPERONI, MUSHROOM, PINEAPPLE, SAUSAGE, HAM, ONION
	}

	static class Pizza //implements MenuItem
	{
		int baseSize;
		List<Topping> toppings;
		double price;
		
		public Pizza(int baseSize, List<Topping> toppings, double price) {
			this.baseSize = baseSize;
			this.toppings = toppings;
			this.price = price;
		}
		
		public double price()
		{
			return price;
		}
		
		public String description()
		{
			return baseSize + " inch " + toppings.stream().map(t -> t.toString()).collect(Collectors.joining(","));
		}
	}

	static class Menu {
		List<Pizza> pizzas;

		public Menu(List<Pizza> pizzas) {
			this.pizzas = pizzas;
		}		
	}
	
	static class Restaurant {
		Menu menu;

		public Restaurant(Menu menu) {		
			this.menu = menu;
		}
	}
	
	public static void main(String... args)
	{
		Pizza pepMushWinnipeg = new Pizza(
				12,
				Arrays.asList(new Topping[] {Topping.PEPPERONI}),
				1.50d
				);
		Menu winnipegMenu = new Menu(Arrays.asList(new Pizza[] {pepMushWinnipeg}));		
		Restaurant winnipeRestaurant = new Restaurant(winnipegMenu);
	}
	
	

}

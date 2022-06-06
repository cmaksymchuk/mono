package com.maksymchuk.cci;

import java.util.Arrays;

public class CoinChange {
	
	private int[] coins;
	
	public CoinChange(int... inputCoins)
	{
		coins = new int[inputCoins.length];
		for (int i = 0 ; i < inputCoins.length ; i++)
		{
			coins[i] = inputCoins[i];
		}		
		// sort the coins into numerical ascending order
		Arrays.sort(coins);
	}
	
	int minCoinsStandard(int change)
	{
		int count = 0;
		if (change < coins[0])
		{
			if (change == 0)
			{
				return 0;
			}
			else 
			{
				return -1;
			}
		}
		else
		{
			// loop through the coins from greatest to smallest
			for (int i = coins.length-1; i >= 0 ; i--)
			{
				if (coins[i] <= change)
				{
					change -= coins[i];
					count++;
					break;
				}
			}
		}
		int minCoins = minCoinsStandard(change);
		count = minCoins == -1 ? -1 : count + minCoins;
		return count;
		
			
		
	}
	
	int minCoinsNonStandard(int change)
	{
		int count = 0;
		if (change < coins[0])
		{
			if (change == 0)
			{
				return 0;
			}
			else 
			{
				return -1;
			}
		}
		else
		{
			// loop through the coins from greatest to smallest
			for (int i = coins.length-1; i >= 0 ; i--)
			{
				if (coins[i] <= change)
				{
					change -= coins[i];
					count++;
					break;
				}
			}
		}
		int minCoins = minCoinsStandard(change);
		count = minCoins == -1 ? -1 : count + minCoins;
		return count;
		
			
		
	}

}

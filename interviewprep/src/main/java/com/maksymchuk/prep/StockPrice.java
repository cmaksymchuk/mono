package com.maksymchuk.prep;

/**
 * 1 <= prices.length <= 105 0 <= prices[i] <= 104
 * 
 * @author cmaksym
 *
 */
public class StockPrice {
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			int lag = prices[i];
			for (int j = i + 1; j < prices.length; j++) {
				int lead = prices[j];
				if (maxProfit < (lead - lag)) {
					maxProfit = lead - lag;
				}
			}
		}
		return maxProfit;
	}

	public int maxProfit2(int[] prices) {
		int maxProfit = 0;
		int previousLag = 10000;
		for (int i = 0; i < prices.length - 1; i++) {
			int lag = prices[i];
			if (lag > previousLag) {
				for (int j = i + 1; j < prices.length; j++) {
					int lead = prices[j];
					if (maxProfit < (lead - lag)) {
						maxProfit = lead - lag;
					}
				}
			}
			previousLag = lag;
		}
		return maxProfit;
	}

	public int maxProfit3(int[] prices) {
//		return backwardsFrom(prices, 0);
		return 0;

	}

	/**
	 * 0 1 2 3 4 5 7,1,5,3,6,4
	 **/

	public int backwardsFrom(int[] prices, int index, Integer highestPriceSoFar) {
		int maxProfit = 0;

		if (index >= 0) {
			int valueAtIndex = prices[index];

			int profit = highestPriceSoFar - valueAtIndex;
			profit = profit > 0 ? profit : 0;
			
			maxProfit = Math.max(profit, maxProfit);

			if (valueAtIndex > highestPriceSoFar) {
				highestPriceSoFar = valueAtIndex;
			}
		}

		System.out.println(maxProfit);
		return maxProfit;
	}
	
	// https://gist.github.com/charlespunk/4700450	
	public int maxProfit4(int[] prices) {
	    if(prices==null||prices.length<=1)
	        return 0;
	 
	    int min=prices[0]; // min so far
	    int maxProfitSoFar=0;
	 
	    for(int i=1; i<prices.length; i++){
	        maxProfitSoFar = Math.max(maxProfitSoFar, prices[i]-min);
	        min = Math.min(min, prices[i]);
	    }
	 
	    return maxProfitSoFar;
	}
}

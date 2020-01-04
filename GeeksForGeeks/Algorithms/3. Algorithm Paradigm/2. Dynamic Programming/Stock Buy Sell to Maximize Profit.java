/* Implementation Algorithm */
/***
Step 1: Find the local minima and store it as starting index, If not exists return
Step 2: Find the local maxima and store it as ending index, If we reach the end, set the end as ending index.
Step 3: Update the solution (increment count of buy sell pairs)
Step 4: Repeat the above steps if end is not reached.
***/

import java.util.*;
import java.lang.*;
import java.io.*;

class Stock {
		int buy;
		int sell;
}	

class StockMaximize //Running time is O(n)
{
	public static void maximizeStockBuySell(int price[]){
		int n = price.length;
		if(n <= 1)
			return;

		ArrayList<Stock> list = new ArrayList<Stock>();
		int i = 0;
		int count = 0;
		while(i < n - 1) {

			while(i != n-1 && price[i] > price[i+1])
				i++;

			if(i == n-1)
				break;

			Stock stock = new Stock();
			stock.buy = i;

			while(i != n-1 && price[i + 1] > price[i])
				i++;

			stock.sell = i;
			list.add(stock);
			count++;
		}
		if(count == 0) {
			System.out.println("There is no day when buying the sell will make profit");
		} else {
			System.out.println(count);
			for(int j = 0; j < count; j++) {
				System.out.println("Buy on day: " + list.get(j).buy + "   " + "Sell on day: " + list.get(j).sell);	
			}
		}

	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int price[] = {100, 180, 260, 310, 40, 535, 695};
		maximizeStockBuySell(price);
	}
}

/* Reference: https://www.geeksforgeeks.org/stock-buy-sell/ */

/* Above solution is Misleading: Please lookup with http://codeforces.com/contest/867/problem/E */
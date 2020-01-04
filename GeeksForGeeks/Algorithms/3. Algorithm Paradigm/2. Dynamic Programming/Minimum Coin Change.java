import java.util.*;
import java.lang.*;
import java.io.*;

class CoinChanging //Running time is O(sum * input.size) Space O(sum)
{
	//This problem finds the number of coins require to achieve sum
	/* Tabulated Method using bottom up fashion */
	public static int coinChanging(int coins[], int sum) {
		int n = coins.length;
		int max = sum + 1;
		int dp[] = new int[sum + 1];
		Arrays.fill(dp, max);
		
		dp[0] = 0;

		for(int i = 1; i <= sum; i++) {
			for(int j = 0; j <coins.length; j++) {
				if(i >= coins[j]){
					dp[i]=  Math.min(dp[i], 1 + dp[i - coins[j]]);
				}
			}
		}
	return dp[sum] > sum ? -1 : dp[sum]; //number of coins is greater than the sum

	}

	public static void main (String[] args) throws java.lang.Exception
	{
		int coins[] = {1, 5, 6, 8};
		int n = coins.length; //number of elements
		int sum = 11; 
		System.out.println(coinChanging(coins, sum));
		
	}
}

/***

TODO:

1. Top Down Approach
2. Print Combinations
3. Check above solution for boundary cases

***/
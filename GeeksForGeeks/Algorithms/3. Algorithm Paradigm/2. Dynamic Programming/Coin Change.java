import java.util.*;
import java.lang.*;
import java.io.*;

class CoinChanging //Running time is O(mn)
{

	/* Tabulated Method using bottom up fashion */
	public static int coinChanging(int coins[], int sum) {
		int n = coins.length;
		int table[][] = new int[n + 1][sum + 1];

		for(int i = 0; i <= n; i++)
			table[i][0] = 1;

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= sum; j++) {
				if(j < coins[i - 1]){
					table[i][j] = table[i - 1][j];
				} else {
					table[i][j] = table[i - 1][j] + table[i][j - coins[i - 1]];
				}
			}
		}
		/* Print Table */
		/*
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= sum; j++) {
				System.out.print(table[i][j] +" ");
			}
			System.out.println();
		}
		
		*/
	return table[n][sum];

	}
	
	/* Space Optimized Solution using DP */ 
	public static int coinChangingSpace(int coins[], int sum) { //O(n) space 
		int table[] = new int[sum + 1];
		table[0] = 1; //base case


		for(int i = 0; i < coins.length; i++) {
			for(int j = 1; j <= sum; j++) {
				if(j >= coins[i])
					table[j] += table[j - coins[i]];
			}
		}
		return table[sum];
	}


    public static void printActualSolution(List<Integer> result, int sum,int coins[],int pos){
        if(sum == 0){
            for(int r : result){
                System.out.print(r + " ");
            }
            System.out.print("\n");
        }
        for(int i=pos; i < coins.length; i++){
            if(sum >= coins[i]){
                result.add(coins[i]);
                printActualSolution(result,sum-coins[i],coins,i);
                result.remove(result.size()-1);
            }
        }
    }

	public static void printCoinChangingSolution(int coins[], int sum){
        List<Integer> result = new ArrayList<>();
        CoinChanging.printActualSolution(result, sum, coins, 0);
    }
    

	public static void main (String[] args) throws java.lang.Exception
	{
		int coins[] = {1, 2, 5};
		int n = coins.length; //number of elements
		int sum = 12; 
		System.out.println(coinChanging(coins, sum));
		System.out.println(coinChangingSpace(coins, sum));
		printCoinChangingSolution(coins, sum);
	}
}

/***

Reference for printing solutions: https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChanging.java

TODO: Understand the Print Recursive function

***/
import java.util.*;
import java.lang.*;
import java.io.*;

class SubsetSum
{
	public static void findPath(boolean subset[][], int set[], int sum) {
		int i = set.length;
		int j = sum;
		System.out.print("The subset is ");
		while(true) {
			if(subset[i - 1][j]){
				i = i - 1;
				continue;
			} else {
				System.out.print(set[i - 1] + " ");
				j = j - set[i - 1];
				if(j <= 0)
					break;
			}
		}
		System.out.println();
	}

	public static boolean isSubsetSum(int set[], int n, int sum) {
		
		
		boolean subset[][] = new boolean[n + 1][sum + 1];

		for(int i = 0; i <= n; i++)
			subset[i][0] = true;

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= sum; j++) {
				if(j < set[i - 1]){
					subset[i][j] = subset[i - 1][j];
				} else {
					subset[i][j] = subset[i -1][j] || subset[i - 1][j - set[i - 1]];
				}
			}
		}
		/* Print Table */
		// for(int i = 1; i <= n; i++) {
		// 	for(int j = 1; j <= sum; j++) {
		// 		System.out.print(subset[i][j] +" ");
		// 	}
		// 	System.out.println();
		// }
		if(subset[n][sum])
			findPath(subset, set, sum);
	return subset[n][sum];

	}

	public static boolean partition(int set[]) {
		int n = set.length;
		int sum = 0;
		for(int i = 0; i < set.length; i++)
			sum+=set[i];

		if(sum % 2 != 0)
			return false;
		sum = sum / 2;

		boolean subset[][] = new boolean[n + 1][sum + 1];
		for(int i = 0; i <= n; i++)
			subset[i][0] = true;

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= sum; j++) {
				if(j < set[i - 1]){
					subset[i][j] = subset[i - 1][j];
				} else {
					subset[i][j] = subset[i -1][j] || subset[i - 1][j - set[i - 1]];
				}
			}
		}
		return subset[n][sum];

	}

	/* Space optimized Partition */
	class Solution {
	    public boolean canPartition(int[] nums) {
	        int n = nums.length;
	        int sum = 0;
	        for (int i : nums)
	            sum += i;

	        if(sum % 2 != 0) return false;
	        sum = sum / 2;

	        boolean[] dp = new boolean[sum+1];
	        dp[0] = true; //Base case: dp[0] is true; (zero number consists of sum 0 is true)

	        for (int i = 0; i < n; i++) {
	            for (int j = sum; j >= nums[i]; j--) {
	                    dp[j] = dp[j] || dp[j-nums[i]];
	            }
	        }
	        return dp[sum];
	    }
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		int set[] = {3, 34, 4, 12, 5, 2};
		int n = set.length; //number of elements
		int sum = 19; 
		System.out.println(isSubsetSum(set, n, sum));
		int set2[] = {1, 3, 5, 5, 2, 1, 1, 6};
		System.out.println(partition(set2));
	}
}

/***

1. The naive recursive solution for the above problem is exponential, since it will check for all the subsets of given set. 
In fact, the problem is NP-complete (i.e. There is no known polynomial time solution for the given problem).

We can solve the problem in pseudo-polynomial time using Dynamic Programming. We will use tabulation to fill up the boolean [][]array in bottom up fashion.

Time complexity -  O(input.size * total_sum)
Space complexity - O(input.size * total_sum)

2. partition: Find whether given an array can be split it up into 2 equal sum partitions. Partition need not be equal sized. Just equal sum.

***/
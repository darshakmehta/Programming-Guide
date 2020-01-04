import java.util.*;
import java.lang.*;
import java.io.*;

class Partition //partition: Find whether given an array can be split it up into 2 equal sum partitions. Partition need not be equal sized. Just equal sum.
{
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

	public static void main (String[] args) throws java.lang.Exception
	{
		int set2[] = {1, 3, 5, 5, 2, 1, 1, 6};
		System.out.println(partition(set2));
	}
}

/***

1. The naive recursive solution for the above problem is exponential, since it will check for all the subsets of given set. In worst case, this solution tries two possibilities (whether to include or exclude) for every element.
In fact, the problem is NP-complete (i.e. There is no known polynomial time solution for the given problem).

We can solve the problem in pseudo-polynomial time using Dynamic Programming. We will use tabulation to fill up the boolean [][]array in bottom up fashion.

Time complexity -  O(input_size * total_sum)
Space complexity - O(input_size * total_sum)

***/
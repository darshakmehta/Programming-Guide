import java.util.*;
import java.lang.*;
import java.io.*;

class WaysToCoverDistance
{
	public static int findWaysToCoverDistance(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n];
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = 10;
		System.out.println(findWaysToCoverDistance(n));
	}
}


/***

Naive Solution is exponential, in worst case O(3^n)
DP Solution is O(n)

Similar Problems:
1. https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
2.

References: 
1. https://www.geeksforgeeks.org/count-number-of-ways-to-cover-a-distance/

***/
import java.util.*;
import java.lang.*;
import java.io.*;

class LongestIncreasingSubsequence
{
	public static int lis(int[] nums) { // O(N^2)
		int n = nums.length;
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			// initialize min. length of sequence at all indexes to 1
			dp[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				// can you add current element at index i to the sequence at index j
				// if yes, compare (sequence length at index i, 1 + length of sequence at index j)
				// choosee the max
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}
			}
		}

		int length = 1; // Minimum length of a subsequence

		for (int i = 0; i < n; i++) {
			if (dp[i] > length) {
				length = dp[i];
			}
		}

		return length;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int a[] =  {10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println("Length of the Longest Increasing Subsequence is: " + lis(a));
	}
}

// Solution: https://ideone.com/jWfsff

/**
 * The recursive solution of LIS is exponential.
 * We implement the LIS problem using DP, where running time is O(n ^ 2) and space is O(n)
 * TODO:
 * 1. Printing the DP solution in O(n ^ 2) time.
 * 2. Constructing and Implementing LIS in O(Nlogn) solution
 */

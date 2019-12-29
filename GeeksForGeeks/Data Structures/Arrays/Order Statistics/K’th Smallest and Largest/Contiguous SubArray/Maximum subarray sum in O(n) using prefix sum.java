/***

Given an Array of Positive and Negative Integers, find out the Maximum Subarray Sum in that Array.

Input1 : arr = {-2, -3, 4, -1, -2, 1, 5, -3}
Output1 : 7

Input2 : arr = {4, -8, 9, -4, 1, -8, -1, 6}
Output2 : 9

Kadane’s Algorithm solves this problem using Dynamic Programming approach in linear time. Here is another approach using Dynamic Programming and Prefix Sum to find out maximum subarray sum in Linear time.

Implementation:
1. Calculate the prefix sum of the input array.
2. Initialize : min_prefix_sum = 0, res = -infinite
3. Maintain a loop for i = 0 to n. (n is the size of the input array).
     a) cand = prefix_sum[i] – mini

     b) If cand is greater than res (maximum subarray sum so far), then update res by cand.


     c) If prefix_sum[i] is less than min_prefix_sum (minimum prefix sum so far), then update min_prefix_sum by prefix_sum[i].

4. Return res.

Code: https://ideone.com/Whyexd

**/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void prefixSumArray(int[] arr, int[] prefixSum, int n) {

		prefixSum[0] = arr[0];
		for (int i = 1; i < n; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i];
		}
	}

	public static int maxSubArray(int[] prefixSum, int n) {
		int result = Integer.MIN_VALUE;
		int min_prefix_sum = 0;

		for (int i = 0; i < n; i++) {
			result = Math.max(result, prefixSum[i] - min_prefix_sum);
			min_prefix_sum = Math.min(min_prefix_sum, prefixSum[i]);
		}

		return result;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] prefixSum = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		prefixSumArray(arr, prefixSum, n);

		System.out.println("Maximum sub Array Sum " + maxSubArray(prefixSum, n));

	}
}


/**

Time Complexity: O(n). It takes linear time to compute the prefix sum and takes constant time in each iteration of the for loop. Hence overall complexity is O(n).

**/
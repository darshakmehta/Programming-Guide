/***

Given an array arr[] of size n, its prefix sum array is another array prefixSum[] of same size such that the value of prefixSum[i] is arr[0] + arr[1] + arr[2] … arr[i].

Examples :

Input  : arr[] = {10, 20, 10, 5, 15}
Output : prefixSum[] = {10, 30, 40, 45, 60}

Code: https://ideone.com/GYk2gn
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

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int[] prefixSum = new int[n];
		prefixSumArray(arr, prefixSum, n);
		
		System.out.println("Prefix Sum Array");
		for (int i = 0; i < n; i++) {
			System.out.print(prefixSum[i] + " ");
		}
	}
}

// TC: O(n)

// #TODO: Applications - https://www.geeksforgeeks.org/prefix-sum-array-implementation-applications-competitive-programming/


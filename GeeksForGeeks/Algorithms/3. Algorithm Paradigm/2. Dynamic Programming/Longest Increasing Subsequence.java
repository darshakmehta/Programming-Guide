import java.util.*;
import java.lang.*;
import java.io.*;

class LongestIncreasingSubsequence
{
	public static int lis(int a[]) {
		int n = a.length;
		int lis[] = new int[n];

		for(int i = 0; i < n; i++)
			lis[i] = 1;

		for(int i = 1; i < n; i++) {
			for(int j = 0; j <= i - 1; j++) {
				if(a[i] > a[j]) {
					lis[i] = Math.max(1 + lis[j], lis[i]);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			if(max < lis[i])
				max = lis[i];
		}
		return max;

	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int a[] =  {10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println("Length of the Longest Increasing Subsequence is: " + lis(a));
	}
}

/***

The recursive solution of LIS is exponential.
We implement the LIS problem using DP, where running time is O(n ^ 2) and space is O(n)

TODO: 
1. Printing the DP solution in O(n ^ 2) time.
2. Constructing and Implementing LIS in O(Nlogn) solution

***/
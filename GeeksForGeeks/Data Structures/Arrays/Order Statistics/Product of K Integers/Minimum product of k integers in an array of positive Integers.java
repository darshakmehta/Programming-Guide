/***

Given an array of n positive integers. We are required to write a program to print the minimum product of k integers of the given array.

Input : 198 76 544 123 154 675
         k = 2
Output : 9348
We get minimum product after multiplying
76 and 123.

Input : 11 8 5 7 5 100
        k = 4
Output : 1400

The idea is simple, we find the smallest k elements and print multiplication of them.

Code: https://ideone.com/peNJDZ

**/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static int findProduct(int[] arr, int K) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int el : arr)
			minHeap.add(el);

		int result = 1;

		while(!minHeap.isEmpty() && K-- != 0) {
			result *= minHeap.poll();
		}

		return result;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int K = sc.nextInt();

		System.out.println("Product of " + K + " smallest integer is " + findProduct(arr, K));
	}
}

/**

Time Complexity : O(n * log n)

#TODO: Solve in O(n) time
1. https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/ 
2. https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/

*/
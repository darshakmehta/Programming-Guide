/*** 

Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the given array. It is given that all array elements are distinct. 

Input: A = [7, 10, 4, 3, 20, 15], K = 3
Output: 7

***/

/* 
	Method 1 - Sort array using O(n log n) algorithm and return element at k-1 index
	Code: https://ideone.com/GS73dc
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static int kthSmallestInt(int[] arr, int k) {
		Arrays.sort(arr); // Implement Merge sort or Heap Sort
		
		return arr[k - 1];
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr = new int[]{7, 10, 4, 3, 20, 15}; /* provided arr has all distinct elements */
		int K = 3;
		
		int result = kthSmallestInt(arr, K);
		System.out.println("Kth Smallest integer is " + result);
	}
}

/* TC: O(N log N) */

// Note: To kind Kth largest integer Reverse Sort and return K - 1

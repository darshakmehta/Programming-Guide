/***

Given an Array of Integers and an Integer value k, find out k non-overlapping sub-arrays which have k maximum sums.

Input : arr1[] = {4, 1, 1, -1, -3, -5, 6, 2, -6, -2}, 
             k = 3.
Output : Maximum non-overlapping sub-array sum1: 8, 
         starting index: 6, ending index: 7.
         
         Maximum non-overlapping sub-array sum2: 6, 
         starting index: 0, ending index: 2.
         
         Maximum non-overlapping sub-array sum3: -1, 
         starting index: 3, ending index: 3.

Input : arr2 = {5, 1, 2, -6, 2, -1, 3, 1}, 
           k = 2.
Output : Maximum non-overlapping sub-array sum1: 8, 
         starting index: 0, ending index: 2.

         Maximum non-overlapping sub-array sum2: 5, 
         starting index: 4, ending index: 7.

Prerequisite: Kadane’s Algorithm

Kadane’s algorithm finds out only the maximum subarray sum, but using the same algorithm we can find out k maximum non-overlapping subarray sums. The approach is:

Find out the maximum subarray in the array using Kadane’s algorithm. Also find out its starting and end indices. Print the sum of this subarray.
Fill each cell of this subarray by -infinity.
Repeat process 1 and 2 for k times.

Code: https://ideone.com/LKS1Vj

**/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void KMaxSubArray(int[] arr, int n, int K) {

		for (int k = 0; k < K; k++) {

			int max_so_far = Integer.MIN_VALUE;
			int max_ending_here = 0;

			int start_index = 0, end_index = 0, s = 0;

			for (int i = 0; i < n; i++) {
				max_ending_here += arr[i];

				if (max_so_far < max_ending_here) {
					max_so_far = max_ending_here;
					start_index = s;
					end_index = i;
				}
				
				if (max_ending_here < 0) {
					max_ending_here = 0;
					s = i + 1;
				} 
				
			}

			System.out.println("Maximum non-overlapping sub-arraysum" + 
                                (k + 1) + ": " +  max_so_far +  
                                ", starting index: " + start_index + 
                                ", ending index: " + end_index + "."); 

			// Replace all elements of the maximum subarray  
            // by -infinity. Hence these places cannot form  
            // maximum sum subarray again. 
            for (int j = start_index; j <= end_index; j++) 
                arr[j] = Integer.MIN_VALUE; 
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

		int K = sc.nextInt();

		KMaxSubArray(arr, n, K);
	}
}


/**

Time Complexity: The outer loop runs for k times and kadane’s algorithm in each iteration runs in linear time O(n). Hence the overall time complexity is O(k*n).

**/
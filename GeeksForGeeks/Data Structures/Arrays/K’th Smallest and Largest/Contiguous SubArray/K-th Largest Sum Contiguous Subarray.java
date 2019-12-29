/***

Given an array of integers. Write a program to find the K-th largest sum of contiguous subarray within the array of numbers which has negative and positive numbers.

Examples:

Input: a[] = {20, -5, -1} 
         k = 3
Output: 14
Explanation: All sum of contiguous 
subarrays are (20, 15, 14, -5, -6, -1) 
so the 3rd largest sum is 14.

Input: a[] = {10, -10, 20, -40} 
         k = 6
Output: -10 
Explanation: The 6th largest sum among 
sum of all contiguous subarrays is -10.

Code: https://ideone.com/ubpJvY
**/

/***

Method:
An efficient approach is store the pre-sum of the array in a sum[] array. We can find sum of contiguous subarray from index i to j as sum[j]-sum[i-1]

Now for storing the Kth largest sum, use a min heap (priority queue) in which we push the contiguous sums till we get K elements, once we have our K elements, check if the element is greater than the Kth element it is inserted to the min heap with popping out the top element in the min-heap, else not inserted . At the end the top element in the min-heap will be your answer.

**/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{

	public static int KthLargestSum(int[] arr, int n, int K) {

		int[] sum = new int[n + 1];
		sum[0] = 0;
		sum[1] = arr[0];

		for (int i = 2; i <= n; i++) {
			sum[i] = sum[i - 1] + arr[i - 1];
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		// loop to calculate the contigous subarray 
        // sum position-wise 
		for (int i = 1; i <= n; i++) {
			
			// loop to traverse all positions that 
            // form contiguous subarray 
            for (int j = i; j <= n; j++) {
            	// calculates the contiguous subarray 
                // sum from j to i index 
            	int x = sum[j] - sum[i - 1];

            	if (minHeap.size() < K)
            		minHeap.add(x);
            	else {
            		if (minHeap.peek() < x) {
            			minHeap.poll();
            			minHeap.add(x);
            		}
             	}
            }
		}

		return minHeap.poll();
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

		System.out.println("Contiguous " + K + "th/rd/nd/st Largest sum is " + KthLargestSum(arr, n, K));

	}
}


/**

Time complexity: O(n^2 log (k))
Auxiliary Space : O(k) for min-heap and we can store the sum array in the array itself as it is of no use.

**/
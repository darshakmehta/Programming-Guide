/***

Given an Array of Integers and an Integer value k, find out k sub-arrays(may be overlapping) which have k maximum sums.

Examples:

Input : arr = {4, -8, 9, -4, 1, -8, -1, 6}, k = 4
Output : 9 6 6 5

Input : arr = {-2, -3, 4, -1, -2, 1, 5, -3}, k= 3
Output : 7 6 5

Method for k-maximum sub-arrays:

1. Calculate the prefix sum of the input array.
2. Take cand, maxi and mini as arrays of size k. 
3. Initialize mini[0] = 0 for the same reason as previous.
4. for each value of the prefix_sum[i] do
       (i). update cand[j] value by prefix_sum[i] - mini[j]
       (ii). maxi will be the maximum k elements of maxi and cand
       (iii). if prefix_sum is minimum than all values of mini then 
              include it in mini and remove maximum element form mini
       // After the ith iteration mini holds k minimum prefix sum upto
       // index i and maxi holds k maximum overlapping sub-array sums 
       // upto index i.
5. return maxi 

Throughout this calculation method we keep maxi in non-increasing and mini in non-decreasing order.

Incomplete Code: https://ideone.com/Gie8CM

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

	public static void maxMerge(List<Integer> maxI, int[] canD, int K) {
		for (int i = 0, j = 0; i < K; i++, j++) {
			if (canD[j] > maxI.get(i)) {
				maxI.add(i, canD[j]);
				maxI.remove(K);
			}
		}
	}

	public static void insertMinI(List<Integer> minI, int[] prefixSumArr, int K) {
		for (int i = 0; i < K; i++) {
			if (prefixSumArr[i] < minI.get(i)) {
					minI.add(i, prefixSumArr[i]);
					minI.remove(K);
					break;
			}
		}
	}
	
	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void printList(List<Integer> arr) {
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
	}
 
	public static void KMaxOverlapSubArray(int[] arr, int n, int K) {
		int[] prefixSumArr = new int[n];
		prefixSumArray(arr, prefixSumArr, n);

		List<Integer> minI = new ArrayList<Integer>();
		List<Integer> maxI = new ArrayList<Integer>();
		int[] canD = new int[K];

		for (int i = 0; i < K; i++) {
			minI.add(i, Integer.MIN_VALUE);
			maxI.add(i, Integer.MAX_VALUE);
		}

		minI.add(0, 0);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < K; j++) {
				System.out.println("prefixSumArr " + prefixSumArr[i]);
				if (prefixSumArr[i] < 0 && minI.get(j) == Integer.MAX_VALUE) {
					canD[j] = (-(prefixSumArr[i]) - minI.get(j));
				} else {
					canD[j] = prefixSumArr[i] - minI.get(j);
				}
				System.out.println("canD " + canD[j]);
			}
			
			System.out.println("PrintmaxI");
			printList(maxI);
			
			System.out.println("PrintcanD");
			printArr(canD);
			
			maxMerge(maxI, canD, K);
			insertMinI(minI, prefixSumArr, K);
		}

		for (int el: maxI) {
			System.out.print(el + " ");
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
		
		KMaxOverlapSubArray(arr, n, K);
	}
}

// #TODO: Not working solution, resolve the problem for above problem

/**

Time Complexity: The ‘insertMini’ and ‘maxMerge’ functions runs in O(k) time and it takes O(k) time to update the ‘cand’ array. We do this process for n times. Hence, the overall time complexity is O(k*n).

**/
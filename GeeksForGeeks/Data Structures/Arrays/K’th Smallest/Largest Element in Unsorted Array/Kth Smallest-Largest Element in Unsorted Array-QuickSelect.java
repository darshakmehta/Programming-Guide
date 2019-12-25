/*** 

Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the given array. It is given that all array elements are distinct. 

Input: A = [7, 10, 4, 3, 20, 15], K = 3
Output: 7

***/

/* 
	Method 4 - Optimization over Method 1, if QuickSort is chosen
	Idea: Not do complete quick sort, but stop at the point where pivot itself is Kth smallest element.
	Also, Not recur on both left and right sides of pivot, but recur on one side based on the position of the pivot.
	Worst Case: O(n^2)
	Average Case: O(n)
	Code: https://ideone.com/nd8wJ2
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

	// This function returns kth smallest element  
    // in arr[low...high] using QuickSort based method.
	public static int kthSmallest(int[] arr, int low, int high, int K) {
		// If k is smaller than number of elements 
        // in array 
		 if (K > 0 && K <= high - low + 1) {

		 	// Partition the array around last  
            // element and get position of pivot  
            // element in sorted array 
		 	int position = partition(arr, low, high);

		 	// if position is same as K
		 	if (position - low == K - 1) {
		 		return arr[position];
		 	}

		 	// If position is more, recur for 
            // left subarray 
            if (position - low > K - 1) {
            	return kthSmallest(arr, low, position - 1, K);
            } else {
            	return kthSmallest(arr, position + 1, high, K - position + low - 1);
            }
		 }

		// If k is more than number of elements 
        // in array
		return -1;
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low;

		for (int j = low; j <= high - 1; j++) {
			if (arr[j] <= pivot) {
				if (i != j)
					swap(arr, i, j);
				i++;
			}
		}
		if (i != high) 
			swap(arr, i, high);
			
		return i;
	}
	
	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];

		for (int i = 0; i < size; i++)
			arr[i] = sc.nextInt();

		int K = sc.nextInt();

		System.out.println("Kth Smallest integer is " + kthSmallest(arr, 0, arr.length - 1, K));
	}
}

// Note: To kind Kth largest integer 
/*
	
*/
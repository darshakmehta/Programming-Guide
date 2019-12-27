/*** 

Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the given array. It is given that all array elements are distinct. 

Input: A = [7, 10, 4, 3, 20, 15], K = 3
Output: 7

***/

/* 
	Method 3 - 
	Step 1: Build a MaxHeap of first K elements (arr[0] to arr[K-1]) 
			[TC: The step 1 is O(K)]
	Step 2:  For each element, after the K’th element (arr[K] to arr[n-1]), compare it with root of MH.
				a) If the element is less than the root then make it root and call heapify for MH
				b) Else ignore it.
			[TC: The step 2 is O((n - K) * log K)]
	Step 3: Finally, root of the MH is the Kth smallest element.
	Code: https://ideone.com/Vix4tZ
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Heap {

	int heap_size;

	public int left(int i) {
		return i * 2;
	}

	public int right(int i) {
		return (i * 2 + 1);
	}

	public int parent(int i) {
		return (int) Math.floor(i / 2);
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void maxHeapify(int[] heapArr, int i) {
		int l = left(i);
		int r = right(i);
		int largest;
		
		if (l <= heap_size && heapArr[l] > heapArr[i])
			largest = l;
		else
			largest = i;
		if (r <= heap_size && heapArr[r] > heapArr[largest])
			largest = r;
		
		if (largest != i) {
			swap(heapArr, i, largest);
			maxHeapify(heapArr, largest);
		}
	}

	public void buildMaxHeap(int[] heapArr, int n) {
		for (int i = (int) Math.floor(n / 2); i >= 1; i--) {
			maxHeapify(heapArr, i);
		}
	}

	public int kthSmallestInt(int[] arr, int[] heapArr, int K) {
		for (int i = K + 1; i < arr.length; i++) {
			if (arr[i] < heapArr[1]) {
				heapArr[1] = arr[i];
				maxHeapify(heapArr, 1);
			}
		}
		return heapArr[1];
	}
}

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // number of elements
		int[] arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		int K = sc.nextInt();

		Heap heap = new Heap();
		heap.heap_size = K;
		
		int[] heapArr = new int[K + 1];
		
		for (int i = 1; i <= K; i++) {
			heapArr[i] = arr[i];
		}
		
		heap.buildMaxHeap(heapArr, K);
		
		System.out.println("Kth Smallest integer is " + heap.kthSmallestInt(arr, heapArr, K));
	}
}

/* TC: O(K + (n - K) * Log K) */

// Note: To kind Kth largest integer 
/*
	Step 1: Build a MinHeap of first K elements (arr[0] to arr[K-1]) 
			[TC: The step 1 is O(K)]
	Step 2:  For each element, after the K’th element (arr[K] to arr[n-1]), compare it with root of MH.
				a) If the element is greater than the root then make it root and call heapify for MH
				b) Else ignore it.
			[TC: The step 2 is O((n - K) * log K)]
	Step 3: Finally, root of the MH is the Kth largest element.
*/
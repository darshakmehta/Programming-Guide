/*** 

Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the given array. It is given that all array elements are distinct. 

Input: A = [7, 10, 4, 3, 20, 15], K = 3
Output: 7

***/

/* 
	Method 2 - Build a MinHeap and call extractMin() k times
	Code: https://ideone.com/C3pDZV
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

	public void minHeapify(int[] arr, int i) {
		int l = left(i);
		int r = right(i);
		int smallest;
		if (l <= this.heap_size && arr[l] < arr[i])
			smallest = l;
		else
			smallest = i;
		if (r <= this.heap_size && arr[r] < arr[smallest])
			smallest = r;
		if (smallest != i) {
			swap(arr, i, smallest);
			minHeapify(arr, smallest);
		}
	}

	public void buildMinHeap(int[] arr, int n) {
		for (int i = (int) Math.floor(n / 2); i >= 1; i--) {
			minHeapify(arr, i);
		}
	}

	public int extractMin(int[] arr) {
		if (this.heap_size < 1) {
			System.out.println("heap underflow");
			return -1;
		}
		
		int min = arr[1];
		arr[1] = arr[heap_size];
		heap_size--;

		minHeapify(arr, 1);
		return min;
	}
}

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // number of elements
		int[] arr = new int[n + 1];
		int result = 0;

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		int K = sc.nextInt();

		Heap heap = new Heap();
		heap.heap_size = n;

		heap.buildMinHeap(arr, n);

		while (K-- != 0) {
			result = heap.extractMin(arr);
		}

		System.out.println("Kth Smallest integer is " + result);
	}
}

/* TC: O(N + K log N) */

// Note: To kind Kth largest integer Build Max Heap and extractMax() K times
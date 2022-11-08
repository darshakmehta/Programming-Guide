/**
 * Given that integers are being read from a data stream.
 * Find median of all the elements read so far starting from the first integer till the last integer.
 * This is also called Median of Running Integers.
 * The data stream can be any source of data, example: a file, an array of integers, input stream etc.
 *
 * What is Median?
 * Median can be defined as the element in the data set which separates the higher half of the data sample
 * from the lower half. In other words we can get the median element as, when the input size is odd,
 * we take the middle element of sorted data. If the input size is even,
 * we pick average of middle two elements in sorted stream.
 */

/**
 * Example:
 * Input: 5 15 10 20 3
 * Output:
 * 5.0
 * 10.0
 * 10.0
 * 12.5
 * 10.0
 * Code: https://ideone.com/VC4U2C
 */

/***

Method 1: Use Max Heap and Min Heap

Algorithm:

1. Create two heaps. One max heap to maintain elements of lower half and one min heap to maintain elements of higher half at any point of time..
2. Take initial value of median as 0.
3. For every newly read element, insert it into either max heap or min heap and calculate the median based on the following conditions:
	If the size of max heap is greater than size of min heap and the element is less than previous median then pop the top element from max heap and insert into min heap and insert the new element to max heap else insert the new element to min heap. Calculate the new median as average of top of elements of both max and min heap.
	
	If the size of max heap is less than size of min heap and the element is greater than previous median then pop the top element from min heap and insert into max heap and insert the new element to min heap else insert the new element to max heap. Calculate the new median as average of top of elements of both max and min heap.
	
	If the size of both heaps are same. Then check if current is less than previous median or not. If the current element is less than previous median then insert it to max heap and new median will be equal to top element of max heap. If the current element is greater than previous median then insert it to min heap and new median will be equal to top element of min heap.

**/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void printMedian(int[] arr) {
		// Max Heap to store smaller half elements
		PriorityQueue<Integer> smallerMaxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

		// Min Heap to store greater half elements
		PriorityQueue<Integer> greaterMinHeap = new PriorityQueue<Integer>();

		double median = arr[0];
		smallerMaxHeap.add(arr[0]);

		System.out.println(median);

		// Read elements of stream one by one
		for (int i = 1; i < arr.length; i++) {
			int x = arr[i];

			// Case 1: Left side heap has more elements
			if (smallerMaxHeap.size() > greaterMinHeap.size()) {
				if (x < median) {
					greaterMinHeap.add(smallerMaxHeap.remove());
					smallerMaxHeap.add(x);
				} else {
					greaterMinHeap.add(x);
				}
				median = (double) (smallerMaxHeap.peek() + greaterMinHeap.peek()) / 2; 
			}

			// Case 2: Both Heaps are balanced
			else if (smallerMaxHeap.size() == greaterMinHeap.size()) {
				if (x < median) {
					smallerMaxHeap.add(x);
					median = (double) smallerMaxHeap.peek();
				} else {
					greaterMinHeap.add(x);
					median = (double) greaterMinHeap.peek();
				}
			}

			// Case 3: Right side heap has more elements
			else {
				if (x > median) {
					smallerMaxHeap.add(greaterMinHeap.remove());
					greaterMinHeap.add(x);	
				} else {
					smallerMaxHeap.add(x);
				}
				median = (double) (smallerMaxHeap.peek() + greaterMinHeap.peek()) / 2;
			}

			System.out.println(median);
		}
	}

	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		printMedian(arr);
	}
}

// Time Complexity: O(n Log n)
// Auxiliary Space : O(n)

/**
 * TODO:
 * 1. Using Insertion Sort
 * 2. Using Augmented self-balanced binary search tree (AVL, RB, etc…)
 */

/*** 
	Write an efficient program for printing k largest elements in an array. Elements in array can be in any order.

	Input: [1, 23, 12, 9, 30, 2, 50]
	K = 3
	Output [50, 30, 23]
**/

/***

Method 1: Modified Bubble Sort [TC: O(nK)]

1) Modify Bubble Sort to run the outer loop at most k times.
2) Print the last k elements of the array obtained in step 1.
Code: https://ideone.com/nqqacV

**/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void bubbleSortOptimized(int[] arr, int K) {
		boolean isSorted = false;
		int lastUnsorted = arr.length - 1;

		while (!isSorted && K != 0) {
			isSorted = true;
			for (int i = 0; i < lastUnsorted; i++) {
				if (arr[i] > arr[i+1]) {
					swap(arr, i, i + 1);
					isSorted = false;
				}
			}
			K--;
			lastUnsorted--;
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception {
	
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int a[] = new int[size];
		for (int i = 0; i < size; i++)
			a[i] = sc.nextInt();
			
		int K = sc.nextInt();
		
		bubbleSortOptimized(a, K);

		int j = a.length - 1;
		for (int i = 0; i < K; i++)
			System.out.print(a[j--] + " ");
	}
}


/***

Method 2: Modified Selection Sort [TC: O(nK)]
Code: #TODO

**/

/***

Method 3: Temporary Array
Steps:
1) Store the first k elements in a temporary array temp[0...k-1].
2) Find the smallest element in temp[], let the smallest element be min.
3.1) For each element x in arr[k] to arr[n-1]. O(n-k)
		If x is greater than the min then remove min from temp[] and insert x.
3.2) Then, determine the new min from temp[]. O(k)
4) Print final k elements of temp[]

Time Complexity: O((n - k) * k). If we want the output sorted then O((n - k) * k + k logk)

**/

/***

Method 4: Use Sorting
Steps:
1) Sort the elements in descending order in O(n Log n)
2) Print the first k numbers of the sorted array O(K).
TC: O(n Log n)

**/


/***

Method 5: Use Max Heap
Steps:
1) Build a Max Heap tree in O(n)
2) Use Extract Max k times to get k maximum elements from the Max Heap O(klogn)

TC: O(n + k Log n)

**/


/***

Method 6: Use Order Statistics

6.1 Use Order statistic algo to find Kth largest element in O(n)
TODO: https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/

6.2 Use QuicK Sort algorithm to partition around the Kth largest Number in O(n)

6.3 Sort the k-1 elements (elements greater than the kth largest element) O(kLogk). This step is needed only if sorted output is required.

TC: O(n) if we don’t need the sorted output, otherwise O(n + kLogk)

**/


/***

Method 7: Use Min Heap
Steps:
1) Build a Min Heap MH of the first k elements (arr[0] to arr[k-1]) of the given array. O(k)

2) For each element, after the kth element (arr[k] to arr[n-1]), compare it with root of MH.
	...a) If the element is greater than the root then make it root and call heapify for MH
	...b) Else ignore it. // The step 2 is O((n-k)*logk)

3) Finally, MH has k largest elements and root of the MH is the kth largest element.

TC: O(k + (n - k) Log k) without sorted output. If sorted output is needed then O(k + (n - k) Logk + k Log k)

**/
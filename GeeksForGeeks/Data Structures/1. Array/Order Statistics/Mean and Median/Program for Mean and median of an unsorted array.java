/***

Given n size unsorted array, find its mean and median.

Mean of an array = (sum of all elements) / (number of elements)

Median of a sorted array of size n is defined as the middle element when n is odd and average of middle two elements when n is even.

Since the array is not sorted here, we sort the array first, then apply above formula.

Examples:

Input  : a[] = {1, 3, 4, 2, 6, 5, 8, 7}
Output : Mean = 4.5
         Median = 4.5
Sum of the elements is 1 + 3 + 4 + 2 + 6 + 
5 + 8 + 7 = 36
Mean = 36/8 = 4.5
Since number of elements are even, median
is average of 4th and 5th largest elements.
which means (4 + 5)/2 = 4.5

Input  : a[] = {4, 4, 4, 4, 4}
Output : Mean = 4
         Median = 4 

Code: https://ideone.com/JZoJyV
**/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static double findMean(int[] arr, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		return (double) sum / (double) n;
	}

	public static double findMedian(int[] arr, int n) {
		Arrays.sort(arr);

		if (n % 2 != 0) 
			return (double) arr[n/2];

		return (double)(arr[(n - 1) / 2] + arr[n / 2]) / 2.0;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println("Mean: " + findMean(arr, n));
		System.out.println("Median: " + findMedian(arr, n));
	}
}

/**

Time Complexity to find mean = O(n)
Time Complexity to find median = O(n Log n) as we need to sort the array first.


#TODO: we can find median in O(n) time
1. https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/
2. https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/

**/
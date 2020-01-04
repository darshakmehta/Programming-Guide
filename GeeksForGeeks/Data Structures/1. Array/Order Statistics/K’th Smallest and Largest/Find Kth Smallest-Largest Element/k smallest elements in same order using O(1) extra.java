/***

You are given an array of n-elements you have to find k smallest elements from the array but they must be in the same order as they are in given array and we are allowed to use only O(1) extra space.

Examples:

Input : arr[] = {4, 2, 6, 1, 5}, 
            k = 3
Output : 4 2 1
Explanation : 1, 2 and 4 are three smallest 
numbers and 4 2 1 is their order in given array

Input : arr[] = {4, 12, 16, 21, 25}, 
            k = 3
Output : 4 12 16
Explanation : 4, 12 and 16 are 3 smallest numbers
and 4 12 16 is their order in given array

# Solution in O(n) space => 

1. Make a copyArr of original Array
2. Sort copyArr and for first K smallest elements loop through original array and print for a match

# Solution in O(1) space =>

The idea is to move k minimum elements to beginning in same order. To do this, we start from (k+1)-th element and move till end. For every array element, we replace the largest element of first k elements with the current element if current element is smaller than the largest. To keep the order, we use insertion sort idea.

Code: https://ideone.com/ADzpD5

**/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void printKSmallInOrder(int[] arr, int n, int K) {

		// For each arr[i] find whether 
        // it is a part of n-smallest 
        // with insertion sort concept 
		for (int i = K; i < n; i++) {
			// Find largest from top n-element 
			int max_var = arr[K - 1];
			int pos = K - 1;

			for (int j = K - 2; j >= 0; j--) {
				if (arr[j] > max_var) {
					max_var = arr[j];
					pos = j;
				}
			}

			// If largest is greater than arr[i] 
            // shift all element one place left 
            if (max_var > arr[i]) {
            	int j = pos;
            	while (j < K - 1) {
            		arr[j] = arr[j + 1];
            		j++;
            	}

            	arr[K - 1] = arr[i];
            }
		}

        for (int i = 0; i < K; i++) 
            System.out.print(arr[i] + " ");
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

		printKSmallInOrder(arr, n, K);
	}
}

// TC: ???
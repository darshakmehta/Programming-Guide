/***

Consider an array of size n with all initial values as 0. Perform given ‘m’ add operations from index ‘a’ to ‘b’ and evaluate highest element in array. An add operation adds 100 to all elements from a to b (both inclusive).

Efficient approach using Prefix Sum Array :

1 : Run a loop for 'm' times, inputting 'a' and 'b'.
2 : Add 100 at index 'a' and subtract 100 from index 'b+1'.
3 : After completion of 'm' operations, compute the prefix sum array.
4 : Scan the largest element and we're done.

What we did was adding 100 at ‘a’ because this will add 100 to all elements while taking prefix sum array. Subtracting 100 from ‘b+1’ will reverse the changes made by adding 100 to elements from ‘b’ onward.

Input : n = 5 // We consider array {0, 0, 0, 0, 0}
        m = 3.
        a = 2, b = 4.
        a = 1, b = 3.
        a = 1, b = 2.
Output : 300

Code: http://ideone.com/wK0x5Y
**/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static int prefixSumArrayFindLargest(int[] arr, int[] prefixSum, int n) {
		int largest = arr[0];
		prefixSum[0] = arr[0];
		
		for (int i = 1; i < n; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i];
			if (largest < prefixSum[i]) {
				largest = prefixSum[i];
			}
		}

		return largest;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] prefixSum = new int[n];

		int m = sc.nextInt();

		for (int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			arr[a - 1] += 100;
			arr[b] -= 100;
		}

		System.out.println("Largest Element is " + prefixSumArrayFindLargest(arr, prefixSum, n));
	}
}
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	static class Pair {
		int max;
		int min;

		public Pair(int max, int min) {
			this.max = max;
			this.min = min;
		}
	}

	public static Pair getMinMax(int[] arr, int n) {
		if (n == 1) {
			return new Pair(arr[0], arr[0]);
		}

		Pair pair = new Pair(0, 0);

		int i = 0;
		if (n % 2 == 0) {
			if (arr[0] > arr[1]) {
				pair.max = arr[0];
				pair.min = arr[1];
			} else {
				pair.max = arr[1];
				pair.min = arr[0];
			}
			i = 2;
		} else {
			pair.max = arr[0];
			pair.min = arr[1];
			i = 1;
		}

		for (; i < n - 1; i+=2) {
			if (arr[i] > arr[i + 1]) {
				pair.max = Math.max(pair.max, arr[i]);
				pair.min = Math.min(pair.min, arr[i + 1]);
			} else {
				pair.max = Math.max(pair.max, arr[i + 1]);
				pair.min = Math.min(pair.min, arr[i]);
			}
		}

		return pair;
	}

	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n == 0) {
			System.out.println("No Input provided");
			return;
		}

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Pair pair = getMinMax(arr, n);
		System.out.println("min " + pair.min + ", max " +  pair.max);
	}
}

/***
https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

Time Complexity: O(n)
Auxiliary Space: O(1) as no extra space was needed.
Total number of comparisons: Different for even and odd n, see below:
       If n is odd:    3*(n-1)/2
       If n is even:   1 Initial comparison for initializing min and max,
                           and 3(n-2)/2 comparisons for rest of the elements
                      =  1 + 3*(n-2)/2 = 3n/2 -2
***/

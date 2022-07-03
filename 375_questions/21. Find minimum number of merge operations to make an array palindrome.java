import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static int findMinMerge(int[] arr, int n) {
		int minMerge = 0;
		if (n == 1) {
			return minMerge;
		}

		int left = 0; int right = n - 1;
		while (left < right) {
			if (arr[left] == arr[right]) {
				left++;
				right--;
			}
			if (arr[left] < arr[right]) {
				arr[left + 1] += arr[left];
				left++;
				minMerge++;
			} else if (arr[left] > arr[right]) {
				arr[right - 1] += arr[right];
				right--;
				minMerge++;
			}
		}
		return minMerge;
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

		System.out.println(findMinMerge(arr, n));
	}
}

/**
Ideone: https://ideone.com/xynnQA
**/

/**
Sample test cases:

8
5  4  9  8  3  6  5  4

6
6 5 6 5 5 5

4
11 14 15 99

4
1 4 5 1

5
1 4 5 9 1

3
15 4 15

**/

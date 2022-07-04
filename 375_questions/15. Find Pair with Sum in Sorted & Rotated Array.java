import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static boolean isPair(int[] arr, int n, int sum) {
		int i = 0;

		for (i = 0; i < n - 1; i++) {
			if (arr[i+1] < arr[i]) {
				break;
			}
		}

		int left = (i + 1) % n; // smallest element
		int right = i; // largest element

		while (left != right) {
			if (arr[left] + arr[right] == sum) {
				return true;
			}
			if (arr[left] + arr[right] < sum) {
				left = (left + 1) % n;
			} else {
				right = (n + right - 1) % n;
			}
		}
		return false;
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

		int sum = sc.nextInt();

		System.out.println(isPair(arr, n, sum));
	}
}

/**
Ideone: https://ideone.com/7pMjD8
**/

/**
Sample test cases:
6
11  15  26  38  9  10
45
Ans: true

6
11  15  26  38  9  10
35
Ans: true

6
11  15  6  8  9  10
16
Ans: false
/**
TODO:
How to count all pairs having sum x?
**/

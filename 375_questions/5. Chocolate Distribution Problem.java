import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static int findMinDiff(int[] arr, int n, int m) {
		Arrays.sort(arr);

		int left = 0, right = m - 1;
		int minDiff = arr[right] - arr[left];
		right++; left++;
		while (right < n) {
			minDiff = Math.min(minDiff, arr[right++] - arr[left++]);
		}

		return minDiff;
	}

	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // number of packets
		int m = sc.nextInt(); // number of students
		if (n == 0) {
			System.out.println("No Input provided");
			return;
		}

		if (m > n) {
			System.out.println("Cannot be decided");
			return;
		}

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(findMinDiff(arr, n, m));
	}
}

/**
Input1:
8 5
3 4 1 9 56 7 9 12

Output1:
6

Input2:
7 3
7  3  2  4  9  12  56

Output2:
2

Input3:
17 7
12  4  7  9  2  23  25  41  30  40  28  42  30  44  48  43  50

Output3:
10

/**
Ideone: https://ideone.com/U8eRED
**/

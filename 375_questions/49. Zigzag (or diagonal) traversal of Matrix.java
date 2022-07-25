import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void printZigzag(int[][] arr, int n, int m) {
		// Print Upper half
		for (int i = 0; i < n; i++) {
			int a = i, b = 0;
			while (a >= 0 && b < m) {
				System.out.print(arr[a--][b++] + " ");
			}
			System.out.println();
		}

		// Print lower half
		for (int j = 1; j < m; j++) {
			int a = n - 1, b = j;
			while (a >= 0 && b < m) {
				System.out.print(arr[a--][b++] + " ");
			}
			System.out.println();
		}
	}

	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		printZigzag(arr, n, m);
	}
}

/**
Ideone: https://ideone.com/ij6W1p
**/

/**
Test cases:

Input:
5 4
1     2     3     4
5     6     7     8
9    10    11    12
13    14    15    16
17    18    19    20

Output:

1
5 2
9 6 3
13 10 7 4
17 14 11 8
18 15 12
19 16
20

**/

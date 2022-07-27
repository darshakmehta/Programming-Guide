import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void printSpiral(int m, int n) {
		int startRow = 0, endRow = m - 1, startCol = 0, endCol = n - 1;
		char[][] arr = new char[m][n];
		char c = 'x';

		while (startRow <= endRow && startCol <= endCol) {
			for (int j = startCol; j <= endCol; j++) {
				arr[startRow][j] = c;
				arr[endRow][j] = c;
			}
			startRow++;
			endRow--;

			for (int i = startRow; i <= endRow; i++) {
				arr[i][startCol] = c;
				arr[i][endCol] = c;
			}

			startCol++;
			endCol--;

			c = (c == 'x') ? 'o' : 'x';
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();

		printSpiral(m, n);
	}
}

/**
 * Ideone: https://ideone.com/nBGAY8
 */

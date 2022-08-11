import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void findCommonElements(int[] arr1, int[] arr2, int[] arr3, int a1, int a2, int a3) {
		int i = 0, j = 0, k = 0;
		while (i < a1 && j < a2 && k < a3) {
			if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
				System.out.println(arr1[i]);
				i++;
				j++;
				k++;
				continue;
			}

			int min = Math.min(arr1[i], Math.min(arr2[j], arr3[k]));
			if (arr1[i] == min) {
				i++;
			} else if (arr2[j] == min) {
				j++;
			} else {
				k++;
			}
		}
	}

	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt();
		int[] arr1 = new int[a1];

		for (int i = 0; i < a1; i++) {
			arr1[i] = sc.nextInt();
		}

		int a2 = sc.nextInt();
		int[] arr2 = new int[a2];
		for (int i = 0; i < a2; i++) {
			arr2[i] = sc.nextInt();
		}

		int a3 = sc.nextInt();
		int[] arr3 = new int[a3];
		for (int i = 0; i < a3; i++) {
			arr3[i] = sc.nextInt();
		}

		if (a1 != 0 && a2 != 0 && a3 != 0) {
			findCommonElements(arr1, arr2, arr3, a1, a2, a3);
		} else {
			System.out.println("No common elements");
		}
	}
}

/**
Ideone: https://ideone.com/V1YY3H
**/

/**
Input:
7
1 5 10 20 30 40 80
6
6 7 20 30 80 100
8
3 4 15 20 30 70 80 120

Output:

20
30
80

Input:
5
1 2 3 4 5
5
1 2 5 7 9
5
1 3 4 5 8

Output:
1
5
**/

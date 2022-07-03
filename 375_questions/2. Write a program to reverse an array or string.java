import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void getReverseArr(int[] arr, int n) {
		int left = 0, right = n - 1;

		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
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

		getReverseArr(arr, n);

		System.out.println(Arrays.toString(arr));
	}
}

/**
TODO:
1. Recursive way
**/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static boolean permuteTwoArrays(int[] a, int[] b, int k) {
		if (a.length != b.length) {
			return false;
		}

		// To perform a reverse sort convert it to an object arr.
		Integer[] newArray = new Integer[b.length];
		int x = 0;
		for (int value : b) {
			newArray[x++] = Integer.valueOf(value);
		}
		Arrays.sort(a);
		Arrays.sort(newArray, Collections.reverseOrder());

		for (int i = 0; i < a.length; i++) {
            if (a[i] + newArray[i] < k) {
                return false;
            }
        }
        return true;
	}

	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] a = new int[m];
		int[] b = new int[n];

		for (int i = 0; i < m; i++) {
		    a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int k = sc.nextInt();

		boolean result = permuteTwoArrays(a, b, k);
		if (result) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}

/**
 * Ideone: https://ideone.com/9vpkDw
 */

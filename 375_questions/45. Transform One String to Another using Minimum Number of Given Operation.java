import java.util.*;
import java.lang.*;
import java.io.*;

class Solution { // Time: O(n) and Space: O(n) since we convert to character arrays.
	public static boolean verifyTransform(String A, String B) {
		if (A.length() != B.length()) {
			return false;
		}

		int[] count = new int[256];
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();

		for (int i = 0; i < a.length; i++) {
			count[a[i]]++;
			count[b[i]]--;
		}

		for (int i = 0; i < 256; i++) {
			if (count[i] != 0) {
				return false;
			}
		}

		return true;
	}

	public static String transform(String A, String B) {
		if (verifyTransform(A, B)) {
			int i = A.length() - 1;
			int j = B.length() - 1;
			int result = 0;

			while (i >= 0) {
				if (A.charAt(i) != B.charAt(j)) {
					result++;
				} else {
					j--;
				}
				i--;
			}

			return "Minimum Number of Operations required to transform A to B is: " + result;
		} else {
			return "Cannot transform from String A to B";
		}
	}

	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		String B = sc.nextLine();
		System.out.println(transform(A, B));
	}
}

/**
Ideone: https://ideone.com/mxIyOE
**/

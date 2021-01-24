import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	// Remember: Binary search requires the array to be sorted
	public static int iterativeBinarySearch(int[] nums, int value) {
		int low = 0, high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] == value) {
				return mid;
			} else if (nums[mid] < value) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	// Remember: Binary search requires the array to be sorted
	public static int recursiveBinarySearch(int[] nums, int low, int high, int value) {
		if (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] == value) {
				return mid;
			} else if (nums[mid] < value) {
				return recursiveBinarySearch(nums, mid + 1, high, value);
			} else {
				return recursiveBinarySearch(nums, low, mid - 1, value);
			}
		}
		return -1;
	}

	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int value = sc.nextInt();

		// Iterative Binary Seach
		int iterativeResult = iterativeBinarySearch(arr, value);
		if (iterativeResult == -1) {
			System.out.println("Value: " + value + " not found");
		} else {
			System.out.println("Value: " + value + " found at index " + iterativeResult);
		}

		// Recursive Binary Search
		int recursiveResult = recursiveBinarySearch(arr, 0, n - 1, value);
		if (recursiveResult == -1) {
			System.out.println("Value: " + value + " not found");
		} else {
			System.out.println("Value: " + value + " found at index " + recursiveResult);
		}
	}
}
/**
 * Algorithmic Paradigm: Decrease and Conquer
 * Iterative Solution: Time complexity: O(log n) and Space complexity: O(1)
 * Recursive Solution: Time complexity: O(log n) and Space complexity: O(log n) recursion call stack space
 * Remember: Binary search requires the array to be sorted
 ***/

// Solution: https://ideone.com/pLO1AL

/**
 * Testcases:
 *
 * 6
 * 2 5 8 10 12 16
 * 12
 */

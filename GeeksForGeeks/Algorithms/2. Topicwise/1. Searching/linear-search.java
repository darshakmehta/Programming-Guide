import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		int v = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = linearSearch(arr, v);
        if (result == -1) {
            System.out.println("Value: " + v + " not found");
        } else {
            System.out.println("Value: " + v + " found at index " + result);
        }
    }

    public static int linearSearch(int[] nums, int value) {
    	int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == value) {
                return i;
            }
        }
        return -1;
    }
}

// Solution: https://ideone.com/K1cAPa

/**
 * Time complexity: O(n)
 * Note: Linear search is rarely used, binary search and hash tables provide faster searching compared to Linear Search
 */

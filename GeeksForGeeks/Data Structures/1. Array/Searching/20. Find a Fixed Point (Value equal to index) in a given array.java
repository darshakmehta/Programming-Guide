import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static int fixedPoint1(int[] nums) { // Time: O(n)
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public static int fixedPoint2(int[] nums) { // Time: O(logn)
        int n = nums.length;

        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == mid) {
                return mid;
            } else if (nums[mid] < mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = fixedPoint1(arr);

        if (result == -1) {
            System.out.println("No Fixed Point");
        } else {
            System.out.println("Fixed point is: " + result);
        }

        result = fixedPoint2(arr);

        if (result == -1) {
            System.out.println("No Fixed Point");
        } else {
            System.out.println("Fixed point is: " + result);
        }
    }
}

// Solution: https://ideone.com/JwX6Yo

/*
Testcases:

5
-10 -5 0 3 7

5
0 2 5 8 17

6
-10 -5 3 4 7 9
 */

/**
 * TODO: Find a Fixed Point (Value equal to index) in a given array | Duplicates Allowed
 * Time complexity: O(n)
 * Reference: https://www.geeksforgeeks.org/find-fixed-point-value-equal-index-given-array-duplicates-allowed/
 */

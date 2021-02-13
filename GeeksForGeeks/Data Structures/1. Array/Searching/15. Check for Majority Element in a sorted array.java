/**
 * Technique:
 * 1. Linear Search: Find first occurence and check for index (i + n/2) if it is present we found our majority element.
 * 2. Binary Search: Find first occurence and check for index (i + n/2) if it is present we found our majority element.
 * 3. Logic: Check if middle element is equal to key then it is our majority element. Assumption: Majority element exists.
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    // Technique 1: Linear Search
    public static boolean isMajority1(int[] nums, int key) { // Time: O(n)
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                int x = i + (n/2);
                if (x < n && nums[x] == key) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    // Technique 2: Binary Search
    public static boolean isMajority2(int[] nums, int key) { // Time: O(logn)
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] == key) {
                if (mid == n /2) {
                    return true;
                }
                return false;
            } else if (nums[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    // Technique 3: Assumption: Majority element exists
    public static boolean isMajority3(int[] nums, int key) {
        return nums[nums.length / 2] == key;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int key = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Linear Search
        boolean result = isMajority1(arr, key);

        if (result) {
            System.out.println("Majority element is " + key);
        } else {
            System.out.println("No majority element found");
        }

        result = isMajority2(arr, key);

        if (result) {
            System.out.println("Majority element is " + key);
        } else {
            System.out.println("No majority element found");
        }

        result = isMajority3(arr, key);

        if (result) {
            System.out.println("Majority element is " + key);
        } else {
            System.out.println("No majority element found");
        }
    }
}

// Solution: https://ideone.com/g33W9e

/*
Testcases:

7 3
1 2 3 3 3 3 10

8 4
1 1 2 4 4 4 6 6
Note: 2nd testcase will fail method 3: since we assumed majority element is present.

5 1
1 1 1 2 2

7 4
1 2 3 4 4 4 4
 */

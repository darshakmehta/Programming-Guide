import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static int peakElement(int[] nums) { // Time: O(n)
        int n = nums.length;

        if (n == 1)
            return nums[0];
        if (nums[0] >= nums[1])
            return 0;
        if (nums[n - 1] >= nums[n - 2])
            return n - 1;

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] >= nums[i-1] && nums[i] >= nums[i+1]) {
                return i;
            }
        }
        return -1;
    }

    public int improvedFindPeakElementSequentially(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return n - 1;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Peak element is at index: " + peakElement(arr));
    }
}

// Solution: https://ideone.com/ZazPOw

/**
 * Efficient Approach - Using Divide & Conquer in O(logn) time
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static int peakElementBinarySearchUtil(int[] nums, int low, int high, int n) {
        int mid = low + (high - low) / 2;

        if ((mid == 0 || nums[mid] >= nums[mid - 1]) && (mid == n - 1 || nums[mid] >= nums[mid+1])) {
            return mid;
        } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
            return peakElementBinarySearchUtil(nums, low, mid - 1, n);
        } else {
            return peakElementBinarySearchUtil(nums, mid + 1, high, n);
        }
    }

    public static int peakElement(int[] nums) { // Time: O(logn)
        int n = nums.length;
        return peakElementBinarySearchUtil(nums, 0, n - 1, n);
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Peak element is at index: " + peakElement(arr));
    }
}

// Solution: https://ideone.com/saXqZp


/**
 * TODO: Exercise:
 * Consider the following modified definition of peak element.
 * An array element is a peak if it is greater than its neighbours.
 * Note that an array may not contain a peak element with this modified definition.
 */


/*
Testcases:

7
10 20 15 2 23 90 67

4
5 10 20 15

5
10 20 30 40 50

5
100 80 60 50 20

6
1 3 20 4 1 0
 */

/**
 * TODO: Find a peak element in 2D Array
 * Reference: https://www.geeksforgeeks.org/find-peak-element-2d-array/
 * Reference: O(n) solution => https://stackoverflow.com/questions/23120300/2d-peak-finding-algorithm-in-on-worst-case-time
 */

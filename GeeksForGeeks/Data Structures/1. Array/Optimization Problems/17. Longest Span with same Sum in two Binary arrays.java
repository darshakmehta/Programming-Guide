/**
 * Method 1: Using Auxillary Array
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    // If differences between prefix sums of two arrays become same at two points, then subarrays between these two points have same sum.
    public static int findLongestSpan(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int size = (2 * n + 1); // Possible sum values can range between -n to n, i.e. (2 * n + 1) values
        // diff array stores starting indexes of all possible difference values and use to calculate len using "i"
        // which gives us the length (end - start) i.e. (i - diff[diffIndex])
        // Note: diff[i] = stores starting and ending index for "i - n" value
        int[] diff = new int[size];
        int prefixSum1 = 0, prefixSum2 = 0;
        int maxLen = 0;

        // Initialize all starting and ending values as -1.
        for (int i = 0; i < diff.length; i++) {
            diff[i] = -1;
        }

        for (int i = 0; i < n; i++) {

            prefixSum1 += arr1[i];
            prefixSum2 += arr2[i];

            int curr_diff = prefixSum1 - prefixSum2;
            int diffIndex = n + curr_diff;

            // If curr_diff is 0, then there are same number
            // of 1's so far in both arrays, i.e., (i+1) is
            // maximum length.
            if (curr_diff == 0) {
                maxLen = i + 1;
            } else if (diff[diffIndex] == -1) { // accessing first time
                diff[diffIndex] = i;
            } else { // already accessed position
                int len = i - diff[diffIndex];
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println("Longest span in two binary arrays is: " + findLongestSpan(arr1, arr2));
    }
}

// Solution: https://ideone.com/CkAVOG

// TODO: Print actual Solution

/**
 * Method 2: Using Hashing
 *
 * Steps:
 * 1. Find Difference Array arr[] such that arr[i] = arr1[i] - arr2[i]
 * 2. Largest subarray with equal number of 0's and 1's using difference array (cumulative sum = 0)
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Result {
    int max_len;
    int start;
    int end;

    public Result(int max_len, int start, int end) {
        this.max_len = max_len;
        this.start = start;
        this.end = end;
    }
}

class Solution {

    public static Result findLargestSubArr(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int sum = 0;
        Result result = new Result(0, 0, -1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum == 0) {
                result.max_len = i + 1;
                result.end = i;
            }

            // If curr_sum is seen before,
            // then update max_len if lesser than previous max_len
            if (hmap.containsKey(sum + n)) { // (+ n) bcoz cumulative sum can range between -n tp n
                int temp = i - hmap.get(sum + n);
                if (result.max_len < temp) {
                    result.max_len = temp;
                    result.end = i;
                }
            } else { // Else put this sum in hash table
                hmap.put(sum + n, i);
            }
        }

        result.start = (result.end - result.max_len) + 1;

        return result;
    }

    public static Result findLongestSpan(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = arr1[i] - arr2[i];
        }

        return findLargestSubArr(diff);
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        Result result = findLongestSpan(arr1, arr2);

        System.out.println("Longest span with same sum in two binary array's is: " + result.max_len);

        if (result.end != -1) {
            System.out.println("Subarray elements are: ");
            for (int i = result.start; i <= result.end; i++) {
                System.out.print(arr1[i] + " ");
            }
            System.out.println();
            for (int i = result.start; i <= result.end; i++) {
                System.out.print(arr2[i] + " ");
            }
        } else {
            System.out.println("No such array");
        }
    }
}

// Solution: https://ideone.com/IYt64f

/**
 * Testcases:
 * 4
 * 0 0 1 0
 * 1 1 1 1
 *
 * 3
 * 0 0 0
 * 1 1 1
 *
 * 7
 * 0 1 0 1 1 1 1
 * 1 1 1 1 1 0 1
 *
 * 6
 * 0 1 0 0 0 0
 * 1 0 1 0 0 1
 */

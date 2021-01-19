/**
 * Kadane's Algorithm
 *
 * Initialize: max_so_far = 0 max_ending_here = 0
 *
 * Loop for each element of the array (a) max_ending_here = max_ending_here + a[i] (b) if(max_ending_here < 0)
 * max_ending_here = 0 (c) if(max_so_far < max_ending_here) max_so_far = max_ending_here return max_so_far
 */

import java.util.*;
import java.lang.*;
import java.io.*;

/*
Time Complexity: O(n)
Space Complexity: O(1) excluding input array space
Algorithmic Paradigm: Dynamic Programming
 */

class kadanes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t != 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int maxSoFar = a[0];
            int currMax = a[0];

            // Handles all negative elements in array
            for (int i = 1; i < a.length; i++) {
                currMax = Math.max(a[i], a[i] + currMax);
                maxSoFar = Math.max(maxSoFar, currMax);
            }
            System.out.println(maxSoFar);

            t--;
        }
    }
}

/***
 * Sample Test cases
 */

/*

Solution: https://ideone.com/f595D2

Input:

3
8
-2 -3 4 -1 -2 1 5 -3
5
4 5 6 7 8
5
-1 -2 -3 -4 -5

Output:
7
30
-1

 */

/* Print subarray Elements */

import java.util.*;
        import java.lang.*;
        import java.io.*;

class printSubarrElementKadanes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max_so_far = arr[0], max_ending_here = arr[0];
        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            max_ending_here = max_ending_here + arr[i];

            if (max_ending_here < 0) {
                // When current sum is negative reset sum to 0 and start with next index
                max_ending_here = 0;
                start = i + 1;
            } else if (max_so_far < max_ending_here) {
                // when current element increases the max_so_far, update end index to current index i
                max_so_far = max_ending_here;
                end = i;
            }
        }

        System.out.println("Largest Sum Contiguous Subarray: " + max_so_far);
        System.out.print("Subarray is: ");

        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

/*
Solution: https://ideone.com/wFdXfG

Input:
8
-2 -3 4 -1 -2 1 5 -3

Output:
7
Subarr: 4 -1 -2 1 5
 */

/**
 * Given an array of integers (possibly some of the elements negative), write a program to find out the *maximum
 * product* possible by multiplying ‘n’ consecutive integers in the array where n <= ARRAY_SIZE. Also print the starting
 * point of maximum product subarray.
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    public static int maxProductSubarray(int[] nums) {
        int n = nums.length;
        int prod = 1;
        int result = Integer.MIN_VALUE;

        // First pass: traverse from left to right
        // Note: If even number of negative numbers, then first pass result is final result
        for (int i = 0; i < n; i++) {
            prod = prod * nums[i];
            result = Math.max(prod, result); // max_product_so_far

            if (prod == 0) {
                prod = 1; // reset prod = 1 to multiplying remaining elements
            }
        }

        prod = 1;
        // Second Pass: traverse from right to left
        // Possible solution can be either from left or right side
        // So, If odd number of negative numbers, then second pass to find product from right side
        for (int i = n - 1; i >= 0; i--) {
            prod = prod * nums[i];
            result = Math.max(prod, result); // compare with max_product_so_far from first pass

            if (prod == 0) {
                prod = 1; // reset prod = 1 to multiplying remaining elements
            }
        }

        return result;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Maximum Product: " + maxProductSubarray(arr));
    }
}

// Solution: https://ideone.com/lPlzPf

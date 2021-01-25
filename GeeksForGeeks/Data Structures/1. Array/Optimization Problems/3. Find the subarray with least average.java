/**
 * Sliding Window Technique
 * Define k size subarray starting at index 0 and compute its average
 * Traverse i = (0 + k) ... n - 1 and slide the subarray by adding and removing element at both the ends and recompute average
 *      if (new_average is smaller) update average = new_average and start_index = (i - k + 1)
 * Print subarray starting at start_index
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no. of elements
        int k = sc.nextInt(); // size of subarray
        int[] arr = new int[n];

        if (k > n) {
            System.out.println("Cannot form subarray");
            return;
        }

        int initial_sum = 0;
        for (int i = 0, K = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (K < k) {
                initial_sum += arr[i];
            }
            K++;
        }


        int start = 0;
        if (n != k) {
            float average = initial_sum / k;
            int current_sum = initial_sum;

            for (int i = k, j = 0; i < n; i++, j++) {
                current_sum += arr[i] - arr[j];
                float current_average = current_sum / k;

                if (current_average < average) {
                    start = i - k + 1;
                    current_average = average;
                }
            }
        }

        System.out.print("Least Average Subarray is : [");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[start + i] + " ");
        }
        System.out.println("]");

    }
}

// Solution: https://ideone.com/Hwobxg

/**
 * Optimization: Since we are looking to find the subarray, we can avoid calculating average.
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no. of elements
        int k = sc.nextInt(); // size of subarray
        int[] arr = new int[n];

        if (k > n) {
            System.out.println("Cannot form subarray");
            return;
        }

        int initial_sum = 0;
        for (int i = 0, K = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (K < k) {
                initial_sum += arr[i];
            }
            K++;
        }


        int start = 0;
        if (n != k) {
            int current_sum = initial_sum;

            for (int i = k, j = 0; i < n; i++, j++) {
                current_sum += arr[i] - arr[j];

                if (current_sum < initial_sum) {
                    start = i - k + 1;
                    current_sum = initial_sum;
                }
            }
        }

        System.out.print("Least Average Subarray is : [");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[start + i] + " ");
        }
        System.out.println("]");

    }
}

// Solution: https://ideone.com/F8kG2D

/*
Testcases:

7 2
3 7 5 20 -10 0 12

7 3
3 7 90 20 10 50 40
 */

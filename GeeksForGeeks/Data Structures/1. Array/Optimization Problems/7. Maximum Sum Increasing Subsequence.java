import java.util.*;
import java.lang.*;
import java.io.*;

class MaximumSumIncreasingSubsequence {
    public static int maxSumIS(int[] nums) { // O(N^2)
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            // initialize with initial value at index i
            dp[i] = nums[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // can you add current element at index i to the sequence at index j
                // if yes, compare (sequence length at index i, 1 + length of sequence at index j)
                // choosee the max
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], nums[i] + dp[j]);
                }
            }
        }

        int max_sum = 1; // Minimum length of a subsequence

        for (int i = 0; i < n; i++) {
            if (dp[i] > max_sum) {
                max_sum = dp[i];
            }
        }

        return max_sum;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int a[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println("Maximum sum of the Increasing Subsequence is: " + maxSumIS(a));
    }
}

// Solution: https://ideone.com/Wuhp4V

/**
 * Similar implementation to the Longest Increasing Subsequence problem using DP,
 * where running time is O(n ^ 2) and space is O(n)
 * TODO:
 * 1. Printing the DP solution in O(n ^ 2) time.
 * 2. Constructing and Implementing in O(Nlogn) solution
 */

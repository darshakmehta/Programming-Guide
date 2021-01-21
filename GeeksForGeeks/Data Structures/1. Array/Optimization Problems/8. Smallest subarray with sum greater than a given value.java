import java.util.*;
import java.lang.*;
import java.io.*;

class Solution // Sliding Window Technique - O(n)
{
    public static int subArrayLength(int[] nums, int sum) { // Does not handle negative numbers
        int n = nums.length;

        int curr_sum = nums[0], start = 0;
        int minLength = n + 1;

        for (int i = 1; i <= n; i++) {
            while (curr_sum > sum && start < i) {
                curr_sum = curr_sum - nums[start];
                if (curr_sum <= sum) {
                    minLength = Math.min((i - 1 - start) + 1, minLength);
                }
                start++;
            }

            if (i < n) {
                curr_sum = curr_sum + nums[i];
            }
        }
        return minLength;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Smallest Subarray length with sum greater than a give value: " + subArrayLength(arr, sum));
    }
}

// Solution: https://ideone.com/mM0e7g
// Worst case Time complexity: 2 pass which is O(2n) ~ O(n)

/**
 * Sample Test Cases:
 *
 * 8 16
 * 6 3 4 5 4 3 7 9
 *
 * 6 51
 * 1 4 45 6 0 19
 *
 * 5 9
 * 1 10 5 2 7
 *
 * 10 280
 * 1 11 100 1 0 200 3 2 1 250
 *
 * 3 8
 * 1 2 4
 */

// Print Actual Solution

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution // Sliding Window Technique - O(n)
{
    public static int[] smallestSubarray(int[] nums, int sum) { // Does not handle negative numbers
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }

        int[] result = new int[]{-1, -1};
        int curr_sum = nums[0], start = 0;
        int minLength = n + 1;

        for (int i = 1; i <= n; i++) {
            while (curr_sum > sum && start < i) {
                curr_sum = curr_sum - nums[start];
                if (curr_sum <= sum) {
                    minLength = Math.min((i - 1 - start) + 1, minLength);
                    result[0] = start;
                    result[1] = i - 1;
                }
                start++;
            }

            if (i < n) {
                curr_sum = curr_sum + nums[i];
            }
        }
        return minLength;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = smallestSubarray(arr, sum);

        if (result[0] == -1 || result[1] == -1) {
            System.out.println("Cannot be formed");
            return;
        }
        System.out.println("Smallest subarray is start index: " + result[0] + " and end index: " + result[1]);
        for (int i = result[0]; i <= result[1]; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// Solution: https://ideone.com/cVkiHH

// TODO: Find a solution to handle positive and negative numbers with constant space
// Refer: https://www.geeksforgeeks.org/find-subarray-with-given-sum-with-negatives-allowed-in-constant-space/

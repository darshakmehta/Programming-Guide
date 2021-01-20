import java.util.*;
import java.lang.*;
import java.io.*;

class Solution // Sliding window technique - Time: O(n); Space: O(1)
{
    public static int[] subArraySum(int[] nums, int sum) { // Does not handle negative numbers
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }

        int curr_sum = nums[0], start = 0;

        for (int i = 1; i <= n; i++) {
            while (curr_sum > sum && start < i - 1) {
                curr_sum = curr_sum - nums[start++];
            }

            if (curr_sum == sum) {
                return new int[]{start + 1, i};
            }
            if (i < n) {
                curr_sum = curr_sum + nums[i];
            }
        }
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

        int[] result = subArraySum(arr, sum);

        if (result[0] == -1 || result[1] == -1) {
            System.out.println("Cannot be formed");
            return;
        }
        System.out.println("Continuous subarray is start index: " + result[0] + " and end index: " + result[1]);
        for (int i = result[0]; i <= result[1]; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// Solution: https://ideone.com/iiWzXW


import java.util.*;
import java.lang.*;
import java.io.*;

class Solution // Prefix Sum using Hashing
{
    public static int[] subArraySum(int[] nums, int sum) { // Handles negative numbers
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }

        int curr_sum = 0, start = 0, end = -1;
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        for (int i = 1; i <= n; i++) {
            curr_sum = curr_sum + nums[i];

            int maybeSum = curr_sum - sum;
            // if 0, subarray starts at index 0
            if (maybeSum == 0) {
                start = 0;
                end = i;
                break;
            }

            // if hashMap has the value, we already have subarray
            if (hmap.containsKey(maybeSum)) {
                start = hmap.get(maybeSum) + 1;
                end = i;
                break;
            }

            hmap.put(curr_sum, i);
        }

        return new int[]{start, end};
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

        int[] result = subArraySum(arr, sum);

        if (result[0] == -1 || result[1] == -1) {
            System.out.println("Cannot be formed");
            return;
        }
        System.out.println("Continuous subarray is start index: " + result[0] + " and end index: " + result[1]);
        for (int i = result[0]; i < result[1]; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// Solution: https://ideone.com/WedUnm

// TODO: Find a solution to handle positive and negative numbers with constant space
// Refer: https://www.geeksforgeeks.org/find-subarray-with-given-sum-with-negatives-allowed-in-constant-space/

/** Danger: Below is the Incorrect Solution  **/

// Note: Why should we not subtract from required "sum" value?
// Below logic fails to find best scenario since we are calculating our subarray around value "0" and not value "sum"
// where sum is the sum of subarray[a, ..., b]

/**
 * In worst case, we will access maximum twice resulting in O(2n) ~ O(n) Time complexity
 * Steps:
 * 1. Initialize current_total = sum // sum = sum value of subarray
 * 2. loop i = 0 ... n
 *      current_total -= nums[i] // consider element in resulting subarray
 *      if current_total == 0
 *          we found resulting subarray[j, ..., i]
 *      else if current_total < 0 && i != j
 *         // including current element at index i results in current_total greater than required sum
 *         while j = 0 ... i
 *              remove element until we find current_total = 0 // return resulting array
 *              if current_total results in positive value we restart at index i and current_total = sum
 *
 * 3. Finally, if we cannot find result in above array return start and end index = -1
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution // This is wrong solution, just for reference
{
    // First pass is to find [a, ..., b] where sum(a,b) >= 0
    // Second pass is to start removing elements until we find [remove_elements_here, a, ..., b] where sum(a,b) >= 0
    public static int[] subArraySum(int[] nums, int sum) { // O(2n)
        int n = nums.length;
        int current_total = sum;

        for (int i = 0, j = 0; i < n; i++) {
            current_total -= nums[i];
            if (current_total == 0) {
                return new int[]{j, i};
            } else if (i != j && current_total < 0) {
                while (j < i) {
                    current_total += nums[j];
                    if (current_total == 0) {
                        return new int[]{j + 1, i};
                    } else if (current_total > 0) {
                        break;
                    }
                    j++;
                }
                current_total = sum;
                j = i;
                i = i - 1; // to start again where we first found negative current_total
            }
        }
        return new int[]{-1, -1};
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

        int[] result = subArraySum(arr, sum);

        if (result[0] == -1 || result[1] == -1) {
            System.out.println("Cannot be formed");
            return;
        }
        System.out.println("Continuous subarray is start index: " + result[0] + " and end index: " + result[1]);
        for (int i = result[0]; i <= result[1]; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

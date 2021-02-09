/**
 * Five Appraoches to find Majority Element - Refer 14. Majority Element
 * 1. Brute Force - Find every occurence of every element and break if count > N/2
 * 2. Using HashMap - Store count of every element and break if count > N/2
 * 3. Using Sorting - Sort and find count of same adjacent elements and break if count > N/2
 * 4. Using Moore’s Voting Algorithm
 * 5. Using Binary Search Tree
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    // Approach 2: https://ideone.com/Z6FpyF
    public static void majorityElement2(int[] nums) { // Time: O(n) and Space: O(n)
        int n = nums.length;
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            int count = 1;
            if (hmap.containsKey(nums[i])) {
                count += hmap.get(nums[i]);
                if (count > n / 2) {
                    return nums[i];
                }
            }
            hmap.put(nums[i], count);
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

        int result = majorityElement2(arr);

        if (result == -1) {
            System.out.println("No majority element found");
        } else {
            System.out.println("Majority element found is: " + result);
        }
    }
}

// Solution Approach 2: https://ideone.com/Z6FpyF

/*
Testcases:
9
2 2 2 2 5 5 2 3 3

8
3 3 4 2 4 4 2 4

9
3 3 4 2 4 4 2 4 4

7
1 1 2 1 3 5 1

5
1 3 3 1 2
 */

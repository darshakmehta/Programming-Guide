/**
 * Five Appraoches to find Majority Element
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

    // Approach 3: https://ideone.com/NuWHGA
    public static int majorityElement3(int[] nums) { // Time: O(nlogn) and Space: O(1)
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int count = 1;

            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                    if (count > n/2) {
                        return nums[i];
                    }
                    i++; // Each time we found match else continue with next number
                }
            }
        }

        return -1;
    }

    // Approach 4: https://ideone.com/gbfFsh

    /**
     * Algorithm:
     * 1. Loop through each element and maintains a count of majority element, and a majority index, maj_index
     * 2. If the next element is same then increment the count if the next element is not same then decrement the count.
     * 3.   if the count reaches 0 then changes the maj_index to the current element and set the count again to 1.
     * 4. Now again traverse through the array and find the count of majority element found.
     * 5.   If the count is greater than half the size of the array, print the element
     * 6.   Else print that there is no majority element
     */
    public static int majorityElement4(int[] nums) { // Time: O(n) and Space: O(1)
        int candidate = findCandidate(nums);
        return isMajority(nums, candidate);
    }

    public static int isMajority(int[] nums, int candidate) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == candidate) {
                count++;
                if (count > n/2) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static int findCandidate(int[] nums) {
        int n = nums.length;
        int maj_index = 0, count = 1;

        for (int i = 1; i < n; i++) {
            if (nums[maj_index] == nums[i]) {
                count++;
            } else {
                count--;
            }
            // reset majority index to current element i and count to 1
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }

        return nums[maj_index];
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

        result = majorityElement3(arr);

        if (result == -1) {
            System.out.println("No majority element found");
        } else {
            System.out.println("Majority element found is: " + result);
        }

        result = majorityElement4(arr);

        if (result == -1) {
            System.out.println("No majority element found");
        } else {
            System.out.println("Majority element found is: " + result);
        }
    }
}

// Solution Approach 2: https://ideone.com/Z6FpyF
// Solution Approach 3: https://ideone.com/NuWHGA
// Solution Approach 4: https://ideone.com/gbfFsh

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

/* TODO: Using Binary Search Tree */

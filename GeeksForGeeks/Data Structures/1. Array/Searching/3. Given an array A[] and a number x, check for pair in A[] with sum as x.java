import java.util.*;
import java.lang.*;
import java.io.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    // Method 1
    public static Pair findPairWithSumX1(int[] nums, int sum) { // Time: O(nlogn)
        int n = nums.length;
        Arrays.sort(nums); // Time: O(nlogn) and Space: O(n) for merge sort and O(1) Heap Sort

        Pair pair = new Pair(-1, -1);

        int i = 0, j = n - 1;
        while (i < j) { // Time: O(n)
            int temp_sum = nums[i] + nums[j];
            if (temp_sum == sum) {
                pair.x = nums[i];
                pair.y = nums[j];
                break;
            } else if (temp_sum > sum) {
                j--;
            } else {
                i++;
            }
        }

        return pair;
    }

    // Method 2 (Recommended)
    public static Pair findPairWithSumX2(int[] nums, int sum) { // Time: O(n)
        int n = nums.length;
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>(); // Space: O(n)
        Pair pair = new Pair(-1, -1);

        for (int i = 0; i < n; i++) {
            int diff = sum - nums[i];
            if (hmap.containsKey(diff)) {
                pair.x = nums[hmap.get(diff)];
                pair.y = nums[i];
                break;
            }
            hmap.put(nums[i], i);
        }
        return pair;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Pair pair = findPairWithSumX1(arr, x);
        if (pair.x != -1 && pair.y != -1) {
            System.out.println("Find pair in A[] with sum as x: " + x + " is " + pair.x + " and " + pair.y);
        } else {
            System.out.println("No valid pair exists.");
        }

        pair = findPairWithSumX2(arr, x);
        if (pair.x != -1 && pair.y != -1) {
            System.out.println("Find pair in A[] with sum as x: " + x + " is " + pair.x + " and " + pair.y);
        } else {
            System.out.println("No valid pair exists.");
        }
    }
}

// Solution: https://ideone.com/2OvUaf

/*
Testcases:

5 -2
0 -1 2 -3 1

5 0
1 -2 1 0 5
 */

/**
 * Techniques:
 * TODO: Method 3. Using remainders of the elements less than x. (Only space efficient if value of x is less than n)
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Result {
    int x;
    int y;
    int closestDiff;

    public Result(int x, int y, int closestDiff) {
        this.x = x;
        this.y = y;
        this.closestDiff = closestDiff;
    }
}

class Solution { // Time: O(n)
    public static Result closestSumPairExists(int[] nums1, int[] nums2, int x) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        Result result = new Result(-1, -1, Integer.MAX_VALUE);

        int i = 0, j = n2 - 1;

        while (i < n1 && j >= 0) {
            int temp = Math.abs(nums1[i] + nums2[j] - x);
            if (temp < result.closestDiff) {
                result.closestDiff = temp;
                result.x = nums1[i];
                result.y = nums2[j];
            }

            if (nums1[i] + nums2[j] < x) {
                i++;
            } else {
                j--;
            }
        }

        return result;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int x = sc.nextInt();
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        Result result = closestSumPairExists(arr1, arr2, x);

        if (result.x == -1 || result.y == -1) {
            System.out.println("Pair closest to sum " + x + " does not exist");
        } else {
            System.out.println("Pair closest to sum: " + x + " exists at index: " + result.x + " and " + result.y);
        }
    }
}

// Solution: https://ideone.com/opqNeQ

/*
Testcases:

4 4 32
1 4 5 7
10 20 30 40

4 4 50
1 4 5 7
10 20 30 40

4 4 0
1 4 5 7
10 20 30 40

4 4 24
1 4 5 7
10 20 30 40

4 4 38
1 4 5 7
10 20 30 40
 */

/**
 * TODO: Approach: Using Merging process: Space - O(n) and Time - O(n)
 *
 * 1) Merge given two arrays into an auxiliary array of size (n1 + n2) using merge process of merge sort. While merging
 * keep another boolean array of size (n1 + n2) to indicate whether the current element in merged array is from
 * arr1[] or arr2[].
 *
 * 2) Consider the merged array and use the linear time algorithm to find the pair with sum closest to x. One extra
 * thing we need to consider only those pairs which have one element from arr1[] and other from arr2[],
 * we use the boolean array for this purpose.
 */


/**
 * Extras:
 *
 * 1. Smallest Difference pair of values between two unsorted Arrays
 * Solution: Sort both the arrays and follow above algorithm
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Result {
    int min, max, mid;

    public Result(int min, int max, int mid) {
        this.min = min;
        this.max = max;
        this.mid = mid;
    }
}

class Solution {
    public static Result smallestDiffTriplets(int[] nums1, int[] nums2, int[] nums3) { // Time: O(nlogn)
        int n = nums1.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);

        Result result = new Result(0, 0, 0);
        int diff = Integer.MAX_VALUE;

        int i = 0, j = 0, k = 0;

        while(i < n && j < n && k < n) {
            int sum = nums1[i] + nums2[j] + nums3[k];
            int max = Math.max(nums1[i], Math.max(nums2[j] , nums3[k]));
            int min = Math.min(nums1[i], Math.min(nums2[j] , nums3[k]));
            if (min == nums1[i]) {
                i++;
            } else if (min == nums2[j]) {
                j++;
            } else {
                k++;
            }

            if (diff > (max - min)) {
                diff = max - min;
                result.max = max;
                result.min = min;
                result.mid = sum - (max + min);
            }
        }
        return result;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Given: All are same size arrays
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr3[i] = sc.nextInt();
        }

        Result result = smallestDiffTriplets(arr1, arr2, arr3);
        System.out.println("Smallest difference triplets are: " + result.min + " and " + result.mid + " and " + result.max);
    }
}

/**
 * TODO: Implement reverse sorting for all the threee arrays
 * Refer: https://stackoverflow.com/a/27043087/4489066
 */

// Solution:

/*
Testcases:

3
5 2 8
10 7 12
9 14 6

4
15 12 18 9
10 17 13 8
14 16 11 5

 */

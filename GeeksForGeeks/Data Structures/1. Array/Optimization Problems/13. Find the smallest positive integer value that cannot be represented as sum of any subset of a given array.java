import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    public static int minPossibleNumber(int[] nums) {
        int n = nums.length;
        // Assume given array is sorted
        // Arrays.sort(nums);

        int maxPossible = 0;

        if (n == 0 || nums[0] != 1) {
            return maxPossible + 1; // max possible value if starting number is array is not 1
        }

        maxPossible = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > maxPossible + 1) {
                break;
            }
            maxPossible += nums[i];
        }

        return maxPossible + 1;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Smallest positive integer valuee that cannot be represented as sum of any" +
                " subset of a given array is: " + minPossibleNumber(arr));
    }
}

// Solution: https://ideone.com/qIDHa7

/**
 * Testcases:
 *
 * 6
 * 1 3 6 10 11 15
 *
 * 4
 * 1 1 1 1
 *
 * 4
 * 1 1 3 4
 *
 * 6
 * 1 2 5 10 20 40
 *
 * 6
 * 1 2 3 4 5 6
 */

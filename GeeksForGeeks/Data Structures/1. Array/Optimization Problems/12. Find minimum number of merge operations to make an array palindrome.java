import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static int minMergeOperations(int[] nums) { // O(n)
        int n = nums.length;
        int minMergeOps = 0;

        for (int i = 0, j = n - 1; i <= j; ) {
            if (nums[i] == nums[j]) {
                i++;
                j--;
            } else if (nums[i] > nums[j]) {
                j--;
                nums[j] = nums[j] + nums[j+1];
                minMergeOps++;
            } else {
                i++;
                nums[i] = nums[i] + nums[i-1];
                minMergeOps++;
            }
        }

        return minMergeOps;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Min. no. of merge operations to make an array plalindrome is " + minMergeOperations(arr));
    }
}

// Solution: https://ideone.com/gTSeWN

// TODO: Print final Palindrome

/**
 * Testcases:
 *
 * 4
 * 1 4 5 1
 *
 * 4
 * 11 14 15 99
 *
 * 3
 * 15 4 15
 *
 * 5
 * 1 4 5 9 1
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static int maxEqIndex(int[] nums) { // Time: O(n) and Space: O(1)
        int n = nums.length;

        int index = 0, pre_sum = nums[0], suf_sum = 0;

        // Find suffix_sum at index 0
        for (int i = index; i < n; i++) {
            suf_sum += nums[i];
        }

        // Find prefix_sum and suffix_sum at every index and compare if same then return index
        while (index < n) {
            if (pre_sum == suf_sum) {
                return index;
            }
            suf_sum -= nums[index++];
            if (index >= n) {
                break;
            }
            pre_sum += nums[index];
        }

        return -1;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Equilibrium index of an array is: " + maxEqIndex(arr));
    }
}

// Solution: https://ideone.com/EMuJWX

/*
Testcases:
7
-1 2 3 0 3 2 -1

8
-2 5 3 1 2 6 -4 2

3
1 2 3

7
-7 1 5 2 -4 3 0
*/

// TODO: Extend solution to find all equilibrium indexes

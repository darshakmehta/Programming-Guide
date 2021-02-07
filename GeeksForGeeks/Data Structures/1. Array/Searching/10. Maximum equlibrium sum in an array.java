import java.util.*;
import java.lang.*;
import java.io.*;

class Result {
    int max_sum;
    int index;

    public Result(int max_sum, int index) {
        this.max_sum = max_sum;
        this.index = index;
    }
}

class Solution {
    public static Result maxEqSum(int[] nums) { // Time: O(n) and Space: O(1)
        int n = nums.length;

        int sum = 0, index = 0, pre_sum = nums[0], suf_sum = 0;

        // Find suffix_sum at index 0
        for (int i = index; i < n; i++) {
            suf_sum += nums[i];
        }

        Result result = new Result(0, index);

        // Find prefix_sum and suffix_sum at every index and compare with max_sum
        while (index < n) {
            if (pre_sum == suf_sum && result.max_sum < pre_sum) {
                result.max_sum = pre_sum;
                result.index = index;
            }
            suf_sum -= nums[index++];
            if (index >= n) {
                break;
            }
            pre_sum += nums[index];
        }

        return result;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Result result = maxEqSum(arr);
        System.out.println("Max Equilibrium sum is at index " + result.index + " and max sum is " + result.max_sum);
    }
}

// Solution: https://ideone.com/XPxduT

/*
Testcases:
7
-1 2 3 0 3 2 -1

8
-2 5 3 1 2 6 -4 2
*/

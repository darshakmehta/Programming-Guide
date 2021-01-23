import java.util.*;
import java.lang.*;
import java.io.*;

class Result {
    int max_sum;
    int start;
    int end;
    int len;

    public Result(int max_sum, int start, int end, int len) {
        this.max_sum = max_sum;
        this.start = start;
        this.end = end;
        this.len = len;
    }
}

class Solution
{
    public static Result sizeSubArr(int[] nums) {
        int n = nums.length;
        int max_sum_so_far = 0, max_ending_here = 0, start = 0, end = 0;

        Result result = new Result(0, 0, 0, 0);

        for (int i = 0; i < n; i++) {
            max_ending_here = max_ending_here + nums[i];

            if (max_ending_here < 0) {
                max_ending_here = 0;
                start = i + 1;
            } else {
                max_sum_so_far = Math.max(max_sum_so_far, max_ending_here);
                if (result.max_sum < max_sum_so_far) {
                    result.max_sum = max_sum_so_far;
                    result.start = start;
                    result.end = i;
                }
            }
        }

        result.len = (result.end - result.start) + 1;

        return result;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Result result = sizeSubArr(arr);

        System.out.println("Size of the subarray is: " + result.len + " and Maximum sum is: " + result.max_sum);

        System.out.print("Subarray elements are: ");
        for (int i = result.start; i <= result.end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

// Solution: https://ideone.com/5tC4iS

/**
 * Testcases:
 * 11
 * 2 3 8 -2 -3 4 -1 -2 1 5 -3
 *
 * 8
 * -2 -3 4 -1 -2 1 5 -3
 *
 * 6
 * 1 -2 1 1 -2 1
 */

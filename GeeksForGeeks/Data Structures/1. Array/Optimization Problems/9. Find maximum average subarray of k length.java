import java.util.*;
import java.lang.*;
import java.io.*;

class Result {
    float max_avg;
    int start;
    int end;

    public Result(float max_avg, int start, int end) {
        this.max_avg = max_avg;
        this.start = start;
        this.end = end;
    }
}

class Solution
{
    public static Result maxAvgSubArrayOfLenK(int[] nums, int k) {
        int n = nums.length;
        float K = k; // such that we do not end up INT/INT which will not generate a floating point

        // Initial Calculation for subarray of length k
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Sliding Window Technique to find maximum average subarray of length k
        float max_avg = sum / K;
        int start = 0;
        for (int i = k, j = 0; i < n; i++) {
            sum = sum - nums[j++] + nums[i];
            float temp = sum / K;
            if (temp > max_avg) {
                max_avg = temp;
                start = j;
            }
        }

        return new Result(max_avg, start, start + k);
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Result result = maxAvgSubArrayOfLenK(arr, k);

        System.out.println("Maximum average of subarray of length k is " + result.max_avg);
        System.out.println("Subarray start index is " + result.start + " and end index is " + (result.end - 1));

        System.out.print("Subarray is ");

        for (int i = result.start; i < result.end; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// TODO: Improve time complexity by not calculating average

// Solution: https://ideone.com/aVzmw7

// Note: Division of two integer value will not generate a floating point
// Convert k i.e. k = 4 => float k = 4.0

/**
 * Testcases
 *
 * 7 3
 * 3 -435 335 10 -50 100 20
 *
 * 6 4
 * 1 12 -5 -6 50 3
 */

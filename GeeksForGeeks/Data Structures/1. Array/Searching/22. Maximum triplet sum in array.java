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

class Solution {
    public static int maxTripletSum1(int[] nums) { // Time: O(nlogn)
        int n = nums.length;
        Arrays.sort(nums); // Time: O(nlogn)
        return nums[n - 1] + nums[n - 2] + nums[n -3];
    }

    public static int maxTripletSum2(int[] nums) { // Time: O(n)
        int n = nums.length;
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] > c) {
                a = b;
                b = c;
                c = nums[i];
            } else if (nums[i] > b) {
                a = b;
                b = nums[i];
            } else if (nums[i] > a) {
                a = nums[i];
            }
        }

        return a + b + c;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Maximum triplet sum is: " + maxTripletSum1(arr));

        System.out.println("Maximum triplet sum is: " + maxTripletSum2(arr));
    }
}

// Solution: https://ideone.com/AJpJyx

/*
Testcases:

7
1 2 3 0 -1 8 10

7
9 8 20 3 4 -1 0

6
1 0 8 6 4 2
 */

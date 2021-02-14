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
    public static Result closestSumPairExists(int[] nums, int x) {
        int n = nums.length;

        Result result = new Result(-1, -1, Integer.MAX_VALUE);

        int i = 0, j = n - 1;

        while (i < j) {
            int temp = Math.abs(nums[i] + nums[j] - x);
            if (temp < result.closestDiff) {
                result.closestDiff = temp;
                result.x = nums[i];
                result.y = nums[j];
            }

            if (nums[i] + nums[j] < x) {
                i++;
            } else {
                j--;
            }
        }

        return result;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Result result = closestSumPairExists(arr, x);

        if (result.x == -1 || result.y == -1) {
            System.out.println("Pair closest to sum " + x + " does not exist");
        } else {
            System.out.println("Pair closest to sum: " + x + " exists at index: " + result.x + " and " + result.y);
        }
    }
}

// Solution: https://ideone.com/UyOfPt

/*
Testcases:

6 54
10 22 28 29 30 40

5 15
1 3 4 7 10
 */

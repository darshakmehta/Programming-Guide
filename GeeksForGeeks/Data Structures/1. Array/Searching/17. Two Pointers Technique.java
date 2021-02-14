import java.util.*;
import java.lang.*;
import java.io.*;

class Result {
    int x;
    int y;

    public Result(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


/**
 * Check if pair with Sum "X" exists
 */
class Solution {
    public static Result sumPairExists(int[] nums, int sum) { // Time: O(n)
        int n = nums.length;
        Result result = new Result(-1, -1);

        int i = 0, j = n - 1;
        while (i < j) {
            int temp_sum = nums[i] + nums[j];
            if (temp_sum == sum) {
                result.x = i;
                result.y = j;
                break;
            } else if (temp_sum > sum) {
                j--;
            } else {
                i++;
            }
        }

        return result;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Result result = sumPairExists(arr, sum);

        if (result.x == -1 || result.y == -1) {
            System.out.println("Pair with sum " + sum + " does not exist");
        } else {
            System.out.println("Pair with sum: " + sum + " exists at index: " + result.x + " and " + result.y);
        }
    }
}

// Solution: https://ideone.com/kn8oJ0

/*
Testcases:
7 17
3 5 9 2 8 10 11

7 21
3 5 9 2 8 10 11

7 14
3 5 9 2 8 10 11

7 11
3 5 9 2 8 10 11

7 2
3 5 9 2 8 10 11

7 31
3 5 9 2 8 10 11

7 11
3 5 9 2 9 10 11
 */

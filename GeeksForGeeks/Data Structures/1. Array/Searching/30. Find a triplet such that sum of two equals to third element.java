import java.util.*;
import java.lang.*;
import java.io.*;

class Result {
    int x;
    int y;
    int z;

    public Result(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Solution {
    public static Result tripletSum(int[] nums) { // Time: O(n^2)
        int n = nums.length;
        Arrays.sort(nums);
        Result result = new Result(-1, -1, -1);

        for (int i = n - 1; i >= 0; i--) {
            int j = 0, k = i - 1;

            while (j < k) {

                if (nums[i] == nums[j] + nums[k]) {
                    result.x = nums[i];
                    result.y = nums[j];
                    result.z = nums[k];
                    return result;
                } else if (nums[i] > nums[j] + nums[k]) {
                    j++;
                } else {
                    k--;
                }
            }
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

        Result result = tripletSum(arr);

        if (result.x == -1 && result.y == -1 && result.z == -1) {
            System.out.println("Triplet with sum 0" + " does not exist");
        } else {
            System.out.println("Triplet with sum 0 exists as: " + result.x + " and " + result.y + " and " + result.z);
        }
    }
}


// Solution: https://ideone.com/2ZGWdM

/*
Testcases:

9
5 32 1 7 10 50 19 21 2

9
5 32 1 7 10 50 19 21 0
 */

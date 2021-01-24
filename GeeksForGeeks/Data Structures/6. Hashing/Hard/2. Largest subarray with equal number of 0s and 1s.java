import java.util.*;
import java.lang.*;
import java.io.*;

class Result {
    int max_len;
    int start;
    int end;

    public Result(int max_len, int start, int end) {
        this.max_len = max_len;
        this.start = start;
        this.end = end;
    }
}

class Solution {

    public static Result findLargestSubArr(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int sum = 0;
        Result result = new Result(0, 0, -1);

        // Treat 0 as -1 for optimizing the algorithm
        for (int i = 0; i < n; i++) {
            nums[i] = (nums[i] == 0) ? -1 : 1;
        }

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum == 0) {
                result.max_len = i + 1;
                result.end = i;
            }

            // If curr_sum is seen before,
            // then update max_len if lesser than previous max_len
            if (hmap.containsKey(sum + n)) { // (+ n) bcoz cumulative sum can range between -n tp n
                int temp = i - hmap.get(sum + n);
                if (result.max_len < temp) {
                    result.max_len = temp;
                    result.end = i;
                }
            } else { // Else put this sum in hash table
                hmap.put(sum + n, i);
            }
        }

        // Revert -1 as 0
        for (int i = 0; i < n; i++) {
            nums[i] = (nums[i] == -1) ? 0 : 1;
        }

        result.start = (result.end - result.max_len) + 1;

        return result;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Result result = findLargestSubArr(arr);

        System.out.println("Largest subarray len with equal number of 0's and 1's is: " + result.max_len);

        if (result.end != -1) {
            System.out.print("Subarray elements are: ");
            for (int i = result.start; i <= result.end; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("No such array");
        }
    }
}

// Solution: https://ideone.com/hRJdMI

// Time Complexity: O(n) and Space Complexity: O(n)

/**
 * Testcases:
 * 5
 * 0 0 1 1 0
 *
 * 4
 * 1 1 1 1
 *
 * 7
 * 1 0 1 1 1 0 0
 */

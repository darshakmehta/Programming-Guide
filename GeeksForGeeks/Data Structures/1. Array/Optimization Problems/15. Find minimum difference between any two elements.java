import java.util.*;
import java.lang.*;
import java.io.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution { // O(nlogn)

    public static Pair findMinDiffPair(int[] nums) {
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;

        Pair pair = new Pair(-1, -1);

        Arrays.sort(nums); // O(nlogn)

        for (int i = 1; i < n; i++) {
            int diff = nums[i] - nums[i-1];
            if (diff < minDiff) {
                pair.x = nums[i-1];
                pair.y = nums[i];
                minDiff = diff;
            }
        }

        return pair;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Pair pair = findMinDiffPair(arr);

        System.out.println("Min. Difference pair is " + pair.x + " and " + pair.y);
    }
}

// Solution: https://ideone.com/GnTtSu

/**
 * Testcases:
 * 7
 * 1 19 -4 31 38 25 100
 *
 * 4
 * 30 5 20 9
 *
 * 6
 * 1 5 3 19 18 25
 */

// TODO: O(n) Solution

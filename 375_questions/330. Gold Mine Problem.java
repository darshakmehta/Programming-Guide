import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static int getMaxGold(int[][] gold, int n,  int m) {
        int[][] dp = new int[n][m];

        for (int col = m - 1; col >= 0; col--) {
            for (int row = 0; row < n; row++) {
                int right = (col == m-1) ? 0 : dp[row][col+1];
                int right_up = (row == 0 || col == m-1) ? 0 : dp[row-1][col+1];
                int right_down = (row == n-1 || col == m-1) ? 0 : dp[row+1][col+1];

                dp[row][col] = gold[row][col] + Math.max(right, Math.max(right_up, right_down));
            }
        }

        int maxGold = dp[0][0];
        for (int i = 1; i < n; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }

        return maxGold;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        int gold[][]= {{10, 33, 13, 15},
                {22, 21, 04, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}};

        int m = gold.length, n = gold[0].length;

        System.out.print(getMaxGold(gold, m, n));
    }
}

// Ideone: https://ideone.com/Il4OIe

/**
 * Sample Test data:
 * Input : mat[][] = {{1, 3, 3},
 *                    {2, 1, 4},
 *                   {0, 6, 4}};
 * Output : 12
 * {(1,0)->(2,1)->(1,2)}
 *
 * Input: mat[][] = { {1, 3, 1, 5},
 *                    {2, 2, 4, 1},
 *                    {5, 0, 2, 3},
 *                    {0, 6, 1, 2}};
 * Output : 16
 * (2,0) -> (1,1) -> (1,2) -> (0,3) OR
 * (2,0) -> (3,1) -> (2,2) -> (2,3)
 *
 * Input : mat[][] = {{10, 33, 13, 15},
 *                   {22, 21, 04, 1},
 *                   {5, 0, 2, 3},
 *                   {0, 6, 14, 2}};
 * Output : 83
 */

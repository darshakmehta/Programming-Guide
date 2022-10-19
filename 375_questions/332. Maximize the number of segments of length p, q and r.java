/**
 * Tabulation method
 */
class Solution {
    // Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];

        // Base case
        Arrays.fill(dp, -1);
        dp[0] = 0; // if length of rod is 0, total cuts will be 0

        for (int i = 0; i <= n; i++) {
            // if certain length is not possible
            if (dp[i] == -1) {
                continue;
            }
            if (i + x <= n) {
                dp[i+x] = Math.max(dp[i+x], dp[i]+1);
            }
            if (i + y <= n) {
                dp[i+y] = Math.max(dp[i+y], dp[i]+1);
            }
            if (i + z <= n) {
                dp[i+z] = Math.max(dp[i+z], dp[i]+1);
            }
        }

        return dp[n] == -1 ? 0 : dp[n];
    }
}

/**
 * Recursive Method
 */
class Solution {
    public static int findTotalCut(int n, int x, int y, int z, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE;

        if (x <= n) { // If Possible to make a cut of length x
            a = findTotalCut(n - x, x, y, z, dp);
        }

        if (y <= n) { // If possible to make a cut of length y
            b = findTotalCut(n - y, x, y, z, dp);
        }

        if (z <= n) { // If possible to make a cut of length z
            c = findTotalCut(n - z, x, y, z, dp);
        }

        return dp[n] = 1 + Math.max(Math.max(a, b),c);
    }
    // Function to find the maximum number of cuts.
    public static int maximizeCuts(int n, int x, int y, int z) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int maxTotalCut = findTotalCut(n, x, y, z, dp);

        return maxTotalCut < 0 ? 0 : maxTotalCut;
    }
}

/**
 * TODO:
 * 1. Write solution similar to Minimum Coin Change Problem
 */

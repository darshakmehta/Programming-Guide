/**
 * 2D dp array to store intermediate results.
 * C(n, k) = C(n-1, k-1) + C(n-1, k)
 * C(n, 0) = C(n, n) = 1
 */
class Solution {
    static int nCr(int n, int r) {
        int[][] dp = new int[n+1][r+1];
        int mod = 1000000007;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1 % mod;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % mod;
                }
            }
        }
        return dp[n][r];
    }
}

/**
 * Improvement: 1D array
 */
class Solution {
    static int nCr(int n, int r) {
        int[] dp = new int[r+1];
        int mod = 1000000007;

        // Base case
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, r); j > 0; j--) {
                dp[j] = (dp[j-1] + dp[j]) % mod;
            }
        }
        return dp[r];
    }
}

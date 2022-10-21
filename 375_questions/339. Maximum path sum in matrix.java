class Solution {
    static int maximumPath(int n, int matrix[][]) {
        int[][] dp = new int[n+1][n+1];

        // Base case - include final row
        for (int j = 0; j < n; j++) {
            dp[n-1][j] = matrix[n-1][j];
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
                } else if (j == n-1) {
                    dp[i][j] = matrix[i][j] + Math.max(dp[i+1][j], dp[i+1][j-1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.max(dp[i+1][j], Math.max(dp[i+1][j-1], dp[i+1][j+1]));
                }
            }
        }

        int result = 0;
        for (int j = 0; j < n; j++) {
            result = Math.max(result, dp[0][j]);
        }

        return result;
    }
}

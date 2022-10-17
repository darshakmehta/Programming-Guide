/**
 * 2D Array Solution
 */
static int knapSack(int N, int W, int val[], int wt[]) {
    int[][] dp = new int[N][W + 1];

    for (int i = 0; i < N; i++) {
        for (int j = 1; j <= W; j++) {
            if (i > 0) {
                if (wt[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], Math.max(val[i] + dp[i][j - wt[i]], dp[i - 1][j - wt[i]]));
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            } else {
                if (wt[i] <= j) {
                    dp[i][j] = val[i] + dp[i][j - wt[i]];
                }
            }
        }
    }
    return dp[N-1][W];
}

/**
 * Reduce above 2D array to 1D array solution
 */
static int knapSack(int N, int W, int val[], int wt[]) {
    int[] dp = new int[W+1];

    for (int i = 0; i < N; i++) {
        for (int j = 1; j <= W; j++) {
            if (wt[i] <= j) {
                dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
            }
        }
    }

    return dp[W];
}

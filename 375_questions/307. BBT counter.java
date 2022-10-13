/**
 * Using DP memoization
 */
static long countBT(int h) {
    int MOD = 1000000007;

    long[] dp = new long[h + 1];

    // Base Cases
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= h; i++) {
        dp[i] = (dp[i - 1] * ((2 * dp[i - 2]) % MOD + dp[i - 1]) % MOD) % MOD;
    }

    return dp[h];
}

/**
 * Memory efficient - We can observe that we do not use dp[0] or dp[3] and only depend on dp[1] and dp[2]
 */
static long countBT(int h) {
    int MOD = 1000000007;
    // Base cases
    long dp0 = 1, dp1 = 1, dp2 = 3;

    for (int i = 2; i <= h; i++) {
        dp2 = (dp1 * ((2 * dp0) % MOD + dp1) % MOD) % MOD;

        // update dp0 and dp1
        dp0 = dp1;
        dp1 = dp2;
    }
    return dp2;
}
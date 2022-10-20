class Solution {
    // Function to find minimum number of attempts needed in
    // order to find the critical floor.
    static int eggDrop(int n, int k) { // Time Complexity: O(N*(K^2))
        int[][] dp = new int[n+1][k+1]; // Space Complexity: O(N*K)

        // We need one trial for one floor and
        // 0 trials for 0 floors
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }

        // We always need j trials for one egg
        // and j floors.
        for (int j = 1; j <= k; j++) {
            dp[1][j] = j;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    int res = 1 + Math.max(dp[i-1][x-1], dp[i][j-x]);
                    dp[i][j] = Math.min(dp[i][j], res);
                }
            }
        }
        return dp[n][k];
    }
}

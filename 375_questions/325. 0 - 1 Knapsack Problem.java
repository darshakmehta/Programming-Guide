class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) {
        int[] dp = new int[W+1];

        for (int i = 0; i < n; i++) {
            for (int j = W; j >= 1; j--) {
                if (wt[i] <= j) {
                    dp[j] = Math.max(val[i] + dp[j - wt[i]], dp[j]);
                }
            }
        }
        return dp[W];
    }
}

/**
 * Note: Inner loop is reversed since in 0-1 Knapsack we will include the element for every j >= wt[i].
 * Going from right to left assures we do not include the wt[i] every time j decreases. If we go from left to right
 * we will end up in a situation of including the profit of adding wt[i] for every j.
 */

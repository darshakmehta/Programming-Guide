class Solution {
    public int maxSumIS(int arr[], int n) { // O(n^2)
        // set max. possible sum of subsequence at every index.
        int[] dp = arr.clone();
        int maxSum = dp[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], arr[i] + dp[j]);
                    maxSum = Math.max(maxSum, dp[i]);
                }
            }
        }

        return maxSum;
    }
}

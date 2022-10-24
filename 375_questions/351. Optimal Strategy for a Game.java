/**
 * Using 2-D DP array
 * Time limit exceeds
 * Passes 104/110 test cases https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1
 */

class Solution {
    static class Choice {
        long first;
        long second;

        public Choice(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n) {
        Choice[][] dp = new Choice[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Choice(0, 0);
            }
        }

        for (int diff = 0; diff < n; diff++) {
            for (int i = 0, j = i + diff; j < n; i++, j++) {
                // only one element
                if (i == j) {
                    dp[i][j].first = arr[i];
                    dp[i][j].second = 0;
                } else if (diff == 1) {
                    dp[i][j].first = Math.max(arr[i], arr[j]);
                    dp[i][j].second = Math.min(arr[i], arr[j]);
                } else {
                    if (dp[i+1][j].second + arr[i] > dp[i][j-1].second + arr[j]) {
                        dp[i][j].first = dp[i+1][j].second + arr[i];
                        dp[i][j].second = dp[i+1][j].first;
                    } else {
                        dp[i][j].first = dp[i][j-1].second + arr[j];
                        dp[i][j].second = dp[i][j-1].first;
                    }
                }
            }
        }

        return dp[0][n-1].first;
    }
}

/**
 * Optimizing the number of comparisons: https://www.geeksforgeeks.org/optimal-strategy-for-a-game-set-2/
 * Theory:
 * If we denote the coins collected by us as a positive score of an equivalent amount,
 * whereas the coins removed by our opponent with a negative score of an equivalent amount,
 * then the problem transforms to maximizing our score if we go first.
 * Let us denote dp[i][j] as the maximum score a player can get in the subarray [i . . . j], then
 * dp[i][j] = max(arr[i]-dp[i+1][j], arr[j]-dp[i][j-1])
 */

class Solution  {
    // Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n) {
        long[][] dp = new long[n][n];
        long sum = 0;

        for (int i = n - 1; i >= 0; i--) {
            sum += arr[i];
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = arr[i];
                } else {
                    dp[i][j] = Math.max(arr[i] - dp[i+1][j], arr[j] - dp[i][j-1]);
                }
            }
        }

        return (sum + dp[0][n-1])/2;
    }
}

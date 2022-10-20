class Solution {
    public int maxChainLength(Pair arr[], int n) { // Time complexity: O(n^2)
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.x - b.x;
            }

        });
        int[] dp = new int[n];

        // base case
        Arrays.fill(dp, 1);
        int result = dp[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i].x > arr[j].y) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    result = Math.max(result, dp[i]);
                }
            }
        }

        return result;
    }
}

/**
 * TODO:
 * 1. Write a solution similar to Activity Selection Problem
 */

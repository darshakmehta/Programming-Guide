class Solution {
    public int lengthOfLIS(int[] nums) { // O(n^2)
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            // initialize min. length of sequence at all indexes to 1
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // can you add current element at index i to the sequence at index j
                // if yes, compare (sequence length at index i, 1 + length of sequence at index j)
                // choosee the max
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int length = 1; // Minimum length of a subsequence

        for (int i = 0; i < n; i++) {
            if (dp[i] > length) {
                length = dp[i];
            }
        }

        return length;
    }
}

/**
 * TODO: DP with Binary Search - O(n log n)
 * TODO: Print Actual Solution
 */

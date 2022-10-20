class Solution {
    public int lengthOfLIS(int[] nums) { // O(n^2)
        int len = nums.length;
        int[] dp = new int[len];
        int result = 1;

        // initialize min. length of sequence at all indexes to 1
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    result = Math.max(result, dp[i]);
                }
            }
        }

        return result;
    }
}

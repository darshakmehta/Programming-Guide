class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 != 0) { // odd sum - partition not possible
            return false;
        }
        sum = sum / 2;

        boolean[] dp = new boolean[sum+1];
        dp[0] = true; // Base case: empty subset has a sum of 0 so true.

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
            // Once we find a subset we can break out
            if (dp[sum]) {
                return true;
            }
        }

        return dp[sum];
    }
}

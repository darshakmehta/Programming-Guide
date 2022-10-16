/**
 * Bottom Up Approach
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        // Base case
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}

/**
 * Top down Approach
 */
class Solution {
    public int getCombCount(int[] nums, int target, int[] dp) {
        if (dp[target] != -1) {
            return dp[target];
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                result += getCombCount(nums, target - nums[i], dp);
            }
        }

        dp[target] = result;
        return result;
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);

        // Base case
        dp[0] = 1;

        return getCombCount(nums, target, dp);
    }
}

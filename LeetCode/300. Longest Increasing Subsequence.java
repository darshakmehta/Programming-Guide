class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        int n = nums.length;
        int dp[] = new int[n];
        
        for(int i = 0; i < n; i++) dp[i] = 1;
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= i - 1; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(max < dp[i])
                max = dp[i];
        }
        return max;
        
    }
}

/***

TODO: DP with Binary Search 

***/
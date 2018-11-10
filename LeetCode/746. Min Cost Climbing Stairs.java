class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for(int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }   
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}

/* Space Optimized */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = cost[0], b = cost[1];
        for(int i = 2; i < cost.length; i++) {
            int c = Math.min(a, b) + cost[i];
            a = b;
            b = c;
        }    
        return Math.min(a, b);
    }
}
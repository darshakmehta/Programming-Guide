class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums)
            sum += i;
        
        if(sum % 2 != 0) return false;
        sum = sum / 2;
        
        boolean subset[][] = new boolean[n + 1][sum + 1];
        for(int i = 0; i <= n; i++) 
            subset[i][0] = true;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(j < nums[i - 1]) {
                    subset[i][j] = subset[i - 1][j];
                } else {
                    subset[i][j] = subset[i - 1][j] || subset[i - 1][j - nums[i - 1]];
                }
            }
        }
        return subset[n][sum];
    }
}

/* Space optimized */
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums)
            sum += i;

        if(sum % 2 != 0) return false;
        sum = sum / 2;

        boolean[] dp = new boolean[sum+1];
        dp[0] = true; //Base case: dp[0] is true; (zero number consists of sum 0 is true)

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                    dp[j] = dp[j] || dp[j-nums[i]];
            }
        }

        return dp[sum];
    }
    /* Optimize further: leetcode.com/problems/partition-equal-subset-sum/discuss/90627/Java-Solution-similar-to-backpack-problem-Easy-to-understand/95087 */
}

/**

Question
1. In your 1d DP array solution, why did you let i go from the right instead of left?
Answer:

The reason is that we have to get dp[i] from its previous loop dp[i-1]

dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]]

As for

for (int num: nums){
   for (int i = sum; i>0; i--){
      if (i>=num)
         dp[i] = dp[i] || dp[i-num]
    }
}
Every loop of nums refreshes dp array. We might get dp[i] from dp[i-num] whose index is smaller than i. If we increase the index of sum from 0 to sum, we will get dp[i] from dp[i-num] , while dp[i-num] has been updated in this loop. This dp[i-num] is not the number we got from the previous loop.

So why would we do this? This is because the numbers in nums can only be used once. If we can choose each number several times, we have to increase i from 0 to sum. Which means, if we are going to choose dp[i], we have to consider the situation where dp[i] has been chosen before. In this case, dp[i] is updated from dp[i-num] which is in the same loop with dp[i]. This dp[i-num] we use is a kind of result where dp[i] has been chosen.

P.S. if we go from left to right, the dp[i - num] has been updated with current iteration and the status from last iteration is lost.
**/

/***

Similar to:
1. 0/1 Knapsack or 0/1 Backpack Problem

***/
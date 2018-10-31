class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int i : nums)
            sum += i;
        
        if(S > sum || (sum + S) % 2 == 1)   return 0; //Not possible
        return subsetSum(nums, (sum + S) / 2); //Partition sum
    }

    private int subsetSum(int[] nums, int S){
        int[] dp = new int[S + 1];
        dp[0] = 1; 
        for (int i = 0; i < nums.length; i++) {
            for (int j = S; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[S];
    }
}

/***

The original problem statement is equivalent to:
Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target

Let P be the positive subset and N be the negative subset
For example:
Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]

Then let's see how this can be converted to a subset sum problem:

                  sum(P) - sum(N) = target
sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
                       2 * sum(P) = target + sum(nums)
So the original problem has been converted to a subset sum problem as follows:
Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2

Note that the above formula has proved that target + sum(nums) must be even
Now, follow canPartition solution by checking sum % 2 == 0 

Reference: https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C++-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation

***/

/**

TODO:
1. DFS Slution: https://leetcode.com/problems/target-sum/discuss/97333/Java-simple-DFS-with-memorization

**/
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
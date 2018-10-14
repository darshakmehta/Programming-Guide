class Solution {
    public int rob(int[] nums) {
        int robbed = 0; // If robbed Current house
        int notrobbed = 0; // If not robbed current house
        
        for(int i = 0; i < nums.length; i++) {
            int currrobbed = notrobbed + nums[i]; //if current house is robbed, previous house should not be robbed
            
            int currnotrobbed = Math.max(robbed, notrobbed); // if current house is not robbed, consider max of robbed and notrobbed until this stage
            
            // update robbed and notrobbed until this stage now
            robbed = currrobbed; 
            notrobbed = currnotrobbed;
        }
        return Math.max(robbed, notrobbed); // return max
    }
}
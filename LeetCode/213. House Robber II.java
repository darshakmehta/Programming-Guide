class Solution {
    
    public int rob(int[] nums, int low, int high) {
        int robbed = 0; // If robbed Current house
        int notrobbed = 0; // If not robbed current house
        
        for(int i = low; i < high; i++) {
            int currrobbed = notrobbed + nums[i]; //if current house is robbed, previous house should not be robbed
            
            int currnotrobbed = Math.max(robbed, notrobbed); // if current house is not robbed, consider max of robbed and notrobbed until this stage
            
            // update robbed and notrobbed until this stage now
            robbed = currrobbed; 
            notrobbed = currnotrobbed;
        }
        return Math.max(robbed, notrobbed); // return max
    }

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0]; //only 1 element
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
        
    }
}
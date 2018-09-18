class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int consecutiveOne = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                consecutiveOne++;
                max = Math.max(max, consecutiveOne);
            } else {
                consecutiveOne = 0;
            }
        }
        return max;
    }
}
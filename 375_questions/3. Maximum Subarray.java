class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int currMax = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < n; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }
}

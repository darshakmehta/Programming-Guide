class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastIndex = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= lastIndex) {
                lastIndex = i;
            }
        }

        return lastIndex == 0;
    }
}

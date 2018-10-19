public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}

public class Solution {
	public boolean canJump(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++){
            if (i > max) return false;
            max = Math.max(nums[i] + i, max); 
        }
        return true; 
	}
}
// Checks every index of the array
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


// Below solution saves extra traversal time

class ImprovedSolution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            // When you are stuck at one position
            if (i > max) return false;

            max = Math.max(max, i + nums[i]);
            // When you have already arrived at solution
            if (max >= n - 1) return true;
        }

        return true;
    }
}

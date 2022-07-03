class Solution {
    public int trap(int[] height) { // Time: O(n) and Space: O(1)
        int n = height.length;
        int left = 0, right = n - 1;
        int maxLeft = 0, maxRight = 0;
        int trapWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    trapWater += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    trapWater += maxRight - height[right];
                }
                right--;
            }
        }
        return trapWater;
    }
}

/**
Explanation: https://leetcode.com/problems/trapping-rain-water/discuss/153992/Java-O(n)-time-and-O(1)-space-(with-explanations).
**/

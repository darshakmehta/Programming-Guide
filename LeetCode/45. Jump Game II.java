class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if (n <= 1) {
            return 0;
        }

        int currEnd = 0; // End index of the window
        int currFarthest = 0; // Initial size of the window
        int minJump = 0;

        for (int i = 0; i < n; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]); // Maximum possible index we can reach from current window

            if (currFarthest >= n - 1) { // Jump once we can reach to the last index
                minJump++;
                break;
            }

            if (i == currEnd) { // Jump once we completely traverse the current window
                currEnd = currFarthest; // Resize the window to the current farthest point
                minJump++;
            }

        }

        return minJump;
    }
}

/**
 * [currBeg, currEnd] => Window. Note: Here, currBeg == i
 * Find currFarthest you can reach from current window elements
 * Jump and Break since we can reach to the last index when currFarthest >= n - 1
 * Jump when i == currEnd, and update currEnd to currFarthest
 */

class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // O(N): n log n

        if (nums.length <= 1) {
            return 0;
        }

        int result = nums[1] - nums[0];

        for (int i = 1; i < n - 1; i++) {
            result = Math.max(result, Math.max(nums[i] - nums[i - 1], nums[i + 1] - nums[i]));
        }

        return result;
    }
}

// TODO: Linear Time Solution

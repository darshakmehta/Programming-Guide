class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
        int j = 0;
        for(int i = j; i < nums.length; i++) {
            start = i;
            for(j = i; j < nums.length - 1; j++) {
                if(nums[j] >= nums[j + 1]) {
                    break;
                }
            }
            max = Math.max(max, j - start);
            if(max > nums.length / 2)
                break;
        }
        return max + 1;
    }
}

/* Sliding Window */

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int result = 0, start = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i-1] < nums[i]) result = Math.max(result, ++start);
            else start = 1;
        }
        return result;
    }
}
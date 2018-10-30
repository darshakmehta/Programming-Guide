class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null) return 0;
        if(target <= nums[0]) return 0; //avoid corner cases
        if(target > nums[nums.length - 1]) return nums.length; //avoid corner cases
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= target) return i; //linear solution
        }
        return 0;
    }
}

/***

TODO: Binary Search

***/
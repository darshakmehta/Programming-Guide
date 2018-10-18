class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}


/***

TODO:

1. Priority Queue
2. Heap Sort
3. Quick Sort | Quick Select

***/
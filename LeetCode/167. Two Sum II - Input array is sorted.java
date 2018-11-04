class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] result = new int[2];
        int low = 0, high = nums.length - 1;
        while(nums[low] + nums[high] != target) {
            if(nums[low] + nums[high] < target)
                low++;
            else
                high--;
        }
        return new int[]{low + 1, high + 1};
    }
}

/***

Since array is sorted, we do not require hashmap

**/
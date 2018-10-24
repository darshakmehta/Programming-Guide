class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high) {
            if(nums[low] > nums[high]) low++;
            else if(nums[low] < nums[high]) high--;
        }
        return nums[low];
    }
}
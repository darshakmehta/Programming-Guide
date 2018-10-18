class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if(nums.length == 0) return result;
        int low = 0, high = nums.length - 1;
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            
            if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if(nums[low] != target)
            return result;
        result[0] = low;
        
        high = nums.length - 1;
        while(low < high) {
            int mid = (low + high) / 2 + 1;
            
            if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        result[1] = high;
        return result;
    }
}
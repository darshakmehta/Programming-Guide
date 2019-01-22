class Solution {
    public int search(int[] nums, int target) {
        
        int i = 0;
        int low = 0, high = nums.length - 1;
        while ( low <= high ) {
            int mid = low + (high - low) / 2;
            
            if ( nums[mid] == target ) {
                return mid;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return -1;
    }
}
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

class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length - 1;
        
        while ( low <= high ) {
            int mid = low + (high - low) / 2;
            
            if ( nums[mid] == target ) {
                return mid;
            }

            if ( nums[mid] > target ) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return low;
    }
}
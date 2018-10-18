class Solution { //Iterative
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        while(low < high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = mid1 + 1;
            if(nums[mid1] < nums[mid2]) 
                low = mid2;
            else
                high = mid1;
        }
        
        return low;
    }
}

class Solution { //Recursive
    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    public int helper(int[] nums, int low, int high) {
        if(low == high) return low;
        int mid1 = low + (high - low) / 2;
        int mid2 = mid1 + 1;
        if(nums[mid1] < nums[mid2]) 
            return helper(nums, mid2, high);
        else
            return helper(nums, low, mid1);
    }
}

class Solution { //Sequential Search
    public int findPeakElement(int[] nums) {
        
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) return i;
        }
        return nums.length - 1;
    }
}
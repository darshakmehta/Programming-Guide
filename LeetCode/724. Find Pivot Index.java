class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 0) return -1;
        
        int n = nums.length;
        int[] leftsum = new int[n], rightsum = new int[n];
        
        leftsum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            leftsum[i] += nums[i] + leftsum[i - 1];
        }
        
        rightsum[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            rightsum[i] += nums[i] + rightsum[i + 1];
        }
        
        if(rightsum[1] == 0)
            return 0;
        
        for(int i = 0; i < n - 2; i++) {
            if(leftsum[i] == rightsum[i + 2]) {
                return i + 1;
            }
        }
        
        if(leftsum[n - 2] == 0)
            return n - 1;
        
        
        return -1;
    }
}

/* Faster Solution 14ms 100% solution */

class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 0) return -1;
        
        int n = nums.length;
        int totalsum = 0, leftsum = 0;
        
        for(int i : nums)
            totalsum += i;
        
        for(int i = 0; i < n; i++) {
            if(leftsum == (totalsum - nums[i]))
                return i;
            else {
                leftsum += nums[i];
                totalsum -= nums[i];
                
            }
        }
        
        return -1;
    }
}
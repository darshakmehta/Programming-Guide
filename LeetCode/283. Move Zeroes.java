/***
Running time: O(N^2) where N = number of elements
***/

class Solution {
    public void moveZeroes(int[] nums) {
        int j;
        for(int i = nums.length-1; i>=0; i--) {
            if(nums[i] == 0) {
                for( j = i; j < nums.length - 1; j++) {
                    
                    nums[j] = nums[j+1];
                }
                nums[j] = 0;
            }
        }
        
    }
} 
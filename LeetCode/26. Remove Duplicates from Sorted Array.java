class Solution {
    
    public int removeDuplicates(int[] nums) {
        
        int head = 1;
        if(nums.length < 2)
            return nums.length;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] != nums[i]) 
                nums[head++] = nums[i];
        }
        
        return head;
    }
}
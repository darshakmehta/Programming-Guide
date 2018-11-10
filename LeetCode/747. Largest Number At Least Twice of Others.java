class Solution {
    public int dominantIndex(int[] nums) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        int largest = 0;
        int secondLargest = 1;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[largest]) {
                secondLargest = largest;
                largest = i;
            } else if(nums[i] != nums[largest] && nums[i] > nums[secondLargest]){
                secondLargest = i;
            }
        }
        
        if(nums[secondLargest] * 2 <= nums[largest])
            return largest;
        return -1;
    }
}
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int begin = -1, end = -2;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]); //find the maximum element from start
            if(nums[i] < max)
                end = i;
        }
        
        for(int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]); //find the minimum element from end
            if(nums[i] > min)
                begin = i;
        }
        //System.out.println(end + " " + begin);
        return end - begin + 1;
    }
}
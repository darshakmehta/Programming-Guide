class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int x = nums.length/2;
        int sum = 0;
        for(int i = 0; i < nums.length - 1; i+=2) {
            sum += Math.min(nums[i], nums[i+1]);
        }
        
        return sum;
    }
}

/* Logic - Removed n/2 calls to Math.min, since our each pair will be selected from even index */
class Solution { //Improved by 45% to 93%
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums); //Can go to 100% by better sort algorithm
        
        int x = nums.length/2;
        int sum = 0;
        for(int i = 0; i < nums.length - 1; i+=2) {
            sum += nums[i]; //Removed n/2 calls to Math.min
        }
        
        return sum;
    }
}


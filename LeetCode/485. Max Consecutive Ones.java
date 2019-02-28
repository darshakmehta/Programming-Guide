class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int consecutiveOne = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                consecutiveOne++;
                max = Math.max(max, consecutiveOne);
            } else {
                consecutiveOne = 0;
            }
        }
        return max;
    }
}

/* Since the test case will have maximum 1's so, I am finding max when I find a zero to optimize code */
class Solution { //Improves 100%
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int consecutiveOne = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                consecutiveOne++;
            } else {
                if(consecutiveOne > max) max = consecutiveOne;
                consecutiveOne = 0;
            }
        }
        if(max > consecutiveOne) // Removed Math.max call to improve to 100%
            return max;
        return consecutiveOne; //For corner case only one element [1]
    }
}
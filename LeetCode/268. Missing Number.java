class Solution { //Incorrect but accepted
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                break;
            }
        }
        return i;
        
    }
}

class Solution { //Correct takes care of first and last element cases
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;

         // Ensure that n is at the last index
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }

        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                break;
            }
        }
        return i;
        
    }
}


//Faster Solution without sorting

class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for(int i = 0; i < nums.length; i++) {
            missing = missing - nums[i] + i; 
        }
        return missing;
    }
}

//In other words, sum of 0 to n elements subtracted by all the elements will give the missing number

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = (n * (n + 1))/2;
        for(int i = 0; i < nums.length; i++) {
            missing = missing - nums[i];
        }
        return missing;
    }
}

/***

TODO:

1. Using Bit Manipulation - XOR
2. Using Gauss Formula

***/
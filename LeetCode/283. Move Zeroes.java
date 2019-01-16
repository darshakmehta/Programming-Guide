class Solution { /*** Running time: O(N^2) where N = number of elements ***/
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

class Solution { //Efficient Solution - 100%
    
    public void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        while(fast < nums.length) {
            if(nums[fast] != 0) {
                if(slow != fast)
                    swap(nums, slow, fast);
                slow++;
                fast++;
            } else {
                fast++;
            }
        }
    }
}

class Solution { //Slower
    
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        while(fast < nums.length) {
            if(nums[fast] != 0) {
                if(slow != fast)
                    nums[slow] = nums[fast];
                slow++;
                fast++;
            } else {
                fast++;
            }
        }
        while(slow < nums.length) {
            nums[slow++] = 0;
        }
    }
}

class Solution {
    
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        while(fast < nums.length) {
            if(nums[fast] != 0) {
                if(slow != fast) {
                    nums[slow] = nums[fast];
                    nums[fast] = 0;
                }
                    
                slow++;
                fast++;
            } else {
                fast++;
            }
        }
    }
}

/*** 

TODO: Do not use swapping --> Completed - Check solution 3
Note: Swapping is faster than looping through fast and slow for O(n) in worst case
***/
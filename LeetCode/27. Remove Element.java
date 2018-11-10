class Solution { //Beats 100%
    public void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public int removeElement(int[] nums, int val) {
        int slow = 0, count = 0;
        for(int i = 0; i <  nums.length; i++) {
            if(nums[i] != val) {
                swap(nums, slow++, i);
            } else {
                count++;
            }
        }
        return nums.length - count;
    }
}

/* Shorter version */

class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0, count = 0;
        for(int i = 0; i <  nums.length; i++) {
            if(nums[i] != val) {
                nums[slow++] = nums[i];
                count++;
            }
        }
        return count;
    }
}
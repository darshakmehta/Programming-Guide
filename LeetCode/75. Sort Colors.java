class Solution {
    
    public void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public void sortColors(int[] nums) {
        if(nums.length == 0) return;
        
        int start = 0, end = nums.length - 1;
        for(int i = start; i <= end; ) {
            if(nums[i] == 0) {
                swap(nums, i, start);
                start++;
                i++;
            } else if(nums[i] == 2) {
                swap(nums, i, end);
                end--;
            } else 
                i++;
        }
        
    }
}

class Solution {
    public void sortColors(int A[], int n) { //Brilliant Solution
        int red = -1, white = -1, blue = -1;
        for (int i = 0; i < n; ++i) {
            if (A[i] == 0) //red

                A[++blue] = 2; A[++white] = 1; A[++red] = 0;
            else if (A[i] == 1) 
                A[++blue] = 2; A[++white] = 1;
            else if (A[i] == 2) 
                A[++blue] = 2;
        }
    }
}




/***

Two pass algorithm: Count number of red, white, blue and fill the array with that many count


References: https://leetcode.com/problems/sort-colors/discuss/26500/Four-different-solutions

***/
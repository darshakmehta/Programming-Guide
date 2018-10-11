class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int []copy = new int[n];
        int pos = k % n;
        
        //System.arraycopy(nums, pos, copy, 0, n - pos); //left rotation
        System.arraycopy(nums, n - pos, copy, 0, pos);
       
        //System.arraycopy(nums, 0, copy, n - pos, pos); //left rotation
        System.arraycopy(nums, 0, copy, pos, n - pos);

        System.arraycopy(copy, 0, nums, 0, n);
    }
}

class Solution { //efficient
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int x = k % n;
        int copy[] = new int[n];
        if(x != 0) { //efficient 
            System.arraycopy(nums, 0, copy, x, n - x);
            System.arraycopy(nums, n - x, copy, 0, x);
            System.arraycopy(copy, 0, nums, 0, n);
        }
    }
}
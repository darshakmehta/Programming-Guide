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

/* Juggling Algorithm */

class Solution {
    public int gcd(int a, int b) { 
        if (b == 0) 
            return a; 
        else
            return gcd(b, a % b); 
    } 
    
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int x = gcd(k, n);

        if(nums == null || nums.length == 1) return;
        for ( int i = 0; i < x; i++ ) {
            
            int temp = nums[n - i - 1];
            int j = n - i - 1;
            while( true ) {
                int d = j - k;
                if( d < 0 ) d += n;
                if ( d == n - i - 1) break;
                nums[j] = nums[d];
                j = d;
            }
            nums[j] = temp; 
        }
    }
}
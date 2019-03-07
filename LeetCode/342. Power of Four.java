class Solution {
    public boolean isPowerOfFour(int num) {
        int x = (int) (Math.log(num) / Math.log(4));
        
        if ( x == Math.log(num) / Math.log(4) ) {
            return true;
        }

        return false;
    }
}
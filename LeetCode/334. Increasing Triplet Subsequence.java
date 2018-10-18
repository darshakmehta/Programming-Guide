class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        
        for(int n : nums) {
            if(n <= min) min = n;
            else if(n <= secondMin) secondMin = n;
            else return true;
        }
        return false;
    }
}
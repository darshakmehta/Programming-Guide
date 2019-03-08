class Solution {
    public int thirdMax(int[] nums) {
        
        Integer firstMax = null, secondMax = null, thirdMax = null;

        for ( Integer num : nums ) {
            if ( num.equals(firstMax) || num.equals(secondMax) || num.equals(thirdMax) ) continue;
            if ( firstMax == null || num > firstMax ) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if ( secondMax == null || num > secondMax ) {
                thirdMax = secondMax;
                secondMax = num;
            } else if ( thirdMax == null || num > thirdMax ) {
                thirdMax = num;
            }
        }
        
        return thirdMax == null ? firstMax : thirdMax;
    }
}
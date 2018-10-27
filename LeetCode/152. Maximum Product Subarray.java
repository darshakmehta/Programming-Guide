class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        // store the result that is the max we have found so far
	    int result = nums[0];

	    // imax/imin stores the max/min product of
	    // subarray that ends with the current number nums[i]
	    for (int i = 1, imax = result, imin = result; i < n; i++) {
	        // multiplied by a negative makes big number smaller, small number bigger
	        // so we redefine the extremums by swapping them
	        if (nums[i] < 0) {
	        	int temp = imax;
	        	imax = imin;
	        	imin = temp;
	        }      

	        // max/min product for the current number is either the current number itself
	        // or the max/min by the previous number times the current one
	        imax = Math.max(nums[i], imax * nums[i]);
	        imin = Math.min(nums[i], imin * nums[i]);

	        // the newly computed max value is a candidate for our global result
	        result = Math.max(result, imax);
	    }
	    return result;
    }
}

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
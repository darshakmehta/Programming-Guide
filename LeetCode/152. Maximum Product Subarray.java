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

// Similar to above solution
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

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prod = 1;
        int result = Integer.MIN_VALUE;

        // First pass: traverse from left to right
        // Note: If even number of negative numbers, then first pass result is final result
        for (int i = 0; i < n; i++) {
            prod = prod * nums[i];
            result = Math.max(prod, result); // max_product_so_far

            if (prod == 0) {
                prod = 1; // reset prod = 1 to multiplying remaining elements
            }
        }

        prod = 1;
        // Second Pass: traverse from right to left
        // Possible solution can be either from left or right side
        // So, If odd number of negative numbers, then second pass to find product from right side
        for (int i = n - 1; i >= 0; i--) {
            prod = prod * nums[i];
            result = Math.max(prod, result); // compare with max_product_so_far from first pass

            if (prod == 0) {
                prod = 1; // reset prod = 1 to multiplying remaining elements
            }
        }

        return result;
    }
}

// Note: Multiplying forward vs. backward will result in different intermediate products but final result is same

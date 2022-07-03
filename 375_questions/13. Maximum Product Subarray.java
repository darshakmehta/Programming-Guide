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

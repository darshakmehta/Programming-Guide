class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double K = k; // such that we do not end up INT/INT which will not generate a floating point

        // Initial Calculation for subarray of length k
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Sliding Window Technique to find maximum average subarray of length k
        double max_avg = sum / K;
        int start = 0;
        for (int i = k, j = 0; i < n; i++) {
            sum = sum - nums[j++] + nums[i];
            double temp = sum / K;
            if (temp > max_avg) {
                max_avg = temp;
                start = j;
            }
        }

        return max_avg;
    }
}


// Improvement: No need to calculate average each time

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        // Initial Calculation for subarray of length k
        int max_sum = 0;
        for (int i = 0; i < k; i++) {
            max_sum += nums[i];
        }

        int curr_sum = max_sum;
        // Sliding Window Technique to find maximum average subarray of length k
        for (int i = k, j = 0; i < n; i++, j++) {
            curr_sum  = curr_sum - nums[j] + nums[i];
            max_sum = Math.max(max_sum, curr_sum);
        }

        return ((max_sum * 1.0)/k);
    }
}
